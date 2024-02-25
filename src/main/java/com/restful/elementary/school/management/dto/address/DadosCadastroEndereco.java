package com.restful.elementary.school.management.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosCadastroEndereco(

        @NotBlank(message = "O campo rua é obrigatório")
        @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "O nome deve conter apenas letras e espaços")
        String street,

        @NotBlank(message = "O campo número é obrigatório")
        @Pattern(regexp = "^[0-9]{1,6}$", message = "O campo número deve conter de 1 a 6 dígitos")
        String number,

        @NotBlank(message = "O campo bairro é obrigatório")
        @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "O nome deve conter apenas letras e espaços")
        String neighborhood,

        @NotBlank(message = "O campo cidade é obrigatório")
        @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "O nome deve conter apenas letras e espaços")
        String city,

        @NotBlank(message = "O campo estado é obrigatório")
        @Pattern(regexp = "^[A-Z]{2}$")
        String state,

        @NotBlank(message = "O campo país é obrigatório")
        @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "O nome deve conter apenas letras e espaços")
        String country,

        @NotBlank(message = "O CEP não pode ser nulo")
        @Pattern(regexp = "^\\d{2}(\\.?\\d{3})[- ]?\\d{3}$")
        String zipCode,

        String complement
) {
}
