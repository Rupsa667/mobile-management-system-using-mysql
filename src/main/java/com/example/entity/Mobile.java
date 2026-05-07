package com.example.entity;

//Entity class
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name="mobiledata")
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String brand;
    private String model;
    private Double price;
    private Integer stock;

    public Mobile(String brand, String model, Double price, Integer stock) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
    }
}
