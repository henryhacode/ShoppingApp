package com.example.controller;

import com.example.dto.NotificationDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping("")
    public NotificationDto createNotification(@RequestBody NotificationDto notification) {
        System.out.println("createNotification");
        //do something
        return notification;
    }
}
