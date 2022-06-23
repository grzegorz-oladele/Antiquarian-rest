package pl.antiquarian.antiquarian.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.antiquarian.antiquarian.model.Category;
import pl.antiquarian.antiquarian.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public String addCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category";
        }
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    public int getCategoriesCount() {
        return categoryRepository.categoriesCount();
    }


}
