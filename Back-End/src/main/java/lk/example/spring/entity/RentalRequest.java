package lk.example.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class RentalRequest {
    @Id
    private String requestId;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Car car;

    private String pickupDateAndTime;
    private String cusId;
    private String rentPayment;

    @CreationTimestamp
    private Date requestDateAndTime;
    private String damagePaySlip;

    public void setState(String pending) {

    }
}
