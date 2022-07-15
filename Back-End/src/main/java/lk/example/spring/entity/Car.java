package lk.example.spring.entity;

import lk.example.spring.embeded.PricesForTheRentDurations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Car {
    @Id
    private String carId;
    private String registrationNumber;
    private String brand;
    private String type;
    private String images;
    private int numberOfPassengers;
    private String transmissionType;
    private String fuelType;
    private PricesForTheRentDurations pricesForTheRentDurations;
    private int freeMileageForThePriceAndDuration;
    private int priceForExtraKM;
    private String color;

    @OneToMany(mappedBy = "car")
    private Set<DriverSchedule> driverSchedules = new HashSet<DriverSchedule>();
}
