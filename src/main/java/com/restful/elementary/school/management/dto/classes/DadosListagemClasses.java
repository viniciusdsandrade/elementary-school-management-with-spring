package com.restful.elementary.school.management.dto.classes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.elementary.school.management.entity.Classes;
import com.restful.elementary.school.management.entity.Group;
import com.restful.elementary.school.management.entity.Teacher;
import com.restful.elementary.school.management.entity.enums.Discipline;
import com.restful.elementary.school.management.entity.enums.Room;
import com.restful.elementary.school.management.entity.enums.Time;

import java.time.LocalDate;

public record DadosListagemClasses(

        Teacher teacher,
        Group group,
        Time time,
        Room room,
        Discipline discipline,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate startDate,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate endDate
) {

    public DadosListagemClasses(Classes classesEntity) {
        this(
                classesEntity.getTeacher(),
                classesEntity.getGroup(),
                classesEntity.getTime(),
                classesEntity.getRoom(),
                classesEntity.getDiscipline(),
                classesEntity.getStartDateTime(),
                classesEntity.getEndDateTime()
        );
    }
}
