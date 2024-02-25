package com.restful.elementary.school.management.controller;

import com.restful.elementary.school.management.dto.teacher.DadosCadastroTeacher;
import com.restful.elementary.school.management.dto.teacher.DadosDetalhamentoTeacher;
import com.restful.elementary.school.management.dto.teacher.DadosListagemTeacher;
import com.restful.elementary.school.management.entity.Teacher;
import com.restful.elementary.school.management.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/teacher")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<DadosListagemTeacher> create(
            @RequestBody @Valid DadosCadastroTeacher dadosCadastroTeacher,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Teacher teacher = teacherService.save(dadosCadastroTeacher);
        URI uri = uriComponentsBuilder.path("/api/v1/teacher/{id}").buildAndExpand(teacher.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemTeacher(teacher));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTeacher>> findAll(
            @PageableDefault(size = 5, sort = {"name"}) Pageable page
    ) {
        Page<DadosListagemTeacher> teachers = teacherService.findAll(page);
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTeacher> findById(@PathVariable Long id) {
        Teacher teacher = teacherService.findById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTeacher(teacher));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<DadosListagemTeacher>> findByName(
            @PathVariable String name,
            @PageableDefault(sort = "id", size = 20)
            @RequestParam(required = false) Pageable page) {
        Page<DadosListagemTeacher> teachers = teacherService.findByName(name, page);
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Page<DadosListagemTeacher>> findByEmail(
            @PathVariable String email,
            @PageableDefault(sort = "id", size = 20)
            @RequestParam(required = false) Pageable page) {
        Page<DadosListagemTeacher> teachers = teacherService.findByEmail(email, page);
        return ResponseEntity.ok(teachers);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
