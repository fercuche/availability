package com.silicon.df.disponibilidad.repositories;

import com.silicon.df.disponibilidad.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{

    //List<User> findAll();
    User findByEmail(String email);
    Optional<User> getUserById(Long id);
}
