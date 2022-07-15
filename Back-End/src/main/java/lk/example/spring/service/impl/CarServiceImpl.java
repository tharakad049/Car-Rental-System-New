package lk.example.spring.service.impl;

import lk.example.spring.repo.CarRepo;
import lk.example.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    public CarRepo carRepo;

    @Autowired
    public ModelMapper mapper;


    /*
    @Override
    public CarDTO searchCar(String carId) {
        if (carRepo.existsById(carId)){
            return mapper.map(carRepo.findById(carId).get(), CarDTO.class);
        }else {
            throw new RuntimeException("No Car For " + carId + " ..!");
        }
    }

    @Override
    public List<CarDTO> getAllCars() {
        return mapper.map(carRepo.findAll(), new TypeToken<List<CarDTO>>(){}.getType());
    }*/
}
