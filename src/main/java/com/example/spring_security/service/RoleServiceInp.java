package com.example.spring_security.service;

import com.example.spring_security.dao.RoleRepository;
import com.example.spring_security.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceInp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceInp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }


}
