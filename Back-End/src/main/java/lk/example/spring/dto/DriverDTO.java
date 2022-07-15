package lk.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class DriverDTO {
    private String driverId;
    private String email;
    private String contactNumber;
    private String nicNumberAndPhoto;
    private String drivingLicenseNumberAndPhoto;
    private String address;
}
