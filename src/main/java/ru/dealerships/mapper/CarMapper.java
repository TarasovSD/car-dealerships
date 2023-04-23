package ru.dealerships.mapper;

import lombok.experimental.UtilityClass;
import ru.dealerships.dto.CarDto;
import ru.dealerships.model.Car;
import ru.dealerships.model.Dealer;

@UtilityClass
public class CarMapper {

    public Car toCar(CarDto carDto, Dealer dealer) {
        return new Car(carDto.getId(),
                carDto.getModel(),
                carDto.getColor(),
                carDto.getPrice(),
                carDto.getMaxSpeed(),
                dealer);
    }

    public CarDto toCarDto(Car car) {
        return new CarDto(car.getId(),
                car.getModel(),
                car.getColor(),
                car.getPrice(),
                car.getMaxSpeed(),
                car.getDealer().getId());
    }
}
