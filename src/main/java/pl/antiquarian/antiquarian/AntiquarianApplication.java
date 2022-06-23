package pl.antiquarian.antiquarian;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.antiquarian.antiquarian.model.Category;
import pl.antiquarian.antiquarian.repository.CategoryRepository;

@SpringBootApplication
public class AntiquarianApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntiquarianApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(CategoryRepository categoryRepository) {
		return args -> {
			if (categoryRepository.findAll().isEmpty()) {
				categoryRepository.save(new Category("Książki"));
				categoryRepository.save(new Category("Porcelana"));
				categoryRepository.save(new Category("Broń"));
				categoryRepository.save(new Category("Meble"));
				categoryRepository.save(new Category("Muzyka"));
				categoryRepository.save(new Category("Znaczki pocztowe"));
			}
		};
	}

}
