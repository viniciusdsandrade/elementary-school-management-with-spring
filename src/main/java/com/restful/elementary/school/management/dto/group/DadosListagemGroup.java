package com.restful.elementary.school.management.dto.group;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restful.elementary.school.management.dto.classes.DadosListagemClasses;
import com.restful.elementary.school.management.dto.student.DadosListagemStudent;
import com.restful.elementary.school.management.entity.Group;
import com.restful.elementary.school.management.entity.enums.Period;

import java.time.LocalDate;
import java.util.List;

public record DadosListagemGroup(

        Period period,
        List<DadosListagemStudent> students,

        List<DadosListagemClasses> classes,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate startDate,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate endDate,

        String observation
) {
        public DadosListagemGroup(Group group) {
                this(
                        group.getPeriod(),
                        group.getStudents().stream().map(DadosListagemStudent::new).toList(),
                        group.getClasses().stream().map(DadosListagemClasses::new).toList(),
                        group.getStartDateTime(),
                        group.getEndDateTime(),
                        group.getObservation()
                );
        }
}
