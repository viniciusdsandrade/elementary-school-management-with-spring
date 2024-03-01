package com.restful.elementary.school.management.dto.group;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.elementary.school.management.entity.Student;
import com.restful.elementary.school.management.entity.enums.Period;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroGroup(

        @Valid
        @NotNull(message = "Period is required")
        Period period,

        @Valid
        @NotEmpty(message = "Students is required")
        List<Student> students,

        @NotNull(message = "Start date is required")
        @JsonFormat(pattern = "dd/MM/yyyy",
                shape = JsonFormat.Shape.STRING,
                locale = "pt-BR",
                timezone = "Brazil/East",
                with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        LocalDate startDate,

        @NotNull(message = "End date is required")
        @JsonFormat(pattern = "dd/MM/yyyy",
                shape = JsonFormat.Shape.STRING,
                locale = "pt-BR",
                timezone = "Brazil/East",
                with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        LocalDate endDate,

        String observation
) {
}
