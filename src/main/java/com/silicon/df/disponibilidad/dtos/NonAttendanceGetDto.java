package com.silicon.df.disponibilidad.dtos;

import com.silicon.df.disponibilidad.models.AbsenceReason;
import com.silicon.df.disponibilidad.models.User;

import java.time.LocalDate;

public record NonAttendanceGetDto(Long id,
                                  AbsenceReason absenceReason,
                                  String description,
                                  LocalDate startDate,
                                  LocalDate endDate) {
}
