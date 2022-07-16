package lk.example.spring.controller;

import lk.example.spring.dto.DriverDTO;
import lk.example.spring.service.DriverService;
import lk.example.spring.util.ResponseUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("easy/v1/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto) {
        driverService.saveDriver(dto);
        return new ResponseUtil(200, "Successfully Saved.", null);
    }

    @SneakyThrows
    @PostMapping(path = "addDriverIdImage",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadDriverIDImage(@RequestParam("ID") MultipartFile multipartFiles, @RequestParam String driverId) {

        String pathDirectory = "E:\\CarRental System Assignment\\Car-Rental-System-New\\src\\main\\resources\\static\\IdCardImage";
        String imageName = driverId + "ID_CARD" + ".jpeg";
        Files.copy(multipartFiles.getInputStream(), Paths.get(pathDirectory + File.separator + imageName), StandardCopyOption.REPLACE_EXISTING);

        return new ResponseUtil(200, "Driver ID_CARD image added success..", null);
    }

    @GetMapping(path = "getDriverImage",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil  getDriverIdImage(@RequestParam String name){
        String pathDirectory = "E:\\CarRental System Assignment\\Car-Rental-System-New\\src\\main\\resources\\static\\IdCardImage";
        Path path = Paths.get(pathDirectory + File.separator + name);
        return new ResponseUtil(200,"Driver Id image return complete",path);

    }

    @SneakyThrows
    @PostMapping(path = "addDriverLicenseImage",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadDriverLicenseImage(@RequestParam("Licence") MultipartFile multipartFiles, @RequestParam String driverId) {

        String pathDirectory = "E:\\CarRental System Assignment\\Car-Rental-System-New\\src\\main\\resources\\static\\LicenseImage";
        String imageName = driverId + "LICENSE_CARD" + ".jpeg";
        Files.copy(multipartFiles.getInputStream(), Paths.get(pathDirectory + File.separator + imageName), StandardCopyOption.REPLACE_EXISTING);

        return new ResponseUtil(200, "Driver License image added success..", null);
    }

    @GetMapping(path = "getDriverImage",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil  getDriverLicenseImage(@RequestParam String name){
        String pathDirectory = "E:\\CarRental System Assignment\\Car-Rental-System-New\\src\\main\\resources\\static\\LicenseImage";
        Path path = Paths.get(pathDirectory + File.separator + name);
        return new ResponseUtil(200,"Driver License image return complete",path);

    }








    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriver(@PathVariable String id) {
        return new ResponseUtil(200, "Ok.", driverService.searchDriver(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto) {
        driverService.updateDriver(dto);
        return new ResponseUtil(200, "Successfully Updated.", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String id) {
        driverService.deleteDriver(id);
        return new ResponseUtil(200, "Successfully Deleted.", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers() {
        return new ResponseUtil(200, "Ok", driverService.getAllDrivers());
    }

    @GetMapping(params = {"ids"})
    public ResponseUtil generateDriverIds(@RequestParam String ids) {
        return new ResponseUtil(200, "Ok", driverService.generateDriverId());
    }
}
