package model.daoImpl;

import model.dao.CategoryDao;
import model.entity.Category;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("CategoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

    public CategoryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}