package pl.antiquarian.antiquarian.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.antiquarian.antiquarian.model.Product;
import pl.antiquarian.antiquarian.service.ProductService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

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
