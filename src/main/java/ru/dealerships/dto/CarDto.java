package ru.dealerships.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.dealerships.Create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
public class CarDto {
    private Long id;
    @NotBlank(groups = {Create.class})
    private String model;
    @NotBlank(groups = {Create.class})
    private String color;
    @NotNull(groups = {Create.class})
    private Integer price;
    @NotNull(groups = {Create.class})
    private Integer maxSpeed;
    @NotNull(groups = {Create.class})
    private Long dealerId;
}
