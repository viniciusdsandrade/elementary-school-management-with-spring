package com.restful.elementary.school.management.dto.classes;

import com.restful.elementary.school.management.entity.Group;
import com.restful.elementary.school.management.entity.Teacher;
import com.restful.elementary.school.management.entity.enums.Discipline;
import com.restful.elementary.school.management.entity.enums.Room;
import com.restful.elementary.school.management.entity.enums.Time;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroClasses(

        @Valid
        @NotNull(message = "Teacher cannot be null")
        Teacher teacher,

        @Valid
        @NotNull(message = "Group cannot be null")
        Group group,

        @Valid
        @NotNull(message = "Time cannot be null")
        Time time,

        @Valid
        @NotNull(message = "Room cannot be null")
        Room room,

        @Valid
        @NotNull(message = "Discipline cannot be null")
        Discipline discipline,

        LocalDate startDateTime,
        LocalDate endDateTime
) {
}
