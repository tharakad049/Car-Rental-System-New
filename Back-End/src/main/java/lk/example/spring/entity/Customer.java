package lk.example.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    private String cusId;
    private String email;
    private LocalDate registeredDate;
    private String customerName;
    private String nicNumberAndPhoto;
    private String drivingLicenseNumberAndPhoto;
    private String address;
    private String contactNumber;

    @OneToMany(mappedBy = "customer")
    private List<RentalRequest> rentalRequests = new ArrayList<RentalRequest>();
}
