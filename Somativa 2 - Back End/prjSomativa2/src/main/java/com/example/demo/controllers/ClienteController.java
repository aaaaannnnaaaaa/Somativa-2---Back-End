package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Cliente;
import com.example.demo.services.ClienteService;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

	private ClienteService clienteService;
	
	@Autowired
	public ClienteController (ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping("/criar")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}
	
	@GetMapping
	public List<Cliente> buscarTodos(){
		return clienteService.listarCliente();
	}
	
	@GetMapping ("/{id}")
	public Cliente buscarPorId(@PathVariable Long id) {
		return clienteService.buscarPorId(id);
	}
	
	@DeleteMapping ("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
		Cliente ClienteAtualizado = clienteService.atualizarCadCliente(id, cliente);
		if(ClienteAtualizado != null) {
			return ResponseEntity.ok(ClienteAtualizado);
		} else {
		
		return null;
	}
	}
}
