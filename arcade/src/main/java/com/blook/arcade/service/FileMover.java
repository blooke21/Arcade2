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

    public boolean moveFile(String sourcePath) {
        try {
            if (sourcePath == null) {
                System.err.println("Source path is null");
                return false;
            }

            File sourceFile = new File(sourcePath);
            System.out.println("Source file: " + sourceFile);

            if (!sourceFile.exists()) {
                System.err.println("Source file does not exist: " + sourcePath);
                return false;
            }

            File destinationFolder = new File("src/main/java/com/blook/arcade/Emulators");
            System.out.println("Destination folder: " + destinationFolder);

            // Create destination directory if it doesn't exist
            if (!destinationFolder.exists()) {
                boolean created = destinationFolder.mkdirs();
                System.out.println("Created destination folder: " + created);
            }

            Path source = Paths.get(sourceFile.getAbsolutePath());
            System.out.println("Source path: " + source);

            Path destination = Paths.get(destinationFolder.getAbsolutePath(), sourceFile.getName());
            System.out.println("Destination path: " + destination);

            System.out.println("Moving file: " + source + " to: " + destination);

            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully to: " + destination);

            return true;

        } catch (IOException e) {
            System.err.println("\nError moving file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("\nNull pointer exception: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("\nUnexpected error: " + e.getMessage());
            e.printStackTrace();
        }
                return false;
    }
}
