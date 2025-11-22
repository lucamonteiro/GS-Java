package br.edu.skillbridge.service;

import br.edu.skillbridge.model.Inscricao;
import br.edu.skillbridge.repository.InscricaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscricaoService {
    private final InscricaoRepository repo;

    public InscricaoService(InscricaoRepository repo) {
        this.repo = repo;
    }

    public Inscricao create(Inscricao i) {
        i.setDataInscricao(LocalDate.now());
        i.setStatus("INSCRITO");
        return repo.save(i);
    }

    public List<Inscricao> findByProfissional(Long profissionalId) {
        return repo.findByProfissionalId(profissionalId);
    }
}
