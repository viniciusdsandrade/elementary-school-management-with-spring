package com.restful.elementary.school.management.dto.address;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(

        @NotBlank(message = "O campo rua é obrigatório")
        String street,

        @NotBlank(message = "O campo número é obrigatório")
        @Pattern(regexp = "^[0-9]{1,6}$", message = "O campo número deve conter de 1 a 6 dígitos")
        String number,

        @NotBlank(message = "O campo bairro é obrigatório")
        String neighborhood,

        @NotBlank(message = "O campo cidade é obrigatório")
        String city,

        @NotBlank(message = "O campo estado é obrigatório")
        @Pattern(regexp = "^[A-Z]{2}$")
        String state,

        @NotBlank(message = "O campo país é obrigatório")
        String country,

        @NotBlank(message = "O CEP não pode ser nulo")
        @Pattern(regexp = "^\\d{2}(\\.?\\d{3})[- ]?\\d{3}$")
        String zipCode,

        String complement
) {
}
