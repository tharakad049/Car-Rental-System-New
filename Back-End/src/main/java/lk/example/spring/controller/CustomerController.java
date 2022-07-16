package lk.example.spring.controller;

import lk.example.spring.dto.CustomerDTO;
import lk.example.spring.dto.RegisterCustomerDTO;
import lk.example.spring.dto.RentalRequestDTO;
import lk.example.spring.entity.Car;
import lk.example.spring.service.CustomerService;
import lk.example.spring.util.ResponseUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("easy/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(RegisterCustomerDTO registerCustomerDTO) {
        customerService.saveCustomer(registerCustomerDTO);
        return new ResponseUtil(200, "Save", null);
    }

/*    @PostMapping(path = "addCustomerImage",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addCustomerImage(@RequestParam ("file") MultipartFile multipartFile){
        String pathDirectory = "E:\\Car Rental System\\CarRentalSystem\\src\\main\\resources\\static";
        Files.copy(multipartFile.getInputStream(), Paths.get( pathDirectory+ File.separator+multipartFile.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
        return new ResponseUtil(200,"Driver image complete",null);
    }*/

    @SneakyThrows
    @PostMapping(path = "uploadIdImage")
    public ResponseUtil uploadCustomerIDImage(@RequestParam("ID") MultipartFile multipartFiles, @RequestParam String cusId) {

        String pathDirectory = "E:\\CarRental System Assignment\\Car-Rental-System-New\\src\\main\\resources\\static\\IdCardImage";
        String imageName = cusId + "ID_CARD" + ".jpeg";
        Files.copy(multipartFiles.getInputStream(), Paths.get(pathDirectory + File.separator + imageName), StandardCopyOption.REPLACE_EXISTING);

        return new ResponseUtil(200, "ID_CARD image added success..", null);
    }


    @GetMapping(path = "getCustomerImage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCustomerIdImage(@RequestParam String name) {
        String pathDirectory = "E:\\CarRental System Assignment\\Car-Rental-System-New\\src\\main\\resources\\static\\IdCardImage";
        Path path = Paths.get(pathDirectory + File.separator + name);
        return new ResponseUtil(200, "Customer id image return complete", path);

    }

    @SneakyThrows
    @PostMapping(path = "uploadLicenceImage")
    public ResponseUtil uploadCustomerLicenceImage(@RequestParam("Licence")MultipartFile multipartFiles, @RequestParam String cusId){

        String pathDirectory = "E:\\CarRental System Assignment\\Car-Rental-System-New\\src\\main\\resources\\static\\LicenseImage";
        String imageName=cusId+"Licence_CARD"+".jpeg";
        Files.copy(multipartFiles.getInputStream(), Paths.get(pathDirectory+ File.separator+imageName), StandardCopyOption.REPLACE_EXISTING);

        return new ResponseUtil(200,"Licence_Card image added success..",null);
    }

    @GetMapping(path = "getCustomerLicenceImage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCustomerLicenceImage(@RequestParam String name) {
        String pathDirectory = "E:\\CarRental System Assignment\\Car-Rental-System-New\\src\\main\\resources\\static\\LicenseImage";
        Path path = Paths.get(pathDirectory + File.separator + name);
        return new ResponseUtil(200, "Customer license image return complete", path);

    }




    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(String id) {
        customerService.deleteCustomer(id);
        return new ResponseUtil(200, "Deleted", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(CustomerDTO customer) {
        customerService.updateCustomer(customer);
        return new ResponseUtil(200, "Updated", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(String id) {
        return new ResponseUtil(200, "Ok", customerService.searchCustomer(id));
    }
    @GetMapping(path = " getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(200, "Ok", customerService.getAllCustomers());
    }

    @GetMapping(path ="/COUNT/{count}")
    public ResponseUtil countSavedCustomers(@PathVariable String count){
        return new ResponseUtil(200, "Ök", customerService.countSavedCustomers());
    }

    @GetMapping(params = {"test"})
    public ResponseUtil generateCustomersId(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", customerService.generateCustomerId());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil ViewAllCar(){
        List<Car> cars =customerService.viewAllCars();
        return new ResponseUtil(200,"All car Details received",cars);
    }

    @GetMapping
    public ResponseUtil RentalRequest(RentalRequestDTO rentalRequestDTO){
        List<Car> cars =customerService.rentalRequest(rentalRequestDTO);
        return new ResponseUtil(200,"Request received",cars);

    }
}
