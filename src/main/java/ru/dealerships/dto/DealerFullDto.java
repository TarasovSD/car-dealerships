package ru.dealerships.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class DealerFullDto {
    private Long id;
    private String city;
    private Integer rent;
    private String description;
    private Integer square;
    private Integer staff;
    private List<LocalCarDto> cars;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocalCarDto {
        private Long id;
        private String model;
        private String color;
        private Integer price;
        private Integer maxSpeed;
    }
}
