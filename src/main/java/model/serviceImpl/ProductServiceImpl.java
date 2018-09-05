package model.serviceImpl;

import model.dao.BaseDao;
import model.dao.ProductDao;
import model.entity.Product;
import model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ProductService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Qualifier("ProductDao")
    @Autowired
    ProductDao productDao;

    @Override
    public BaseDao getDao() {
        return productDao;
    }


}
