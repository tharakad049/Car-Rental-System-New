package lk.example.spring.controller;

import lk.example.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("easy/v1/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;

}
