package com.restful.elementary.school.management.dto.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.elementary.school.management.entity.Teacher;
import com.restful.elementary.school.management.entity.enums.Discipline;

import java.time.LocalDate;
import java.util.List;

public record DadosListagemTeacher(

        String name,
        String email,
        String cpf,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate,

        List<Discipline> disciplines
) {

    public DadosListagemTeacher(Teacher teacher) {
        this(
                teacher.getName(),
                teacher.getEmail(),
                teacher.getCpf(),
                teacher.getBirthDate(),
                teacher.getDisciplines()
        );
    }
}
