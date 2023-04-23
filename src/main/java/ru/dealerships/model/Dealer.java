package ru.dealerships.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dealerships")
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "city", length = 100)
    @NotBlank
    private String city;
    @Column(name = "rent", nullable = false)
    private Integer rent;
    @Column(name = "description", length = 1000)
    @NotBlank
    private String description;
    @Column(name = "square", nullable = false)
    private Integer square;
    @Column(name = "staff", nullable = false)
    private Integer staff;
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "dealer_id")
    private List<Car> cars = new ArrayList<>();
}
