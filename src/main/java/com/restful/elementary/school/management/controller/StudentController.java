package com.restful.elementary.school.management.controller;

import com.restful.elementary.school.management.dto.student.DadosCadastroStudent;
import com.restful.elementary.school.management.dto.student.DadosDetalhamentoStudent;
import com.restful.elementary.school.management.dto.student.DadosListagemStudent;
import com.restful.elementary.school.management.entity.Student;
import com.restful.elementary.school.management.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<DadosListagemStudent> create(
            @RequestBody DadosCadastroStudent dadosCadastroStudent,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Student student = studentService.save(dadosCadastroStudent);
        URI uri = uriComponentsBuilder.path("/api/v1/student/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemStudent(student));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemStudent>> findAll(
            @PageableDefault(size = 5, sort = {"name"}) Pageable page
    ) {
        Page<DadosListagemStudent> students = studentService.findAll(page);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoStudent> findById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return ResponseEntity.ok(new DadosDetalhamentoStudent(student));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<DadosListagemStudent>> findByName(
            @PathVariable String name,
            @PageableDefault(size = 5, sort = {"name"}) Pageable page
    ) {
        Page<DadosListagemStudent> students = studentService.findByName(name, page);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Page<DadosListagemStudent>> findByEmail(
            @PathVariable String email,
            @PageableDefault(size = 5, sort = {"name"}) Pageable page
    ) {
        Page<DadosListagemStudent> students = studentService.findByEmail(email, page);
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
