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

        @JsonFormat(pattern = "dd/MM/yyyy",
                shape = JsonFormat.Shape.STRING,
                locale = "pt-BR",
                timezone = "Brazil/East",
                with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
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
