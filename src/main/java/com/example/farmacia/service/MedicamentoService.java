package com.example.farmacia.service;

import com.example.farmacia.model.Medicamento;
import com.example.farmacia.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository repository;

    public Medicamento salvar(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    public List<Medicamento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Medicamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Medicamento atualizar(Long id, Medicamento atualizado) {
        Medicamento original = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento não encontrado"));

        original.setNome(atualizado.getNome());
        original.setDescricao(atualizado.getDescricao());
        original.setValidade(atualizado.getValidade());

        return repository.save(original);
    }
}
