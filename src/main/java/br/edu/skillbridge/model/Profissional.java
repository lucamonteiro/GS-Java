package br.edu.skillbridge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "profissionais")
public class Profissional {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank @Email
    @Column(unique = true)
    private String email;

    private String carreiraAtual;
    private String carreiraDesejada;

    @Min(0)
    private Integer experiencia; // anos

    private LocalDate dataRegistro;

    public Profissional() {}

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCarreiraAtual() { return carreiraAtual; }
    public void setCarreiraAtual(String carreiraAtual) { this.carreiraAtual = carreiraAtual; }
    public String getCarreiraDesejada() { return carreiraDesejada; }
    public void setCarreiraDesejada(String carreiraDesejada) { this.carreiraDesejada = carreiraDesejada; }
    public Integer getExperiencia() { return experiencia; }
    public void setExperiencia(Integer experiencia) { this.experiencia = experiencia; }
    public LocalDate getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }
}
