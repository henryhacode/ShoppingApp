package com.example.NotificationServices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {
    private int id;
    private String email;
    private String subject;
    private String content;
}
