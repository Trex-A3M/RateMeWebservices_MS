package model.daoImpl;

import model.dao.CategoryDao;
import model.dao.ProductDao;
import model.entity.Category;
import model.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("ProductDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

    public ProductDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}