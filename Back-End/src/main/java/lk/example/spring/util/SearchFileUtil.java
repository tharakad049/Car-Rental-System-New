package lk.example.spring.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class SearchFileUtil {

    boolean b = false;

    public boolean searchFile(String path, String imageName) {
        b = false;
        try {
            Files.list(Paths.get(path)).forEach(file -> {
                if (file.getFileName().toString().startsWith(imageName)) {
                    System.out.println("file  found");
                    b = true;
                    return;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b == true;
    }
}
