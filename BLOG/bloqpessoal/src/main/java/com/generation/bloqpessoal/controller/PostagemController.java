package com.generation.bloqpessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.generation.bloqpessoal.model.Postagem;
import com.generation.bloqpessoal.repository.PostagemRepository;
import com.generation.bloqpessoal.repository.TemaRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	
	@Autowired    // criar e instanciar objetos 
	private PostagemRepository postagemRepository; //injecao de dependencia 
	
	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(postagemRepository.findAll());   // resposta http
		// select * from tb_postagem (seria feito dessa forma no mySQL)
	}
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable Long id){
		return postagemRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
		
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));   // resposta http
	}
	
	@PostMapping       
	public ResponseEntity<Postagem> postPostagem (@Valid @RequestBody Postagem postagem){  
		if (temaRepository.existsById(postagem.getTema().getId()))
		{
		return ResponseEntity.status(HttpStatus.CREATED).
				body(postagemRepository.save(postagem));
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PutMapping
	public ResponseEntity<Postagem> putPostagem (@Valid @RequestBody Postagem postagem)
	{
		
		if (temaRepository.existsById(postagem.getTema().getId()))
				{
					 return postagemRepository.findById(postagem.getId())
					.map(resposta -> ResponseEntity.status(HttpStatus.OK)
					.body(postagemRepository.save(postagem)))
					.orElse(ResponseEntity.notFound().build());
				}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
				 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable Long id)
	{
		return postagemRepository.findById(id).map(resposta -> 
		{
				postagemRepository.deleteById(id);
				return ResponseEntity.noContent().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
}
