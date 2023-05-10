package com.bunthong.dataanalyticsclass.service.serviceImple;

import com.bunthong.dataanalyticsclass.service.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final String serverLocation = "src/main/resources/images/";
    Path fileLocationStorage;
    public FileStorageServiceImpl(){
        fileLocationStorage = Paths.get(serverLocation);
        try{
            if (!Files.exists(fileLocationStorage)){
                Files.createDirectories(fileLocationStorage);
            }else {
                System.out.println("Directory is already existed !");
            }
        }catch (Exception exception){
            System.out.println("Error creating directory:"+ exception.getMessage());
        }


    }
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();

        String [] fileCompartment = filename.split("\\.");

        filename = UUID.randomUUID()+ "." +fileCompartment[1];
        Path resolvedPath = fileLocationStorage.resolve(filename);
        try{
            Files.copy(file.getInputStream(), resolvedPath, StandardCopyOption.REPLACE_EXISTING);
            return filename;
        } catch (Exception exception){
            return exception.getMessage();
        }
    }

    @Override
    public String deleteFileByName(String filename) {
        return null;
    }

    @Override
    public String deleteAllFiles() {
        return null;
    }
}
