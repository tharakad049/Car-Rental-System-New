package lk.example.spring.util;

import lk.example.spring.dto.ImageDTO;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileDownloadUtil {
    private Path foundFile = null;

    private void searchFile(Path path, String fileName) {
        foundFile = null;
        try {
            Files.list(path).forEach(file -> {
                if (file.getFileName().toString().startsWith(fileName)) {
                    System.out.println("file  found");
                    foundFile = file;
                    return;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public org.springframework.core.io.Resource getFileAsResource(ImageDTO imageDTO) {

        String pathDirectory = null;
        Path path = null;

        switch (imageDTO.getImageType()) {

            case "car":
                pathDirectory = "E:\\Car Rental System\\CarRentalSystem\\src\\main\\resources\\static\\CarImage";
                path = Paths.get(pathDirectory);
                String imageName = imageDTO.getImageId() + imageDTO.getImageView() + ".jpeg";
                searchFile(path, imageName);
                break;

            case "licence":
                pathDirectory = "E:\\Car Rental System\\CarRentalSystem\\src\\main\\resources\\static\\LicenseImage";
                path = Paths.get(pathDirectory + "/" + imageDTO.getImageId() + imageDTO.getImageType() + ".jpeg");
                break;

            case "idCard":
                pathDirectory = "E:\\Car Rental System\\CarRentalSystem\\src\\main\\resources\\static\\IdCardImage";
                path = Paths.get(pathDirectory + "/" + imageDTO.getImageId() + imageDTO.getImageType() + ".jpeg");
                break;
        }

        try {
            if (foundFile != null) {
                return new UrlResource(foundFile.toUri());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
