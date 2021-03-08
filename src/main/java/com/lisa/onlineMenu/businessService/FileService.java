package com.lisa.onlineMenu.businessService;


import com.lisa.onlineMenu.exceptions.FileException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class FileService {
    public byte[] read(String path) throws FileException {
        try {
            return Files.readAllBytes(new File(path).toPath());
        } catch (IOException ioe) {
            throw new FileException("Can’t read File");
        }
    }
}
