package ru.dealerships.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dealerships.Create;
import ru.dealerships.Update;
import ru.dealerships.dto.DealerDto;
import ru.dealerships.dto.DealerFullDto;
import ru.dealerships.mapper.DealerMapper;
import ru.dealerships.service.DealerService;

import java.util.List;

@RestController
@RequestMapping(path = "/dealers")
@Slf4j
@Validated
@RequiredArgsConstructor
public class DealerController {

    private final DealerService dealerService;


    @PostMapping()
    public DealerDto create(@Validated(Create.class) @RequestBody DealerDto dealerDto) {
        log.info("Dealer created");
        return DealerMapper.toDealerDto(dealerService.create(dealerDto));
    }

    @GetMapping("/{id}")
    public DealerFullDto get(@PathVariable Long id) {
        log.info("Dealer data received");
        return dealerService.get(id);
    }

    @GetMapping()
    public List<DealerFullDto> getAll() {
        log.info("All dealers data received");
        return dealerService.getAll();
    }

    @PatchMapping()
    public DealerDto update(@Validated(Update.class) @RequestBody DealerDto dealerDto) {
        log.info("Dealer with id {} updated", dealerDto.getId());
        return DealerMapper.toDealerDto(dealerService.update(dealerDto));
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        log.info("Dealer with id {} deleted", id);
        dealerService.remove(id);
    }
}
