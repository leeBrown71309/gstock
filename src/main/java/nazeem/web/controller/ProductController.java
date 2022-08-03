package nazeem.web.controller;


import nazeem.web.dao.CategoryRepository;
import nazeem.web.dao.ProductRepository;
import nazeem.web.dao.SaleRepository;
import nazeem.web.model.Category;
import nazeem.web.model.Product;
import nazeem.web.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository eRepo;
	@Autowired
	private CategoryRepository cRepo;
	@Autowired
	private SaleRepository saleRepo;

	@GetMapping({"/productList"})
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView("admin/dashboard/list-products");
		mav.addObject("products", eRepo.findAll());
		return mav;
	}
	
	@GetMapping("/addProductForm")
	public ModelAndView addProductForm() {
		ModelAndView mav = new ModelAndView("admin/dashboard/add-product-form");
		Product newProduct = new Product();
		mav.addObject("product", newProduct);
		//mav.addObject("categories", cRepo.findAll());
		return mav;
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute Product product) {
		Category category = new Category();
		//cRepo.save(category);
		eRepo.save(product);
		return "redirect:/productList";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long productId) {
		ModelAndView mav = new ModelAndView("admin/dashboard/add-product-form");
		Product product = eRepo.findById(productId).get();
		mav.addObject("product", product);
		return mav;
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam Long productId) {
		eRepo.deleteById(productId);
		return "redirect:/productList";
	}

	@GetMapping("/addProductToSale")
	public String addProductToSale(@RequestParam Long productId) {
		Sale sale = new Sale();
		sale.setProduct_id(productId);
		saleRepo.save(sale);
		return "redirect:/productList";
	}


}
