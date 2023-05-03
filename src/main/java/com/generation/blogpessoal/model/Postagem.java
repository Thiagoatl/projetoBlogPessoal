package com.generation.blogpessoal.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens") /*CREATE TABLE tb_postagens*/
public class Postagem {

	@Id // O Atributo é a Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	private Long id;
	
	@NotBlank(message = "O Atributo título é Obrigatório!") // Exclusivo para String
	@Size(min = 5, max = 100, message = "O atributo título deve ter no minimo 05 e no máximo 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "O Atributo texto é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve ter no minimo 10 e no máximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;

	/* Relacionamento*/
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
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

	/* Criar os Métodos Get e Set do Objeto Tema*/
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
}