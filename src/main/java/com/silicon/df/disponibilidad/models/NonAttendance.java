package com.silicon.df.disponibilidad.models;

import jakarta.persistence.*;
import lombok.*;
import java.io.File;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "non_attendances")
public class NonAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NonNull
    private AbsenceReason reason;
    @NonNull
    private String description;
    @NonNull
    private LocalDate startDate;
    @NonNull
    private LocalDate endDate;
    private File document;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;



}
