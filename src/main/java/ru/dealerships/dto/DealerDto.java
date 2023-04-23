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
public class DealerDto {
    private Long id;
    @NotBlank(groups = {Create.class})
    private String city;
    @NotNull(groups = {Create.class})
    private Integer rent;
    @NotBlank(groups = {Create.class})
    private String description;
    @NotNull(groups = {Create.class})
    private Integer square;
    @NotNull(groups = {Create.class})
    private Integer staff;
}
