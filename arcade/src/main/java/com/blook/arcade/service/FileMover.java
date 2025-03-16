package com.blook.arcade.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;

@Service
public class FileMover {

    public void moveFile(String sourcePath) {

        File sourceFile = new File(sourcePath);

        //TODO calculate this V based off recieved file
        File destinationFolder = new File("arcade/src/main/java/com/blook/arcade/Emulators");

        Path source = Paths.get(sourceFile.getAbsolutePath());
        Path destination = Paths.get(destinationFolder.getAbsolutePath(), sourceFile.getName());

        try {
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully to: " + destination);

        } catch (IOException e) {
            System.err.println("Error moving file: " + e.getMessage());
        }
    }
}
