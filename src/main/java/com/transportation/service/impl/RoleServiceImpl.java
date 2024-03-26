package com.transportation.service.impl;

import com.transportation.entity.Role;
import com.transportation.repository.RoleRepository;
import com.transportation.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired private RoleRepository repository;

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }
}
