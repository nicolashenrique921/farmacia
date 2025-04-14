package com.example.farmacia.controller;

import com.example.farmacia.model.Farmaceutico;
import com.example.farmacia.service.FarmaceuticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmaceuticos")
public class FarmaceuticoController {

    @Autowired
    private FarmaceuticoService service;

    @PostMapping
    public ResponseEntity<Farmaceutico> cadastrar(@RequestBody Farmaceutico f) {
        return ResponseEntity.ok(service.salvar(f));
    }

    @GetMapping
    public ResponseEntity<List<Farmaceutico>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmaceutico> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
