package lk.example.spring.repo;

import lk.example.spring.entity.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRequestRepo extends JpaRepository<RentalRequest, String> {
}
