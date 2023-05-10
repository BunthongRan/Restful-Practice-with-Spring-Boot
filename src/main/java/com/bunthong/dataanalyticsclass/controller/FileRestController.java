package com.bunthong.dataanalyticsclass.controller;


import com.bunthong.dataanalyticsclass.service.FileStorageService;
import com.bunthong.dataanalyticsclass.service.FileUploadService;
import com.bunthong.dataanalyticsclass.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file-service")
public class FileRestController {
    @Autowired
//    FileUploadService fileUploadService;
    FileStorageService fileStorageService;
    @PostMapping("/file-upload")
//    public String uploadFile(@RequestParam("images") MultipartFile file) throws IOException {
//        fileUploadService.uploadFile(file);
//        return "file name "+"'"+file.getOriginalFilename()+"'"+" is successfully uploaded...!";
    public Response<?> fileUpload(@RequestParam MultipartFile file) throws IOException {
        String filename = fileStorageService.uploadFile(file);
        return Response.<Object>ok().setPayload(filename);

    }
}