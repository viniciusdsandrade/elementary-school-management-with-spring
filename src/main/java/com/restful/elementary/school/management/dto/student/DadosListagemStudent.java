package com.restful.elementary.school.management.dto.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.elementary.school.management.entity.Student;

import java.time.LocalDate;

public record DadosListagemStudent(

        String name,
        String email,
        String cpf,

        @JsonFormat(pattern = "dd/MM/yyyy",
                shape = JsonFormat.Shape.STRING,
                locale = "pt-BR",
                timezone = "Brazil/East",
                with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        LocalDate birthDate,

        String parentName,
        String parentEmail,
        String parentPhoneNumber,
        String allergies,
        String medicalConditions
) {

    public DadosListagemStudent(Student student) {
        this(
                student.getName(),
                student.getEmail(),
                student.getCpf(),
                student.getBirthDate(),
                student.getParentName(),
                student.getParentEmail(),
                student.getParentPhoneNumber(),
                student.getAllergies(),
                student.getMedicalConditions()
        );
    }
}
