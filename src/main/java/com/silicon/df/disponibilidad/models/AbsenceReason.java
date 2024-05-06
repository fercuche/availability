package com.silicon.df.disponibilidad.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AbsenceReason {

    MEDICAL_APPOINTMENT,
    PERSONAL_MATTERS,
    PATERNITY_LEAVE,
    SICKNESS_LEAVE,
    ACCIDENT_LEAVE,
    EVENT_ATTENDANCE,
    VACATION,
    OTHER_LEAVE


}
