package br.edu.skillbridge.service;

import br.edu.skillbridge.model.Profissional;
import br.edu.skillbridge.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {
    private final ProfissionalRepository repo;

    public ProfissionalService(ProfissionalRepository repo) {
        this.repo = repo;
    }

    public List<Profissional> findAll() { return repo.findAll(); }
    public Optional<Profissional> findById(Long id) { return repo.findById(id); }
    public Profissional create(Profissional p) {
        p.setDataRegistro(LocalDate.now());
        return repo.save(p);
    }
    public Profissional update(Long id, Profissional p) {
        return repo.findById(id).map(existing -> {
            existing.setNome(p.getNome());
            existing.setEmail(p.getEmail());
            existing.setCarreiraAtual(p.getCarreiraAtual());
            existing.setCarreiraDesejada(p.getCarreiraDesejada());
            existing.setExperiencia(p.getExperiencia());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Profissional não encontrado: " + id));
    }
    public void delete(Long id) { repo.deleteById(id); }
}
