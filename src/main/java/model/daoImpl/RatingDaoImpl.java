package model.daoImpl;

import model.dao.CategoryDao;
import model.dao.RatingDao;
import model.entity.Category;
import model.entity.Rating;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("RatingDao")
public class RatingDaoImpl extends BaseDaoImpl<Rating> implements RatingDao {

    public RatingDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}