package com.lisa.onlineMenu.businessService;


import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    private FileService fileService;

    public PhotoService(FileService fileService) {
        this.fileService = fileService;
    }

    public byte[] readPhoto(String filepath) {
        return fileService.read(filepath);
    }
}
