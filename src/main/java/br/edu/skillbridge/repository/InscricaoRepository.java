package br.edu.skillbridge.repository;

import br.edu.skillbridge.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    List<Inscricao> findByProfissionalId(Long profissionalId);
}
