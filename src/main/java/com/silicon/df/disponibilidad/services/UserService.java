package com.silicon.df.disponibilidad.services;

import com.silicon.df.disponibilidad.dtos.NonAttendanceGetDto;
import com.silicon.df.disponibilidad.dtos.UserGetDto;
import com.silicon.df.disponibilidad.dtos.UserPostDto;
import com.silicon.df.disponibilidad.models.NonAttendance;
import com.silicon.df.disponibilidad.models.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    UserGetDto mapUserToUserGetDto(User user);
    List<UserGetDto> mapUsersToUserGetDto(List<User> users);
    List<User> getUsers();
    UserGetDto getUser(Long id);
    UserGetDto createUser(UserPostDto userDto);
    List<NonAttendanceGetDto> getNonAttendances(Set<NonAttendance> nonAttendanceSet);
}
