package com.restful.elementary.school.management.service.impl;

import com.restful.elementary.school.management.dto.group.DadosCadastroGroup;
import com.restful.elementary.school.management.dto.group.DadosListagemGroup;
import com.restful.elementary.school.management.entity.Group;
import com.restful.elementary.school.management.repository.GroupRepository;
import com.restful.elementary.school.management.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group save(DadosCadastroGroup dadosCadastroGroup) {

        Group group = new Group(dadosCadastroGroup);
        return groupRepository.save(group);
    }

    @Override
    public void delete(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
        groupRepository.delete(group);
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
    }

    @Override
    public Page<DadosListagemGroup> findAll(Pageable pageable) {
        return groupRepository.findAll(pageable)
                .map(DadosListagemGroup::new);
    }
}