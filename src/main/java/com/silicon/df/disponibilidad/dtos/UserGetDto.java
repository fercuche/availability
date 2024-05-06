package com.silicon.df.disponibilidad.dtos;

import com.silicon.df.disponibilidad.models.NonAttendance;

import java.util.List;

public record UserGetDto(Long id,
                         String firstName,
                         String lastName,
                         String email,
                         Integer dni,
                         List<NonAttendanceGetDto> nonAttendances) {

}
