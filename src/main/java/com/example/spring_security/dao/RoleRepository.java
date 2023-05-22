package com.example.spring_security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.spring_security.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
