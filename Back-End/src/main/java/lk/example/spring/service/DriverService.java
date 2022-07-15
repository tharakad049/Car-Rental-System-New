package lk.example.spring.service;

import lk.example.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO dto);
    void deleteDriver(String driverId);
    void updateDriver(DriverDTO dto);
    DriverDTO searchDriver(String driverId);
    List<DriverDTO> getAllDrivers();
    String generateDriverId();
}
