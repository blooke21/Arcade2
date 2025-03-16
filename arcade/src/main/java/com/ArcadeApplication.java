package com;

import javax.swing.JFileChooser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArcadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArcadeApplication.class, args);
    }

    @Bean
    public JFileChooser fileChooser() {
        return new JFileChooser();
    }

}
