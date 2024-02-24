package com.restful.elementary.school.management.dto.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.elementary.school.management.dto.address.DadosCadastroEndereco;
import com.restful.elementary.school.management.entity.enums.Discipline;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroTeacher(

        @NotNull(message = "O nome não pode ser nulo")
        @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "O nome deve conter apenas letras e espaços")
        String name,

        @Email(message = "O email deve ser válido")
        @NotNull(message = "O email não pode ser nulo")
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
        String cpf,

        @Valid
        @NotNull(message = "Deve ministrar pelo menos uma disciplina")
        List<Discipline> disciplines,

        @Valid
        @NotNull(message = "O endereço não pode ser nulo")
        DadosCadastroEndereco address
) {
}
