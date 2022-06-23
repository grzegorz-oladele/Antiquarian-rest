package pl.antiquarian.antiquarian.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.antiquarian.antiquarian.model.Category;
import pl.antiquarian.antiquarian.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public String category(Model model) {
        model.addAttribute("category", new Category());
        return "category";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/categories")
    public String addCategory(@Valid Category category, BindingResult result) {
        return categoryService.addCategory(category, result);
    }
}
