package com.photokinisi.repositories;

import com.photokinisi.repositories.entities.Role;
import com.photokinisi.repositories.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findRoleByName(String role);
}