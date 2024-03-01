package com.restful.elementary.school.management.dto.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.elementary.school.management.entity.Group;
import com.restful.elementary.school.management.entity.Student;

import java.time.LocalDate;

public record DadosListagemStudent(

        String name,
        String email,
        String cpf,

        @JsonFormat(pattern = "dd/MM/yyyy")
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

    public DadosListagemStudent(Group group) {
        this(
                group.getStudents().stream().map(Student::getName).toList().toString(),
                group.getStudents().stream().map(Student::getEmail).toList().toString(),
                group.getStudents().stream().map(Student::getCpf).toList().toString(),
                group.getStudents().stream().map(Student::getBirthDate).toList().getFirst(),
                group.getStudents().stream().map(Student::getParentName).toList().toString(),
                group.getStudents().stream().map(Student::getParentEmail).toList().toString(),
                group.getStudents().stream().map(Student::getParentPhoneNumber).toList().toString(),
                group.getStudents().stream().map(Student::getAllergies).toList().toString(),
                group.getStudents().stream().map(Student::getMedicalConditions).toList().toString()
        );
    }
}
