package ru.dealerships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dealerships.model.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
