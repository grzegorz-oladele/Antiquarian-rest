package pl.antiquarian.antiquarian.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.antiquarian.antiquarian.model.Category;
import pl.antiquarian.antiquarian.model.Product;
import pl.antiquarian.antiquarian.repository.CategoryRepository;
import pl.antiquarian.antiquarian.repository.ProductRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(long categoryId, Product product) {
        Category category = findCategoryById(categoryId);
        product.setCategory(category);
        return productRepository.save(product);
    }

    public void removeProduct(long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }

    private Category findCategoryById(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }

    private Product findProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }
}

