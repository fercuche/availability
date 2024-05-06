package com.silicon.df.disponibilidad;

import com.silicon.df.disponibilidad.models.AbsenceReason;
import com.silicon.df.disponibilidad.models.NonAttendance;
import com.silicon.df.disponibilidad.models.User;
import com.silicon.df.disponibilidad.repositories.NonAttendanceRepository;
import com.silicon.df.disponibilidad.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DisponibilidadApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisponibilidadApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, NonAttendanceRepository nonAttendanceRepository){
        return (args -> {
            User user1 = new User("Melba", "Morel", "melbam@mail.com", 33333333, "asd123");
            User user2 = new User("Dolores", "Aguirre", "dlra@mail.com", 33333334, "asd123");
            User user3 = new User("Leonel", "Marengo", "leomar@mail.com", 33333335, "asd123");

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            NonAttendance nonAttendance1 = new NonAttendance(AbsenceReason.MEDICAL_APPOINTMENT,"", LocalDate.now(), LocalDate.now().plusDays(5),user1);
            NonAttendance nonAttendance2 = new NonAttendance(AbsenceReason.ACCIDENT_LEAVE,"", LocalDate.now(), LocalDate.now().plusDays(10),user2);
            NonAttendance nonAttendance3 = new NonAttendance(AbsenceReason.VACATION,"", LocalDate.now(), LocalDate.now().plusDays(30),user3);

            nonAttendanceRepository.save(nonAttendance1);
            nonAttendanceRepository.save(nonAttendance2);
            nonAttendanceRepository.save(nonAttendance3);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

        });
    }

}
