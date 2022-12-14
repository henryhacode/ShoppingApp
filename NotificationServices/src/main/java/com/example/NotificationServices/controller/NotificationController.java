package com.example.NotificationServices.controller;

import com.example.NotificationServices.dto.NotificationDto;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {
    @PostMapping("")
    public String createNotification(@RequestBody NotificationDto notification) {
        System.out.println("Notification: createNotification");
        String result = "Message " + notification.getSubject() + " was sent to " + notification.getEmail();
        System.out.println("Notification: Delivered notification: " + result);
        return result;
    }
}
