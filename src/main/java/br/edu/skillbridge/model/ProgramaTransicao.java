package br.edu.skillbridge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "programas_transicao")
public class ProgramaTransicao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private String descricao;
    private String setorDestino;

    @Min(1)
    private Integer cargaHoraria;

    @NotBlank
    private String nivel;

    private String modalidade;

    @ManyToMany
    @JoinTable(name = "programa_skill",
        joinColumns = @JoinColumn(name = "programa_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<SkillFutura> skills;

    public ProgramaTransicao() {}

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getSetorDestino() { return setorDestino; }
    public void setSetorDestino(String setorDestino) { this.setorDestino = setorDestino; }
    public Integer getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(Integer cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getModalidade() { return modalidade; }
    public void setModalidade(String modalidade) { this.modalidade = modalidade; }
    public Set<SkillFutura> getSkills() { return skills; }
    public void setSkills(Set<SkillFutura> skills) { this.skills = skills; }
}
