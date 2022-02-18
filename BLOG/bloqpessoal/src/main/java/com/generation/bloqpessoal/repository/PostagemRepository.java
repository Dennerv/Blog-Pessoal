package com.generation.bloqpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.bloqpessoal.model.Postagem;

@Repository  // (<>) <-- aqui fica a classe e id dessa classe 
public interface PostagemRepository extends JpaRepository <Postagem, Long>{ 

	
	List <Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	
   //	no mySQL seria >>  from tb_postagens where titulo like %titulo%;
}
