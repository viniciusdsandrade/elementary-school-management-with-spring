package com.restful.elementary.school.management.dto.address;

import com.restful.elementary.school.management.entity.Student;
import com.restful.elementary.school.management.entity.Teacher;

public record DadoDetalhamentoEndereco(
        String street,
        String number,
        String neighborhood,
        String city,
        String state,
        String country,
        String zipCode,
        String complement
) {

    public DadoDetalhamentoEndereco(Teacher teacher) {
        this(
                teacher.getAddress().getStreet(),
                teacher.getAddress().getNumber(),
                teacher.getAddress().getNeighborhood(),
                teacher.getAddress().getCity(),
                teacher.getAddress().getState(),
                teacher.getAddress().getCountry(),
                teacher.getAddress().getZipCode(),
                teacher.getAddress().getComplement()
        );
    }

    public DadoDetalhamentoEndereco(Student student) {
        this(
                student.getAddress().getStreet(),
                student.getAddress().getNumber(),
                student.getAddress().getNeighborhood(),
                student.getAddress().getCity(),
                student.getAddress().getState(),
                student.getAddress().getCountry(),
                student.getAddress().getZipCode(),
                student.getAddress().getComplement()
        );
    }
}
