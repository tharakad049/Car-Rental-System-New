package lk.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverScheduleDTO {
    private String carId;
    private String driverId;
    private String date;
    private String time;
}
