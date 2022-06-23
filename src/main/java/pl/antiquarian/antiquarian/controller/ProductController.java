package pl.antiquarian.antiquarian.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.antiquarian.antiquarian.model.Category;
import pl.antiquarian.antiquarian.model.Product;
import pl.antiquarian.antiquarian.repository.ProductRepository;
import pl.antiquarian.antiquarian.service.CategoryService;
import pl.antiquarian.antiquarian.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    @GetMapping("/products")
    public String product(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

//    @ModelAttribute("products")
//    public List<Product> products() {
//        return productService.getAllProducts();
//    }

    @ModelAttribute("categories")
    public List<Category> allCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/products")
    public String addProduct(@Valid Product product, BindingResult result) {
        return productService.addProduct(product, result);
    }

    @ModelAttribute("allTrue")
    List<Product> allTrue() {
        return productService.getAllTrueProducts();
    }

    @ModelAttribute("allFalse")
    List<Product> allFalse() {
        return productService.getAllFalseProducts();
    }

    @GetMapping("/update-true")
    public String updateTrue(@RequestParam long id) {
        productService.setTrueProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/update-false")
    public String updateFalse(@RequestParam long id) {
        productService.setFalseProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam long id) {
        productService.removeProduct(id);
        return "redirect:/products";
    }
}
