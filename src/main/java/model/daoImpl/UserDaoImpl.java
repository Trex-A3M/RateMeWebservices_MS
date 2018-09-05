package model.daoImpl;

import model.dao.UserDao;
import model.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
