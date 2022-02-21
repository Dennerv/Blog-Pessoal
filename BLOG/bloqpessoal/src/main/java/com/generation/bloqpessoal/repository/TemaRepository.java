package com.generation.bloqpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.bloqpessoal.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
public List <Tema> findALLByDescricaoContainingIgnoreCase(String descricao);
}
