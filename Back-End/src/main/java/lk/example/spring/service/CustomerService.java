package lk.example.spring.service;

import lk.example.spring.dto.CustomerDTO;
import lk.example.spring.dto.RegisterCustomerDTO;
import lk.example.spring.dto.RentalRequestDTO;
import lk.example.spring.entity.Car;

import java.util.List;

public interface CustomerService {
    void saveCustomer(RegisterCustomerDTO registerCustomerDTO);
    void deleteCustomer(String cusId);
    void updateCustomer(CustomerDTO dto);
    CustomerDTO searchCustomer(String cusId);
    List<CustomerDTO> getAllCustomers();
    String generateCustomerId();
    int countSavedCustomers();
    List<Car> viewAllCars();
    List<Car> rentalRequest(RentalRequestDTO rentalRequestDTO);
}
