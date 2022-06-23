package pl.antiquarian.antiquarian.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.antiquarian.antiquarian.service.CategoryService;
import pl.antiquarian.antiquarian.service.ProductService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @ModelAttribute("productsCount")
    public int getProductsCount() {
        return productService.getProductsCount();
    }

    @ModelAttribute("categoriesCount")
    public int getCategoriesCount() {
        return categoryService.getCategoriesCount();
    }
}


