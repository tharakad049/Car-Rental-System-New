package lk.example.spring.controller;

import lk.example.spring.dto.AdminDTO;
import lk.example.spring.dto.CarDTO;
import lk.example.spring.dto.ImageDTO;
import lk.example.spring.dto.RentalRequestDTO;
import lk.example.spring.service.AdminService;
import lk.example.spring.util.FileDownloadUtil;
import lk.example.spring.util.ResponseUtil;
import lk.example.spring.util.SearchFileUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("easy/v1/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    FileDownloadUtil fileDownloadUtil;

    @Autowired
    SearchFileUtil searchFileUtil;






    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@ModelAttribute CarDTO car){
        adminService.saveCar(car);
        return new ResponseUtil(200, "Saved", null);
    }

    @SneakyThrows
    @PostMapping(path = "addCarImage",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addCarImage(@RequestParam(value = "param") MultipartFile[] multipartFile , @RequestParam("carId") String carId){

        String pathDirectory = "E:\\Car Rental System\\CarRentalSystem\\src\\main\\resources\\static\\CarImage";
        String [] carImageView={"Front","Back","Side","Interior"};
        for (int i = 0; i < multipartFile.length; i++) {
            String[] split=multipartFile[i].getContentType().split("/");

            if (split[1].equals("jpeg") || split[1].equals("png")){
                String imageName=carId+carImageView[i]+".jpeg";
                Files.copy(multipartFile[i].getInputStream(),Paths.get(pathDirectory+File.separator+imageName),StandardCopyOption.REPLACE_EXISTING);

            }else {
                return new ResponseUtil(404,"please..  must be Car images type  jpeg or png",null);
            }
        }
        return new ResponseUtil(200,"Car images added complete",null);
    }

    @GetMapping(path = "getCarImage" , produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> getCarImage(@RequestBody ImageDTO imageDTO){
        Resource fileAsResource = fileDownloadUtil.getFileAsResource(imageDTO);

        if (fileAsResource==null){
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body("Car Image not found");
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(fileAsResource);
    }








    @PutMapping(path = "updateCar" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCar(@RequestBody CarDTO car){
        adminService.updateCar(car);
        return new ResponseUtil(200, "Updated", null);
    }

    @SneakyThrows
    @PutMapping(path = "updateCarImage",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCarImage(@RequestParam(value = "carImage") MultipartFile multipartFile , @RequestParam("carId") String carId ,@RequestParam("view") String view){

        String pathDirectory = "E:\\Car Rental System\\CarRentalSystem\\src\\main\\resources\\static\\CarImage";
        if (searchFileUtil.searchFile(pathDirectory,carId+view+".jpeg")){
            Files.copy(multipartFile.getInputStream(),Paths.get(pathDirectory+File.separator+carId+view+".jpeg"),StandardCopyOption.REPLACE_EXISTING);
            return new ResponseUtil(200,"car Image Updated",null);
        }
        return new ResponseUtil(200,"car Image Fail",null);
    }







    @DeleteMapping(params = {"carId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCar(@RequestParam String carId){
        adminService.deleteCar(carId);
        return new ResponseUtil(200, "Deleted", null);
    }

    @SneakyThrows
    @DeleteMapping(path = "deleteCarImage",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCarAllImages(@RequestParam String carId){
        String pathDirectory = "E:\\Car Rental System\\CarRentalSystem\\src\\main\\resources\\static\\CarImage";
        String [] carImageView={"Front","Back","Side","Interior"};

        for (int i=0; i<carImageView.length; i++){
            Files.deleteIfExists(Paths.get(pathDirectory+File.separator+carId+carImageView[i]+".jpeg"));
        }

        return new ResponseUtil(200,"car Delete success",null);
    }










    @GetMapping(path = "viewRentalRequest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil viewRentalRequest(){
        List<RentalRequestDTO> allRentalRequest = adminService.rentalRequests();
        return new ResponseUtil(200,"car Delete success",allRentalRequest);
    }

    @PostMapping(path = "addAdmin" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO adminDTO){
        adminService.saveAdmin(adminDTO);
        return new ResponseUtil(200, "Successfully Saved.",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdmin(@PathVariable String id){
        return new ResponseUtil(200, "Ok.",adminService.searchAdmin(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO adminDTO){
        adminService.updateAdmin(adminDTO);
        return new ResponseUtil(200, "Successfully Updated.",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(@RequestParam String id){
        adminService.deleteAdmin(id);
        return new ResponseUtil(200, "Successfully Deleted.", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAdmin(){
        return new ResponseUtil(200,"Ok", adminService.getAllAdmin());
    }

}