package com.restful.elementary.school.management.service.impl;

import com.restful.elementary.school.management.dto.student.DadosCadastroStudent;
import com.restful.elementary.school.management.dto.student.DadosListagemStudent;
import com.restful.elementary.school.management.entity.Student;
import com.restful.elementary.school.management.exception.DuplicateEntryException;
import com.restful.elementary.school.management.exception.ResourceNotFoundException;
import com.restful.elementary.school.management.repository.StudentRepository;
import com.restful.elementary.school.management.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(DadosCadastroStudent dadosCadastroStudent) {

        if (studentRepository.existsByCpf(dadosCadastroStudent.cpf()))
            throw new DuplicateEntryException("CPF already exists");

        if (studentRepository.existsByEmail(dadosCadastroStudent.email()))
            throw new DuplicateEntryException("Email already exists");

        Student student = new Student(dadosCadastroStudent);
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        studentRepository.delete(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public Page<DadosListagemStudent> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(DadosListagemStudent::new);
    }

    @Override
    public Page<DadosListagemStudent> findByName(String name, Pageable pageable) {
        return studentRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(DadosListagemStudent::new);
    }

    @Override
    public Page<DadosListagemStudent> findByEmail(String email, Pageable page) {
        return studentRepository.findByEmailContainingIgnoreCase(email, page)
                .map(DadosListagemStudent::new);
    }
}
