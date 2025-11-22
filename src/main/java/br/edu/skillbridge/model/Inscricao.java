package br.edu.skillbridge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscricoes")
public class Inscricao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @ManyToOne @JoinColumn(name = "programa_id")
    private ProgramaTransicao programa;

    private LocalDate dataInscricao;

    private String status;

    public Inscricao() {}

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }
    public ProgramaTransicao getPrograma() { return programa; }
    public void setPrograma(ProgramaTransicao programa) { this.programa = programa; }
    public LocalDate getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(LocalDate dataInscricao) { this.dataInscricao = dataInscricao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
