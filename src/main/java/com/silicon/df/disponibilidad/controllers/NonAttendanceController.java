package com.silicon.df.disponibilidad.controllers;

import com.silicon.df.disponibilidad.dtos.NonAttendanceGetDto;
import com.silicon.df.disponibilidad.dtos.NonAttendancePostDto;
import com.silicon.df.disponibilidad.services.NonAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/non-attendances")
public class NonAttendanceController {

    @Autowired
    private NonAttendanceService nonAttendanceService;

    @PostMapping()
    public NonAttendanceGetDto createNonAttendance(@RequestBody NonAttendancePostDto nonAttendancePostDto) {
        return nonAttendanceService.createNonAttendance(nonAttendancePostDto);
    }
}
