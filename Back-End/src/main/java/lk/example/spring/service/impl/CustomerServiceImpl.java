package lk.example.spring.service.impl;

import lk.example.spring.dto.CustomerDTO;
import lk.example.spring.dto.RegisterCustomerDTO;
import lk.example.spring.dto.RentalRequestDTO;
import lk.example.spring.entity.Car;
import lk.example.spring.entity.Customer;
import lk.example.spring.entity.CustomerUserAccount;
import lk.example.spring.entity.RentalRequest;
import lk.example.spring.repo.CarRepo;
import lk.example.spring.repo.CustomerRepo;
import lk.example.spring.repo.CustomerUserAccountRepo;
import lk.example.spring.repo.RentalRequestRepo;
import lk.example.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private RentalRequestRepo rentalRequestRepo;

    @Autowired
    private CustomerUserAccountRepo customerUserAccountRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CarRepo carRepo;

    @Override
    public void saveCustomer(@RequestBody RegisterCustomerDTO registerCustomerDTO) {
        if (!customerRepo.existsById(registerCustomerDTO.getCusId())) {
            customerRepo.save(mapper.map(registerCustomerDTO, Customer.class));
            if (!customerUserAccountRepo.existsById(registerCustomerDTO.getUserName())) {
                customerUserAccountRepo.save(mapper.map(registerCustomerDTO, CustomerUserAccount.class));
            } else {
                throw new RuntimeException("UserAccount Already Exist");
            }
        } else {
            throw new RuntimeException("Customer Already Exist..!");
        }
    }

    @Override
    public void deleteCustomer(String cusId) {
        if (customerRepo.existsById(cusId)) {
            customerRepo.deleteById(cusId);
        } else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCusId())) {
            customerRepo.save(mapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String cusId) {
        if (customerRepo.existsById(cusId)) {
            return mapper.map(customerRepo.findById(cusId).get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("No Customer For " + cusId + " ..!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public String generateCustomerId() {
        return customerRepo.generateCustomerId();
    }

    @Override
    public int countSavedCustomers() {
        return customerRepo.countSavedCustomers();
    }

    @Override
    public List<Car> viewAllCars() {
        return carRepo.findAll();
    }

    @Override
    public List<Car> rentalRequest(RentalRequestDTO rentalRequestDTO) {
        if (!rentalRequestRepo.existsById(rentalRequestDTO.getRequestId())) {

            Customer customer = customerRepo.getCustomerById(rentalRequestDTO.getCusId());
            Car car = carRepo.getCarById(rentalRequestDTO.getCarId());
            RentalRequest rentalRequest = new RentalRequest();
            rentalRequest.setRequestId(rentalRequestDTO.getRequestId());
            rentalRequest.setCustomer(customer);
            rentalRequest.setCar(car);
            rentalRequest.setPickupDateAndTime(rentalRequestDTO.getPickupDateAndTime());
            rentalRequest.setDamagePaySlip(rentalRequestDTO.getDamagePaySlip());
            rentalRequest.setRentPayment(rentalRequestDTO.getRentPayment());
            rentalRequest.setState("pending");
            rentalRequestRepo.save(rentalRequest);
        } else {
            throw new RuntimeException("Rental request Fail");
        }
        return null;
    }
}


