package com.restful.elementary.school.management.service.impl;

import com.restful.elementary.school.management.dto.group.DadosCadastroGroup;
import com.restful.elementary.school.management.dto.group.DadosListagemGroup;
import com.restful.elementary.school.management.entity.Group;
import com.restful.elementary.school.management.entity.Student;
import com.restful.elementary.school.management.exception.BadRequestException;
import com.restful.elementary.school.management.exception.ResourceNotFoundException;
import com.restful.elementary.school.management.repository.GroupRepository;
import com.restful.elementary.school.management.repository.StudentRepository;
import com.restful.elementary.school.management.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public GroupServiceImpl(GroupRepository groupRepository,
                            StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public Group save(DadosCadastroGroup dadosCadastroGroup) {

        // Verifica se há pelo menos um estudante na lista
        if (dadosCadastroGroup.students().isEmpty())
            throw new BadRequestException("At least one student is required");

        Group group = new Group();
        group.setPeriod(dadosCadastroGroup.period());
        group.setStartDateTime(dadosCadastroGroup.startDate());
        group.setEndDateTime(dadosCadastroGroup.endDate());
        group.setObservation(dadosCadastroGroup.observation());

        List<Student> students = new ArrayList<>();

        // Obtém os IDs dos alunos do DadosCadastroGroup
        List<Long> studentIds = dadosCadastroGroup
                .students()
                .stream()
                .map(Student::getId)
                .collect(Collectors.toList());

        // Busca os alunos no banco de dados pelos IDs
        Iterable<Student> studentIterable = studentRepository.findAllById(studentIds);
        studentIterable.forEach(students::add);

        group.addStudents(students); // Adiciona os alunos ao grupo

        return groupRepository.save(group); // Salva o grupo no repositório
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Group not found"));
        groupRepository.delete(group);
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Group not found"));
    }

    @Override
    public Page<DadosListagemGroup> findAll(Pageable pageable) {
        return groupRepository.findAll(pageable)
                .map(DadosListagemGroup::new);
    }

    @Override
    public List<DadosListagemGroup> findAllList() {
        return groupRepository.findAll()
                .stream()
                .map(DadosListagemGroup::new)
                .collect(Collectors.toList());
    }
}