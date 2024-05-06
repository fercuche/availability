package com.silicon.df.disponibilidad.controllers;

import com.silicon.df.disponibilidad.dtos.NonAttendanceGetDto;
import com.silicon.df.disponibilidad.dtos.UserGetDto;
import com.silicon.df.disponibilidad.dtos.UserPostDto;
import com.silicon.df.disponibilidad.models.NonAttendance;
import com.silicon.df.disponibilidad.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserGetDto> getUsersDto() {
        return userService.getUsers().stream().map(user -> new UserGetDto(
                user.getId(),user.getFirstName(), user.getLastName(),
                        user.getEmail(),user.getDni(), getNonAttendances(user.getNonAttendances())))
                .collect(toList());
    }

    @GetMapping("/{id}")
    public UserGetDto getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public UserGetDto createUser(@RequestBody UserPostDto userDto){
        return userService.createUser(userDto);
    }

    public List<NonAttendanceGetDto> getNonAttendances(Set<NonAttendance> nonAttendanceSet) {
        return nonAttendanceSet.stream()
                .map(nonAttendance -> new NonAttendanceGetDto(
                        nonAttendance.getId(),
                        nonAttendance.getReason(),
                        nonAttendance.getDescription(),
                        nonAttendance.getStartDate(),
                        nonAttendance.getEndDate()))
                .collect(toList());
    }
}
