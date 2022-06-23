package pl.antiquarian.antiquarian.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank(message = "Name must be not empty")
    private String name;
    @NotBlank(message = "Description must be not empty")
    private String description;
    @NotBlank(message = "Product code must be not empty")
    private String productCode;
    private boolean soldOut;
    @ManyToOne
    private Category category;
    private LocalDate date;

    @PrePersist
    public void dateAdd() {
        this.date = LocalDate.now();
    }
}