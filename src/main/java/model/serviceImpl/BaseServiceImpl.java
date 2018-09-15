package model.serviceImpl;

import model.dao.BaseDao;
import model.service.BaseService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {


    BaseDao baseDao;

    @PostConstruct
    public void init() {
        baseDao = getDao();
    }

    public abstract BaseDao getDao();

    public void saveEntity(T t) {
        baseDao.save(t);
    }

    public List getAll() {
        return baseDao.getAll();
    }

    public void deleteEntity(T t) {
        baseDao.delete(t);
    }

    public T getInstanceByField(String colName, String value) {
        return (T) getDao().getInstanceByField(colName, value);
    }

    public List<T> getListByField(String colName, String value) {
        return getDao().getListByField(colName, value);
    }

    public List<T> getListByPhrase(String colName, String phrase) {
        return baseDao.getListByPhrase(colName, phrase);

    }
    public T getEntityById(T t, int id) {
        return (T) getDao().getById(t, id);
    }
}
