package lk.example.spring.entity;

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
public class Driver {
    @Id
    private String driverId;
    private String email;
    private String contactNumber;
    private String nicNumberAndPhoto;
    private String drivingLicenseNumberAndPhoto;
    private String address;

    @OneToMany(mappedBy = "driver")
    private Set<DriverSchedule> vehicles=new HashSet<DriverSchedule>();
}
