package com.dasetova.login_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasetova.login_service.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
