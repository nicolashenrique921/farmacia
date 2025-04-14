package com.example.farmacia.service;

import com.example.farmacia.model.Atendimento;
import com.example.farmacia.model.Farmaceutico;
import com.example.farmacia.model.Paciente;
import com.example.farmacia.repository.AtendimentoRepository;
import com.example.farmacia.repository.FarmaceuticoRepository;
import com.example.farmacia.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;

    public Atendimento salvar(Atendimento atendimento) {
        // Regra de negócio: verificar se paciente e farmacêutico existem
        Paciente paciente = pacienteRepository.findById(atendimento.getPaciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Farmaceutico farmaceutico = farmaceuticoRepository.findById(atendimento.getFarmaceutico().getId())
                .orElseThrow(() -> new RuntimeException("Farmacêutico não encontrado"));

        atendimento.setPaciente(paciente);
        atendimento.setFarmaceutico(farmaceutico);
        atendimento.setDataAtendimento(LocalDateTime.now());

        return atendimentoRepository.save(atendimento);
    }

    public List<Atendimento> listarTodos() {
        return atendimentoRepository.findAll();
    }

    public Optional<Atendimento> buscarPorId(Long id) {
        return atendimentoRepository.findById(id);
    }

    public void deletar(Long id) {
        atendimentoRepository.deleteById(id);
    }
}

