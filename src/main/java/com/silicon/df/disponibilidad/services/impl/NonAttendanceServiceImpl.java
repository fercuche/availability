package com.silicon.df.disponibilidad.services.impl;

import com.silicon.df.disponibilidad.dtos.NonAttendanceGetDto;
import com.silicon.df.disponibilidad.dtos.NonAttendancePostDto;
import com.silicon.df.disponibilidad.models.AbsenceReason;
import com.silicon.df.disponibilidad.models.NonAttendance;
import com.silicon.df.disponibilidad.models.User;
import com.silicon.df.disponibilidad.repositories.NonAttendanceRepository;
import com.silicon.df.disponibilidad.repositories.UserRepository;
import com.silicon.df.disponibilidad.services.NonAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NonAttendanceServiceImpl implements NonAttendanceService {

    @Autowired
    private NonAttendanceRepository nonAttendanceRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public NonAttendanceGetDto createNonAttendance(NonAttendancePostDto nonAttendancePostDto) {

        AbsenceReason reason = AbsenceReason.valueOf(nonAttendancePostDto.absenceReason());

        User user = userRepository.getUserById(nonAttendancePostDto.userId()).get();

        NonAttendance nonAttendance = new NonAttendance(
                reason,
                nonAttendancePostDto.description(),
                nonAttendancePostDto.startDate(),
                nonAttendancePostDto.endDate(),
                user
                );

        user.addNonAttendance(nonAttendance);
        nonAttendanceRepository.save(nonAttendance);

        return nonAttendanceRepository.findById(
                nonAttendance.getId())
                .map(n -> new NonAttendanceGetDto(
                        n.getId(),
                        n.getReason(),
                        n.getDescription(),
                        n.getStartDate(),
                        n.getEndDate()))
                .orElse(null);

    }
}
