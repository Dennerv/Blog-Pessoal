package com.generation.bloqpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tb_postagens")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//gera e cuida da chave primaria

	private Long id;
	
	@NotBlank(message = "A atributo título é obrigatório")
	@Size(min = 5, max = 100, message = " O atributo deve conter no mínimo 5 e no máximo 100 caracter")
	private String titulo;
	
	@NotBlank(message = "A atributo título é obrigatório")
	@Size(min = 5, max =1000, message = " O atributo deve conter no mínimo 5 e no máximo 1000 caracter")

	private String texto;
	
	@UpdateTimestamp
	private  LocalDateTime data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
	
}
