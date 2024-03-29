package com.generation.bloqpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.bloqpessoal.model.Postagem;


import java.util.List;

import com.generation.bloqpessoal.model.Postagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

   
	public List <Postagem> findAllByTituloContainingIgnoreCase(String titulo);

}