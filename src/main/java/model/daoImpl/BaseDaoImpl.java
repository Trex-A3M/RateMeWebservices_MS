package model.daoImpl;

import model.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository("BaseDao")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> clazz;
    public Session session;

    public SessionFactory sessionFactory;


    public Session getSession() {
        return sessionFactory.openSession();
    }

    @Autowired
    public BaseDaoImpl(SessionFactory sessionFactory) {
        try {
            this.sessionFactory = sessionFactory;
            this.session = sessionFactory.getCurrentSession();
            clazz = (Class) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<T> getListByPhrase(String colName, String phrase) {
        try {
            session = getSession();
            Query query = session.createQuery("from " + clazz.getCanonicalName() + " where " + colName + " like :phrase");
            query.setParameter("phrase", "%" + phrase + "%");
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public int save(T t) {
        try {
            session = getSession();
            int res = ((Integer) session.save(t));
            session.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<T> getAll() {
        session = getSession();
        List<T> list = session.createQuery("from " + clazz.getCanonicalName()).list();
        session.close();
        return list;
    }

    public void delete(T t) {
        session.delete(t);
    }

    public T getInstanceByField(String tableColName, String value) {
        session = getSession();
        Transaction transaction = session.beginTransaction();
        T result = (T) session.createQuery("from " + clazz.getCanonicalName() + " where " + tableColName + " = :val").setParameter("val", value).list().get(0);
        transaction.commit();
        session.close();
        return result;
    }

    public List<T> getListByField(String tableColName, String value) {
        List<T> list;
        session = getSession();
        Transaction transaction = session.beginTransaction();
        list = (List<T>) session.createQuery("from " + clazz.getCanonicalName()
                + " where " + tableColName + " = :val").setParameter("val", value).list();
        transaction.commit();
        session.close();
        return list;
    }

    public void update(T t) {
        session.update(t);
    }

    public T getById(T t, int id) {
        return session.get(clazz, id);
    }
}
