package lk.example.spring.service.impl;

import lk.example.spring.dto.DriverDTO;
import lk.example.spring.entity.Driver;
import lk.example.spring.repo.DriverRepo;
import lk.example.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (!driverRepo.existsById(dto.getDriverId())){
            driverRepo.save(mapper.map(dto, Driver.class));
        }else{
            throw new RuntimeException("Driver Already Exist..!");
        }
    }

    @Override
    public void deleteDriver(String driverId) {
        if (driverRepo.existsById(driverId)){
            driverRepo.deleteById(driverId);
        }else{
            throw new RuntimeException("Please check the Driver ID.. No Such Driver..!");
        }
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriverId())){
            driverRepo.save(mapper.map(dto, Driver.class));
        }else {
            throw new RuntimeException("No Such Driver To Update..! Please Check the ID..!");
        }
    }

    @Override
    public DriverDTO searchDriver(String driverId) {
        if (driverRepo.existsById(driverId)){
            return mapper.map(driverRepo.findById(driverId).get(), DriverDTO.class);
        }else {
            throw new RuntimeException("No Driver For " + driverId + " ..!");
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<Driver> all = driverRepo.findAll();
        return mapper.map(all, new TypeToken<List<DriverDTO>>(){}.getType());
    }

    @Override
    public String generateDriverId() {
        return driverRepo.generateDriverId();
    }
}
