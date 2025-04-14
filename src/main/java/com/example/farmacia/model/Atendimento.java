package com.example.farmacia.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "farmaceutico_id", nullable = false)
    private Farmaceutico farmaceutico;

    @Column(nullable = false)
    private LocalDateTime dataAtendimento;

    @Column
    private String observacoes;

    public Atendimento() {
    }

    public Atendimento(Paciente paciente, Farmaceutico farmaceutico, LocalDateTime dataAtendimento,
            String observacoes) {
        this.paciente = paciente;
        this.farmaceutico = farmaceutico;
        this.dataAtendimento = dataAtendimento;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Farmaceutico getFarmaceutico() {
        return farmaceutico;
    }

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setFarmaceutico(Farmaceutico farmaceutico) {
        this.farmaceutico = farmaceutico;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
