package Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
