package webservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProductProvider {

    @RequestMapping("/all")
    public String getProducts(@RequestParam(name = "name") String name) {
        return "hello " + name;
    }
}
