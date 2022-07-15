package lk.example.spring.repo;

import lk.example.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car, String> {
    @Query("select v from Car v where v.carId=?1")
    public Car getCarById(String id);
}
