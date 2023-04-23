package ru.dealerships.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dealerships.dto.CarDto;
import ru.dealerships.exception.CarNotFoundException;
import ru.dealerships.exception.DealerNotFoundException;
import ru.dealerships.mapper.CarMapper;
import ru.dealerships.model.Car;
import ru.dealerships.model.Dealer;
import ru.dealerships.repository.CarRepository;
import ru.dealerships.repository.DealerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final DealerRepository dealerRepository;

    @Transactional
    public Car create(CarDto carDto) {
        String massage = "Dealer not found. Dealer id: " + carDto.getDealerId();
        Dealer dealer = dealerRepository.findById(carDto.getDealerId())
                .orElseThrow(() -> new DealerNotFoundException(massage));
        Car car = CarMapper.toCar(carDto, dealer);
        return carRepository.save(car);
    }

    public Car get(Long id) {
        String massage = "Сar not found. Car id: " + id;
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(massage));
    }

    public List<CarDto> getAll() {
        return carRepository.findAll().stream().map(CarMapper::toCarDto).collect(Collectors.toList());
    }

    @Transactional
    public Car update(CarDto carDto) {
        if (carDto.getId() == null) {
            throw new CarNotFoundException("Dealer not found");
        }
        String massage = "Сar not found. Car id: " + carDto.getId();
        Car carToUpdate = carRepository.findById(carDto.getId()).orElseThrow(() -> new CarNotFoundException(massage));
        if (carDto.getModel() != null) {
            carToUpdate.setModel(carDto.getModel());
        }
        if (carDto.getColor() != null) {
            carToUpdate.setColor(carDto.getColor());
        }
        if (carDto.getPrice() != null) {
            carToUpdate.setPrice(carDto.getPrice());
        }
        if (carDto.getMaxSpeed() != null) {
            carToUpdate.setMaxSpeed(carDto.getMaxSpeed());
        }
        if (carDto.getDealerId() != null) {
            String dealerMassage = "Dealer not found. Dealer id: " + carDto.getDealerId();
            Dealer dealer = dealerRepository.findById(carDto.getDealerId())
                    .orElseThrow(() -> new DealerNotFoundException(dealerMassage));
            carToUpdate.setDealer(dealer);
        }
        return carToUpdate;
    }

    @Transactional
    public void remove(Long id) {
        String massage = "Сar not found. Car id: " + id;
        Car carToRemove = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(massage));
        carRepository.delete(carToRemove);
    }
}
