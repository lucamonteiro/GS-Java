package br.edu.skillbridge.repository;

import br.edu.skillbridge.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    Optional<Profissional> findByEmail(String email);
}
