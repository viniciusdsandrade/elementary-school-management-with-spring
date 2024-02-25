package com.restful.elementary.school.management.dto.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.elementary.school.management.dto.address.DadosCadastroEndereco;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record DadosCadastroStudent(

        @NotNull(message = "O nome não pode ser nulo")
        @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "O nome deve conter apenas letras e espaços")
        String name,

        @Email(message = "O email deve ser válido")
        @NotNull(message = "O email não pode ser nulo")
        @Column(unique = true)
        String email,

        @NotNull(message = "A data de nascimento não pode ser nula")
        @Past(message = "A data de nascimento deve ser no passado")
        @JsonFormat(pattern = "dd/MM/yyyy",
                shape = JsonFormat.Shape.STRING,
                locale = "pt-BR",
                timezone = "Brazil/East",
                with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        LocalDate birthDate,

        @NotNull(message = "O CPF não pode ser nulo")
        @CPF(message = "O CPF deve ser válido")
        @Pattern(regexp = "^[0-9]{11}$", message = "O CPF deve conter 11 dígitos")
        @Column(unique = true)
        String cpf,

        @Valid
        @NotNull(message = "O endereço não pode ser nulo")
        DadosCadastroEndereco address,

        @NotNull(message = "O nome não pode ser nulo")
        @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "O nome deve conter apenas letras e espaços")
        String parentName,

        @Email(message = "O email do responsável deve ser válido")
        @NotNull(message = "O email do responsável não pode ser nulo")
        String parentEmail,

        @Pattern(regexp = "^[0-9]{10,11}$", message = "O número de telefone do responsável deve conter entre 10 e 11 dígitos")
        String parentPhoneNumber,

        @Column(columnDefinition = "TEXT", nullable = true)
        String allergies,

        @Column(columnDefinition = "TEXT", nullable = true)
        String medicalConditions
) {
}
