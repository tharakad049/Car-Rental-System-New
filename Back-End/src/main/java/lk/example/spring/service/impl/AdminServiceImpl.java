package lk.example.spring.service.impl;

import lk.example.spring.dto.AdminDTO;
import lk.example.spring.dto.CarDTO;
import lk.example.spring.dto.RentalRequestDTO;
import lk.example.spring.entity.Admin;
import lk.example.spring.entity.Car;
import lk.example.spring.entity.RentalRequest;
import lk.example.spring.repo.AdminServiceRepo;
import lk.example.spring.repo.CarRepo;
import lk.example.spring.repo.RentalRequestRepo;
import lk.example.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminServiceRepo adminServiceRepo;

    @Autowired
    RentalRequestRepo rentalRequestRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if (!carRepo.existsById(dto.getCarId())){
            carRepo.save(mapper.map(dto, Car.class));
        }else {
            throw new RuntimeException("Car Already Exist..!");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (carRepo.existsById(dto.getCarId())){
            carRepo.save(mapper.map(dto, Car.class));
        }else {
            throw new RuntimeException("No Such Car To Update..! Please Check the Id..!");
        }
    }

    @Override
    public void deleteCar(String carId) {
        if (carRepo.existsById(carId)){
            carRepo.deleteById(carId);
        }else {
            throw new RuntimeException("Please check the Car Id.. No Such Car..!");
        }
    }

    @Override
    public List<RentalRequestDTO> rentalRequests() {
        List<RentalRequest> all = rentalRequestRepo.findAll();
        return (List<RentalRequestDTO>) mapper.map(all,RentalRequestDTO.class);
    }














    @Override
    public void saveAdmin(AdminDTO adminDTO) {
        if (!adminServiceRepo.existsById(adminDTO.getAdminId())){
            adminServiceRepo.save(mapper.map(adminDTO, Admin.class));
        }else {
            throw new RuntimeException(adminDTO.getAdminId() + " " + "Admin Already Exists..!");
        }
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {
        if (adminServiceRepo.existsById(adminDTO.getAdminId())){
            adminServiceRepo.save(mapper.map(adminDTO, Admin.class));
        }else {
            throw new RuntimeException(adminDTO.getAdminId() + " " + "No Such Admin..! Please Check The Correct Id..!");
        }
    }

    @Override
    public void deleteAdmin(String id) {
        if (adminServiceRepo.existsById(id)){
            adminServiceRepo.deleteById(id);
        }else {
            throw new RuntimeException(id + " " + "No Such Admin..! Please Check The Correct Id..!");
        }
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        if (adminServiceRepo.existsById(id)){
            Admin admin = adminServiceRepo.findById(id).get();
            return mapper.map(admin, AdminDTO.class);
        }else {
            throw new RuntimeException(id + " " + "No Such Admin..! Please Check The Id..!");
        }
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        List<Admin> all = adminServiceRepo.findAll();
        return mapper.map(all, new TypeToken<List<AdminDTO>>(){
        }.getType());
    }

}
