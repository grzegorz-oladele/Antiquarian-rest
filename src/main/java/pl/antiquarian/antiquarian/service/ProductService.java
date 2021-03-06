package pl.antiquarian.antiquarian.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.antiquarian.antiquarian.model.Category;
import pl.antiquarian.antiquarian.model.Product;
import pl.antiquarian.antiquarian.repository.CategoryRepository;
import pl.antiquarian.antiquarian.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Page<Category> getAllCategories(int page, int size, String order) {
        return categoryRepository.findAll(PageRequest.of(page, size, Sort.by(order).descending()));
    }

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

