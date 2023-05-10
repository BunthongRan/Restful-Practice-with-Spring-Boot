package com.bunthong.dataanalyticsclass.service;
// 1. upload file
//2. delete file by name
//3. delete all files

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {
    String uploadFile(MultipartFile file) throws IOException;
    String deleteFileByName(String filename);
    String deleteAllFiles();

}
