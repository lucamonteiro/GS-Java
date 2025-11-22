package br.edu.skillbridge.service;

import br.edu.skillbridge.model.ProgramaTransicao;
import br.edu.skillbridge.repository.ProgramaTransicaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramaTransicaoService {
    private final ProgramaTransicaoRepository repo;

    public ProgramaTransicaoService(ProgramaTransicaoRepository repo) {
        this.repo = repo;
    }

    public List<ProgramaTransicao> findAll() { return repo.findAll(); }
    public Optional<ProgramaTransicao> findById(Long id) { return repo.findById(id); }
    public ProgramaTransicao create(ProgramaTransicao p) { return repo.save(p); }
    public ProgramaTransicao update(Long id, ProgramaTransicao p) {
        return repo.findById(id).map(existing -> {
            existing.setNome(p.getNome());
            existing.setDescricao(p.getDescricao());
            existing.setSetorDestino(p.getSetorDestino());
            existing.setCargaHoraria(p.getCargaHoraria());
            existing.setNivel(p.getNivel());
            existing.setModalidade(p.getModalidade());
            existing.setSkills(p.getSkills());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Programa não encontrado: " + id));
    }
    public void delete(Long id) { repo.deleteById(id); }
}
