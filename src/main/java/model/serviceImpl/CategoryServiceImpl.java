package model.serviceImpl;

import model.dao.BaseDao;
import model.dao.CategoryDao;
import model.entity.Category;
import model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import util.DateUtil;

import java.util.List;

@Service("CategoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

    @Qualifier("CategoryDao")
    @Autowired
    CategoryDao categoryDao;

    @Override
    public BaseDao getDao() {
        return categoryDao;
    }

    public int saveCategory(Category category) {
        category.setCreateTime(DateUtil.getCurrentDateTime());
        return categoryDao.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }
}
