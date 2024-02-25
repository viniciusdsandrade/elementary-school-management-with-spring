package com.restful.elementary.school.management.service;

import com.restful.elementary.school.management.dto.student.DadosCadastroStudent;
import com.restful.elementary.school.management.dto.student.DadosListagemStudent;
import com.restful.elementary.school.management.entity.Student;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface StudentService {

    @Transactional
    Student save(@Valid DadosCadastroStudent dadosCadastroStudent);

    @Transactional
    void delete(Long id);

    Student findById(Long id);

    Page<DadosListagemStudent> findAll(Pageable pageable);

    Page<DadosListagemStudent> findByName(String name, Pageable pageable);

    Page<DadosListagemStudent> findByEmail(String email, Pageable page);
}
