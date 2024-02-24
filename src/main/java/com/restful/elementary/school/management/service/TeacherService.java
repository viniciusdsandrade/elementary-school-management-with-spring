package com.restful.elementary.school.management.service;

import com.restful.elementary.school.management.dto.teacher.DadosCadastroTeacher;
import com.restful.elementary.school.management.dto.teacher.DadosListagemTeacher;
import com.restful.elementary.school.management.entity.Teacher;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

public interface TeacherService {

    @Transactional
    Teacher save(@Valid DadosCadastroTeacher dadosCadastroTeacher);

    @Transactional
    void delete(Long id);

    Teacher findById(Long id);

    Page<DadosListagemTeacher> findAll(Pageable pageable);

    Page<DadosListagemTeacher> findByName(String name, Pageable pageable);
}
