package pl.antiquarian.antiquarian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.antiquarian.antiquarian.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT COUNT(id) FROM categories", nativeQuery = true)
    int categoriesCount();
}