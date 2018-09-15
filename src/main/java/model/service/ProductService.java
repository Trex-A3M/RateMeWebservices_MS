package model.service;

import model.entity.Product;

import java.util.List;


public interface ProductService extends BaseService<Product> {
    int saveProduct(Product product);

    List<String> getNameByPhrase(String colName, String phrase);
}
