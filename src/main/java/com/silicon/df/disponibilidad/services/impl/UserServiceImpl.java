package com.silicon.df.disponibilidad.services.impl;

import com.silicon.df.disponibilidad.dtos.NonAttendanceGetDto;
import com.silicon.df.disponibilidad.dtos.UserGetDto;
import com.silicon.df.disponibilidad.dtos.UserPostDto;
import com.silicon.df.disponibilidad.models.NonAttendance;
import com.silicon.df.disponibilidad.models.User;
import com.silicon.df.disponibilidad.repositories.UserRepository;
import com.silicon.df.disponibilidad.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private MessageSource messageSource;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserGetDto getUser(Long id) throws ResourceNotFoundException {
        if (!userRepository.existsById(id)) {   
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
        return mapUserToUserGetDto(userRepository.findById(id).get());
    }

    @Override
    public UserGetDto createUser(UserPostDto userPostDto) {
        User user = new User(
                userPostDto.firstName(),
                userPostDto.lastName(),
                userPostDto.email(),
                userPostDto.dni(),
                userPostDto.password());
        userRepository.save(user);
       return mapUserToUserGetDto(user);
    }

    @Override
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

    @Override
    public UserGetDto mapUserToUserGetDto(User user) {
        return userRepository.getUserById(user.getId()).map(u -> new UserGetDto(
                        u.getId(),u.getFirstName(), u.getLastName(),
                        u.getEmail(),u.getDni(), getNonAttendances(u.getNonAttendances())))
                .orElse(null);
    }

    @Override
    public List<UserGetDto> mapUsersToUserGetDto(List<User> users) {
        return userRepository.findAll().stream().map(user -> new UserGetDto(
                        user.getId(),user.getFirstName(), user.getLastName(),
                        user.getEmail(),user.getDni(), getNonAttendances(user.getNonAttendances())))
                .collect(toList());
    }
}
