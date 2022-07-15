package lk.example.spring.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable
public class PricesForTheRentDurations {
    private double dailyPrice;
    private double monthlyPrice;
}
