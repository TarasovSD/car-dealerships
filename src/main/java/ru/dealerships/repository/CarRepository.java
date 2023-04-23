package ru.dealerships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dealerships.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
