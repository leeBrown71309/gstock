package nazeem.web.controller;

import nazeem.web.dao.ProductRepository;
import nazeem.web.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductDetailsController {
    @Autowired
    private ProductRepository eRepo;


    @GetMapping("/productDetails")
    public ModelAndView productDetails(@RequestParam Long productId) {
        ModelAndView mav = new ModelAndView("admin/dashboard/product-details");
        Product product = eRepo.findById(productId).get();
        mav.addObject("product", product);
        return mav;
    }
}
