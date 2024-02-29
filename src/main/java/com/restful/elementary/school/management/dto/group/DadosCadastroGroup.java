package com.restful.elementary.school.management.dto.group;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.elementary.school.management.dto.classes.DadosCadastroClass;
import com.restful.elementary.school.management.dto.student.DadosCadastroStudent;
import com.restful.elementary.school.management.entity.Classes;
import com.restful.elementary.school.management.entity.Student;
import com.restful.elementary.school.management.entity.enums.Period;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public record DadosCadastroGroup(

        @Valid
        @NotNull(message = "Period is required")
        Period period,

        @Valid
        @NotEmpty(message = "Students is required")
        List<Student> students,

        @Valid
        @NotEmpty(message = "Classes is required")
        Set<Classes> classes,

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
    public DadosCadastroGroup {
        Objects.requireNonNull(period);
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(endDate);
        Objects.requireNonNull(observation);
        Objects.requireNonNull(students);
        Objects.requireNonNull(classes);
    }
}
