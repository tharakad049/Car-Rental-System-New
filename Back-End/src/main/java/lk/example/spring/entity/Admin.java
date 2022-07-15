package lk.example.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Admin {
    @Id
    private String adminId;
    private String adminName;
    private String adminAddress;
    private String adminContact;
    private String adminPassword;

}
