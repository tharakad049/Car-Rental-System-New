package lk.example.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString
public class DriverUserAccount {
    @Id
    private String userName;
    private String passWord;

    @OneToOne
    private Driver driver;
}
