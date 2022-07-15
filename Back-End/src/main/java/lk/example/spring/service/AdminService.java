package lk.example.spring.service;

import lk.example.spring.dto.AdminDTO;
import lk.example.spring.dto.CarDTO;
import lk.example.spring.dto.RentalRequestDTO;

import java.util.List;

public interface AdminService {

    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    void deleteCar(String carId);
    List<RentalRequestDTO> rentalRequests();

    void saveAdmin(AdminDTO adminDTO);
    void updateAdmin(AdminDTO adminDTO);
    void deleteAdmin(String id);
    AdminDTO searchAdmin(String id);
    List<AdminDTO> getAllAdmin();


}
