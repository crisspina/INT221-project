package casecoolors.Controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;

@Service
@CrossOrigin(origins = "*")
@RestController
public class ImageController {

    public String uploadFile(MultipartFile file) {
        try {
            String uploadDir = "./image/";
            if (!Files.exists(Path.of(uploadDir))) {
                Files.createDirectories(Path.of(uploadDir));
            }
            String fileName = file.getOriginalFilename();
            Path saveTO = Paths.get(uploadDir+fileName);
            System.out.println("Save TO : " + saveTO.toString());
            Files.copy(file.getInputStream(), saveTO, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @GetMapping("getImages/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        System.out.println("Filename : " + filename);
        try {
            FileInputStream fileInputStream = new FileInputStream("image" + "/" + filename);
            byte[] image = fileInputStream.readAllBytes();
            fileInputStream.close();
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        } catch (IOException e) {
            System.out.println("IO Exception");
            return null;
        }
    }

    @DeleteMapping("delImages/{filename}")
    public String deleteFile(@PathVariable String filename) {
        try {
            Files.delete(Path.of("image" + "/" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Delete image success";
    }
}
