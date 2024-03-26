package com.transportation.service.impl;

import com.transportation.entity.Role;
import com.transportation.entity.User;
import com.transportation.repository.RoleRepository;
import com.transportation.repository.UserRepository;
import com.transportation.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Long createUser(User user) {
//        Set<Role> roles =  roleRepository.findAll().stream().filter(f->f.getRoleName().equals("SUPER_ADMIN")|| f.getRoleName().equals("ADMIN")).collect(Collectors.toSet());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(roles);
        return userRepository.save(user).getUserId();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUser(Long userId, User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());

            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long userId) {
        // Check if the user exists
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
