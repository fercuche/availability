package com.silicon.df.disponibilidad.dtos;

import com.silicon.df.disponibilidad.models.NonAttendance;

import java.util.Set;

public record UserPostDto(String firstName,
                          String lastName,
                          String email,
                          Integer dni,
                          String password) {
}
