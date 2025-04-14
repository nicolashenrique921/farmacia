package com.example.farmacia.service;

import com.example.farmacia.model.Farmaceutico;
import com.example.farmacia.repository.FarmaceuticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmaceuticoService {

    @Autowired
    private FarmaceuticoRepository repository;

    public Farmaceutico salvar(Farmaceutico farmaceutico) {
        if (repository.existsByCrf(farmaceutico.getCrf())) {
            throw new RuntimeException("Já existe um farmacêutico com este CRF.");
        }
        return repository.save(farmaceutico);
    }

    public List<Farmaceutico> listarTodos() {
        return repository.findAll();
    }

    public Optional<Farmaceutico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Farmaceutico atualizar(Long id, Farmaceutico atualizado) {
        Farmaceutico original = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmacêutico não encontrado"));

        original.setNome(atualizado.getNome());
        original.setCrf(atualizado.getCrf());

        return repository.save(original);
    }
}

