package lk.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentalRequestDTO {
    private String requestId;
    private String carId;
    private String pickupDateAndTime;
    private String cusId;
    private String rentPayment;
    private String requestDateAndTime;
    private String damagePaySlip;
}
