package com.transportation.security.service;

import lombok.Data;

import java.util.List;

@Data
public class UserDetailsDto {
    private Long userId;
    private String userName;
    private String email;
    private List<String> roles;
}
