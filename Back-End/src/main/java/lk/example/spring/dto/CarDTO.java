package lk.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private String carId;
    private String registrationNumber;
    private String brand;
    private String type;
    private String images;
    private int numberOfPassengers;
    private String transmissionType;
    private String fuelType;
    private double pricesForTheRentDurations;
    private int freeMileageForThePriceAndDuration;
    private int priceForExtraKM;
    private String color;
}
