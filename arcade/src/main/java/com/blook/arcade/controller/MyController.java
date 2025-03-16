package com.blook.arcade.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blook.arcade.service.FileMover;

@Controller
@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Java!";
    }

    @Autowired
    private FileMover fileMover;

    @PostMapping("/addFile")
    public void addFile(@RequestBody Map<String, String> request) {
        String sourcePath = request.get("sourcePath");

        fileMover.moveFile(sourcePath);
    }
}
