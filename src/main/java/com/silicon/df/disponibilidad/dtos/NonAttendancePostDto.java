package com.silicon.df.disponibilidad.dtos;

import com.silicon.df.disponibilidad.models.AbsenceReason;

import java.time.LocalDate;

public record NonAttendancePostDto(String absenceReason,
                                   String description,
                                   LocalDate startDate,
                                   LocalDate endDate,
                                   Long userId) {
}
