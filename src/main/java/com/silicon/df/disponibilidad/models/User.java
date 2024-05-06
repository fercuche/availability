package com.silicon.df.disponibilidad.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class
User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Integer dni;
    private String password;
    private boolean enabled;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<NonAttendance> nonAttendances = new HashSet<>();


    public User(String firstName, String lastName, String email, Integer dni, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dni = dni;
        this.password = password;
    }

    public void addNonAttendance(NonAttendance nonAttendance) {
        nonAttendance.setUser(this);
        nonAttendances.add(nonAttendance);
    }
}
