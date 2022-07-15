package lk.example.spring.repo;

import lk.example.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver, String> {
    @Query(value = "slect driverId from Driver order by driverId desc LIMIT 1", nativeQuery = true)
    String generateDriverId();
}
