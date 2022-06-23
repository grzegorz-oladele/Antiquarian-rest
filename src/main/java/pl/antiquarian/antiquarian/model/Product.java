package pl.antiquarian.antiquarian.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    @NotBlank(message = "Name must not be empty")
    private String name;
    private String description;
    private String productCode;
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            message = "Email is incorrect")
    private String email;
    @Max(value = 20, message = "Number must be less than 20")
    private int number;
    private boolean soldOut;
    @ManyToOne
    private Category category;
    private LocalDate date;

    @PrePersist
    public void created() {
        this.date = LocalDate.now();
    }
}