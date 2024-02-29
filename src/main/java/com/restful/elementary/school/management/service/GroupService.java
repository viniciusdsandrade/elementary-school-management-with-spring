package com.restful.elementary.school.management.service;

import com.restful.elementary.school.management.dto.group.DadosCadastroGroup;
import com.restful.elementary.school.management.dto.group.DadosListagemGroup;
import com.restful.elementary.school.management.entity.Group;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface GroupService {

    @Transactional
    Group save(@Valid DadosCadastroGroup dadosCadastroGroup);

    @Transactional
    void delete(Long id);

    Group findById(Long id);

    Page<DadosListagemGroup> findAll(Pageable pageable);
}
