package ru.dealerships.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "model", length = 100)
    @NotBlank
    private String model;
    @Column(name = "color", length = 100)
    @NotBlank
    private String color;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "max_speed", nullable = false)
    private Integer maxSpeed;
    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;
}
