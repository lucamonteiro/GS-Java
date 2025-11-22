package br.edu.skillbridge.controller;

import br.edu.skillbridge.model.ProgramaTransicao;
import br.edu.skillbridge.service.ProgramaTransicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/programas")
public class ProgramaTransicaoController {
    private final ProgramaTransicaoService service;
    public ProgramaTransicaoController(ProgramaTransicaoService service) { this.service = service; }

    @GetMapping
    public List<ProgramaTransicao> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaTransicao> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProgramaTransicao> create(@Valid @RequestBody ProgramaTransicao p) {
        ProgramaTransicao created = service.create(p);
        return ResponseEntity.created(URI.create("/programas/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaTransicao> update(@PathVariable Long id, @Valid @RequestBody ProgramaTransicao p) {
        try {
            return ResponseEntity.ok(service.update(id, p));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
