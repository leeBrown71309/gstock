package nazeem.web.controller;


import nazeem.web.dao.SaleRepository;
import nazeem.web.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VenteController {

    @Autowired
    private SaleRepository saleRepo;

//    @GetMapping({"/venteList"})
//    public ModelAndView getAllProducts() {
//        ModelAndView mav = new ModelAndView("admin/dashboard/vente-page");
//        return mav;
//    }

    @GetMapping({"/venteList"})
    public ModelAndView getAllSales() {
        ModelAndView mav = new ModelAndView("admin/dashboard/vente-page");
        //List listProducts = saleRepo.getAllSaleProduct();

        mav.addObject("sales", saleRepo.getAllSaleProduct());
        //listProducts.forEach(System.out::println);
        return mav;
    }
}
