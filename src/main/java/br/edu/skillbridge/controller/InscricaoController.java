package br.edu.skillbridge.controller;

import br.edu.skillbridge.model.Inscricao;
import br.edu.skillbridge.service.InscricaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    private final InscricaoService service;
    public InscricaoController(InscricaoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Inscricao> create(@Valid @RequestBody Inscricao i) {
        Inscricao created = service.create(i);
        return ResponseEntity.created(URI.create("/inscricoes/" + created.getId())).body(created);
    }

    @GetMapping("/profissional/{id}")
    public List<Inscricao> findByProfissional(@PathVariable Long id) {
        return service.findByProfissional(id);
    }
}
