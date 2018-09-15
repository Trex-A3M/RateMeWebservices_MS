package webservice;

import model.entity.Product;
import model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductProvider {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getprodbyphrase")
    public List<String> getProductsByPhrase(@RequestParam(name = "phrase") String phrase) {
        List<String> list = productService.getNameByPhrase("Name", phrase);
        return list;
    }

    @RequestMapping(value = "/save_product")
    public int saveProduct(@RequestParam(name = "name") String name,
                           @RequestParam(name = "cat_id") int cat_id) {
        Product product = new Product();
        product.setName(name);
        product.setCat_id(cat_id);
        return productService.saveProduct(product);
    }
}
