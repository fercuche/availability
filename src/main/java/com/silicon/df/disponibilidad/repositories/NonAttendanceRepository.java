package com.silicon.df.disponibilidad.repositories;

import com.silicon.df.disponibilidad.models.NonAttendance;
import com.silicon.df.disponibilidad.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface NonAttendanceRepository extends JpaRepository<NonAttendance, Long> {

    //List<NonAttendance> findAll();
    NonAttendance findById(long id);

}
