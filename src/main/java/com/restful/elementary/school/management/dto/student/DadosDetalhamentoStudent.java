package com.restful.elementary.school.management.dto.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.elementary.school.management.dto.address.DadoDetalhamentoEndereco;
import com.restful.elementary.school.management.entity.Student;

import java.time.LocalDate;

public record DadosDetalhamentoStudent(

        Long id,
        String name,
        String email,
        String cpf,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate,

        String parentName,
        String parentEmail,
        String parentPhoneNumber,
        String allergies,
        String medicalConditions,

        DadoDetalhamentoEndereco address
) {


    public DadosDetalhamentoStudent(Student student) {
        this(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCpf(),
                student.getBirthDate(),
                student.getParentName(),
                student.getParentEmail(),
                student.getParentPhoneNumber(),
                student.getAllergies(),
                student.getMedicalConditions(),
                new DadoDetalhamentoEndereco(student)
        );
    }
}
