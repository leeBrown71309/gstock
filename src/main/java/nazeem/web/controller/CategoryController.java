package nazeem.web.controller;

import nazeem.web.dao.CategoryRepository;
import nazeem.web.model.Category;

import nazeem.web.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository cRepo;

    @GetMapping({"/categoryList"})
    public ModelAndView getAllCategories() {
        ModelAndView mav = new ModelAndView("admin/dashboard/category-list");
        mav.addObject("categories", cRepo.findAll());
        return mav;
    }

    @GetMapping("/addCategoryForm")
    public ModelAndView addCategoryForm() {
        ModelAndView mav = new ModelAndView("admin/dashboard/add-category");
        Category newCategory = new Category();
        mav.addObject("category", newCategory);
        return mav;
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category) {
        cRepo.save(category);
        return "redirect:/categoryList";
    }
}
