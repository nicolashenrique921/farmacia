package com.example.farmacia.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private boolean controlado;
    @Column(nullable = true)
    private LocalDate validade;

    public Medicamento() {}

    public Medicamento(String nome, String descricao, boolean controlado, Integer validade) {
        this.nome = nome;
        this.descricao = descricao;
        this.controlado = controlado;
        this.validade = LocalDate.of(validade, 1, 1);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean isControlado() { return controlado; }
    public void setControlado(boolean controlado) { this.controlado = controlado; }

    public LocalDate getValidade() { return validade; }
    public void setValidade(LocalDate validade) { this.validade = validade; }
}
