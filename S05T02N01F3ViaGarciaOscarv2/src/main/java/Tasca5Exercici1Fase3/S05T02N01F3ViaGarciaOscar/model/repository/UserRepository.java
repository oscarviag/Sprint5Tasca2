package Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
