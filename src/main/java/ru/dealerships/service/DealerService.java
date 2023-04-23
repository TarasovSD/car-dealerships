package ru.dealerships.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dealerships.dto.DealerDto;
import ru.dealerships.dto.DealerFullDto;
import ru.dealerships.exception.DealerNotFoundException;
import ru.dealerships.mapper.DealerMapper;
import ru.dealerships.model.Car;
import ru.dealerships.model.Dealer;
import ru.dealerships.repository.CarRepository;
import ru.dealerships.repository.DealerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DealerService {

    private final DealerRepository dealerRepository;
    private final CarRepository carRepository;

    @Transactional
    public Dealer create(DealerDto dealerDto) {
        Dealer dealer = DealerMapper.toDealer(dealerDto, new ArrayList<>());
        return dealerRepository.save(dealer);
    }

    public DealerFullDto get(Long id) {
        String massage = "Dealer not found. Dealer id: " + id;
        Dealer dealer = dealerRepository.findById(id).orElseThrow(() -> new DealerNotFoundException(massage));
        List<Car> cars = dealer.getCars();
        return DealerMapper.toDealerFullDto(dealer, cars);
    }

    public List<DealerFullDto> getAll() {
        List<Dealer> dealers = dealerRepository.findAll();
        List<Car> cars = carRepository.findAll();
        List<DealerFullDto> dealersDto = new ArrayList<>();
        for (Dealer dealer : dealers) {
            List<Car> dealersCars = new ArrayList<>();
            for (Car car : cars) {
                if (car.getDealer().getId() == dealer.getId()) {
                    dealersCars.add(car);
                }
            }
            DealerFullDto dto = DealerMapper.toDealerFullDto(dealer, dealersCars);
            dealersDto.add(dto);
        }
        return dealersDto;
    }

    @Transactional
    public Dealer update(DealerDto dealerDto) {
        if (dealerDto.getId() == null) {
            throw new DealerNotFoundException("Dealer not found");
        }
        String massage = "Dealer not found. Dealer id: " + dealerDto.getId();
        Dealer dealerToUpdate = dealerRepository.findById(dealerDto.getId())
                .orElseThrow(() -> new DealerNotFoundException(massage));
        if (dealerDto.getCity() != null) {
            dealerToUpdate.setCity(dealerDto.getCity());
        }
        if (dealerDto.getRent() != null) {
            dealerToUpdate.setRent(dealerDto.getRent());
        }
        if (dealerDto.getDescription() != null) {
            dealerToUpdate.setDescription(dealerDto.getDescription());
        }
        if (dealerDto.getSquare() != null) {
            dealerToUpdate.setSquare(dealerDto.getSquare());
        }
        if (dealerDto.getStaff() != null) {
            dealerToUpdate.setStaff(dealerDto.getStaff());
        }
        return dealerToUpdate;
    }

    @Transactional
    public void remove(Long id) {
        String massage = "Dealer not found. Dealer id: " + id;
        Dealer dealerToDelete = dealerRepository.findById(id).orElseThrow(() -> new DealerNotFoundException(massage));
        dealerRepository.delete(dealerToDelete);
    }
}
