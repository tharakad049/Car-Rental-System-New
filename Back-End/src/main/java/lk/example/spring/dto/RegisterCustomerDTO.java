package lk.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RegisterCustomerDTO {
    private String cusId;
    private String email;
    private String nicNumberAndPhoto;
    private String drivingLicenseNumberAndPhoto;
    private String address;
    private String contactNumber;
    private String userName;
    private String passWord;
}
