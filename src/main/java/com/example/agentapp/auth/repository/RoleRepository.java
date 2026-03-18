package com.example.agentapp.auth.repository;

import com.example.agentapp.auth.model.Role;
import com.example.agentapp.auth.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
    boolean existsByName(String name);
}
