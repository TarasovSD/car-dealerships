package ru.dealerships.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dealerships.Create;
import ru.dealerships.Update;
import ru.dealerships.dto.CarDto;
import ru.dealerships.mapper.CarMapper;
import ru.dealerships.service.CarService;

import java.util.List;

@RestController
@RequestMapping(path = "/cars")
@Slf4j
@Validated
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;


    @PostMapping()
    public CarDto create(@Validated(Create.class) @RequestBody CarDto carDto) {
        log.info("Car created");
        return CarMapper.toCarDto(carService.create(carDto));
    }

    @GetMapping("/{id}")
    public CarDto get(@PathVariable Long id) {
        log.info("Car data received");
        return CarMapper.toCarDto(carService.get(id));
    }

    @GetMapping()
    public List<CarDto> getAll() {
        log.info("All cars data received");
        return carService.getAll();
    }

    @PatchMapping()
    public CarDto update(@Validated(Update.class) @RequestBody CarDto carDto) {
        log.info("Car with id {} updated", carDto.getId());
        return CarMapper.toCarDto(carService.update(carDto));
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        log.info("Car with id {} deleted", id);
        carService.remove(id);
    }
}
