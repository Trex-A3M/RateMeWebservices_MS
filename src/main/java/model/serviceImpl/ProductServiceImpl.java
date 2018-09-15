package model.serviceImpl;

import model.dao.BaseDao;
import model.dao.ProductDao;
import model.entity.Product;
import model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import util.DateUtil;

import java.util.ArrayList;
import java.util.List;

@Service("ProductService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Qualifier("ProductDao")
    @Autowired
    ProductDao productDao;

    @Override
    public BaseDao getDao() {
        return productDao;
    }

    public List<String> getProductsByName(String letter) {
        List<String> res = new ArrayList<String>();
        List<Product> list = getListByField("Name", letter);
        for (Product product : list
                ) {
            res.add(product.getName());
        }
        return res;
    }

    public int saveProduct(Product product) {
        product.setCreateTime(DateUtil.getCurrentDateTime());
        product.setUpdateTime(DateUtil.getCurrentDateTime());
        return baseDao.save(product);
    }

    public List<String> getNameByPhrase(String colName, String phrase) {
        List<String> res = new ArrayList<String>();
        List<Product> list = getListByPhrase(colName, phrase);
        for (Product p : list
                ) {
            res.add(p.getName());
        }
        return res;
    }

    @Override
    public List getAll() {
        return super.getAll();
    }
}
