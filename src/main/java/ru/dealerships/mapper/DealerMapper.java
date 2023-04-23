package ru.dealerships.mapper;

import lombok.experimental.UtilityClass;
import ru.dealerships.dto.DealerDto;
import ru.dealerships.dto.DealerFullDto;
import ru.dealerships.model.Car;
import ru.dealerships.model.Dealer;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DealerMapper {

    public DealerDto toDealerDto(Dealer dealer) {
        return new DealerDto(dealer.getId(),
                dealer.getCity(),
                dealer.getRent(),
                dealer.getDescription(),
                dealer.getSquare(),
                dealer.getStaff());
    }


    public DealerFullDto toDealerFullDto(Dealer dealer, List<Car> cars) {
        return new DealerFullDto(dealer.getId(),
                dealer.getCity(),
                dealer.getRent(),
                dealer.getDescription(),
                dealer.getSquare(),
                dealer.getStaff(),
                toLocalCarDto(cars));
    }

    public Dealer toDealer(DealerDto dealerDto, List<Car> cars) {
        return new Dealer(dealerDto.getId(),
                dealerDto.getCity(),
                dealerDto.getRent(),
                dealerDto.getDescription(),
                dealerDto.getSquare(),
                dealerDto.getStaff(),
                cars);
    }

    public List<DealerFullDto.LocalCarDto> toLocalCarDto(List<Car> cars) {
        List<DealerFullDto.LocalCarDto> carsDto = new ArrayList<>();
        for (Car car : cars) {
            carsDto.add(new DealerFullDto.LocalCarDto(
                    car.getId(),
                    car.getModel(),
                    car.getColor(),
                    car.getPrice(),
                    car.getMaxSpeed()
            ));
        }
        return carsDto;
    }
}
