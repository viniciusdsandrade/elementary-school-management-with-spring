package com.restful.elementary.school.management.controller;

import com.restful.elementary.school.management.dto.group.DadosCadastroGroup;
import com.restful.elementary.school.management.dto.group.DadosListagemGroup;
import com.restful.elementary.school.management.entity.Group;
import com.restful.elementary.school.management.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/group")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<DadosListagemGroup> create(
            @RequestBody DadosCadastroGroup dadosCadastroGroup,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Group group = groupService.save(dadosCadastroGroup);
        URI uri = uriComponentsBuilder.path("/api/v1/group/{id}").buildAndExpand(group.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemGroup(group));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemGroup>> findAll(
            @PageableDefault(size = 5) Pageable page
    ) {
        Page<DadosListagemGroup> groups = groupService.findAll(page);
        return ResponseEntity.ok((groups));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DadosListagemGroup>> findAll() {
        List<DadosListagemGroup> groups = groupService.findAllList();
        return ResponseEntity.ok((groups));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemGroup> findById(@PathVariable Long id) {
        Group group = groupService.findById(id);
        return ResponseEntity.ok(new DadosListagemGroup(group));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
