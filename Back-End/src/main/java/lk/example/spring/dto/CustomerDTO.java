package lk.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String cusId;
    private String email;
    private LocalDate registeredDate;
    private String customerName;
    private String nicNumberAndPhoto;
    private String drivingLicenseNumberAndPhoto;
    private String address;
    private String contactNumber;
}
