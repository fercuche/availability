package com.silicon.df.disponibilidad.services;

import com.silicon.df.disponibilidad.dtos.NonAttendanceGetDto;
import com.silicon.df.disponibilidad.dtos.NonAttendancePostDto;

public interface NonAttendanceService {

    NonAttendanceGetDto createNonAttendance(NonAttendancePostDto nonAttendancePostDto);
}
