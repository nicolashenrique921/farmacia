package com.example.farmacia.repository;

import com.example.farmacia.model.Farmaceutico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaceuticoRepository extends JpaRepository<Farmaceutico, Long> {
    boolean existsByCrf(String crf);
}
