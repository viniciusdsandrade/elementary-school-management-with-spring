package com.restful.elementary.school.management.dto.address;

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
    public DadoDetalhamentoEndereco(String street,
                                    String number,
                                    String neighborhood,
                                    String city,
                                    String state,
                                    String country,
                                    String zipCode,
                                    String complement) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.complement = complement;
    }

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
}
