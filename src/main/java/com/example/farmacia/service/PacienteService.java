package com.example.farmacia.service;

import com.example.farmacia.model.Paciente;
import com.example.farmacia.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente salvar(Paciente paciente) {
        if (pacienteRepository.existsByCpf(paciente.getCpf())) {
            throw new RuntimeException("Já existe um paciente com este CPF.");
        }
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente atualizar(Long id, Paciente pacienteAtualizado) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        paciente.setNome(pacienteAtualizado.getNome());
        paciente.setCpf(pacienteAtualizado.getCpf());
        paciente.setDataNascimento(pacienteAtualizado.getDataNascimento());

        return pacienteRepository.save(paciente);
    }
}

