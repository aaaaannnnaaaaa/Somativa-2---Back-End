package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String tipo;
	private String raca;
	private String idade;
	
	@ManyToOne
	@JoinColumn (name = "id_cliente")
	private Cliente cliente;

	//Id
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	//nomE
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	//tipO
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	//racA
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public String getRaca() {
		return raca;
	}
	
	//idadE
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public String getIdade() {
		return idade;
	}
	
	//Client
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
}
