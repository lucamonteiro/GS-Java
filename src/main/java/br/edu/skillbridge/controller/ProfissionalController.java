package br.edu.skillbridge.controller;

import br.edu.skillbridge.model.Profissional;
import br.edu.skillbridge.service.ProfissionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {
    private final ProfissionalService service;
    public ProfissionalController(ProfissionalService service) { this.service = service; }

    @GetMapping
    public List<Profissional> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Profissional> create(@Valid @RequestBody Profissional p) {
        Profissional created = service.create(p);
        return ResponseEntity.created(URI.create("/profissionais/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissional> update(@PathVariable Long id, @Valid @RequestBody Profissional p) {
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
