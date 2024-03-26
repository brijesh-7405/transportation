package com.transportation.dto;

import lombok.Data;

@Data
public class ClientDTO {
    private Long clientId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String profileImage;
    private Long createdBy;
    private Long updatedBy;
    private String notificationToken;
    private String password;
}
