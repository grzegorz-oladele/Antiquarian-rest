package pl.antiquarian.antiquarian.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.antiquarian.antiquarian.model.Product;
import pl.antiquarian.antiquarian.repository.ProductRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String addProduct(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product";
        }
        product.setSoldOut(true);
        productRepository.save(product);
        return "redirect:/products";
    }

    public List<Product> getAllTrueProducts() {
        return productRepository.findAllTrue(PageRequest.of(0, 10));
    }

    public List<Product> getAllFalseProducts() {
        return productRepository.findAllFalse(PageRequest.of(0,10));
    }

    public int setTrueProduct(long id) {
        return productRepository.setTrueById(id);
    }

    public int setFalseProduct(long id) {
        return productRepository.setFalseById(id);
    }

    public void removeProduct(long id) {
        productRepository.deleteById(id);
    }

    public int getProductsCount() {
        return productRepository.productsCount();
    }
}

