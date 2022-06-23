package pl.antiquarian.antiquarian.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.antiquarian.antiquarian.model.Product;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT COUNT(p) FROM Product p")
    int productsCount();

    @Query(value = "SELECT p FROM Product p WHERE p.soldOut = true")
    List<Product> findAllTrue(Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE p.soldOut = false")
    List<Product> findAllFalse(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Product p SET p.soldOut = true WHERE p.id = :id")
    int setTrueById(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Product p SET p.soldOut = false WHERE p.id = :id")
    int setFalseById(@Param("id") long id);
}
