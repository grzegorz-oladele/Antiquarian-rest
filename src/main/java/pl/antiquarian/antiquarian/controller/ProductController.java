package pl.antiquarian.antiquarian.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.antiquarian.antiquarian.model.Category;
import pl.antiquarian.antiquarian.model.Product;
import pl.antiquarian.antiquarian.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/categories")
    public Page<Category> getAllCategories(@RequestParam int page, @RequestParam int size, @RequestParam String order) {
        return productService.getAllCategories(page, size, order);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/{categoryId}")
    public Product addProduct(@PathVariable long categoryId, @Valid @RequestBody Product product) {
        return productService.addProduct(categoryId, product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable long productId) {
        productService.removeProduct(productId);
    }
}
