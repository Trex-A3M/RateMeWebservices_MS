package webservice;

import model.entity.Category;
import model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryProvider {

    @Qualifier("CategoryService")
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/save_cat")
    public int saveCategory(@RequestParam(name = "name") String name) {
        Category cat = new Category();
        cat.setName(name);
        return categoryService.saveCategory(cat);
    }

    @RequestMapping(value = "/get_cats")
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.getAll();
        return categories;
    }
}
