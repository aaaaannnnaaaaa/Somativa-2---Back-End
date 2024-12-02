package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService (ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente salvarCliente (Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente buscarPorId (Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}
	
	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Cliente atualizarCadCliente(Long id, Cliente clienteAtualizado) {
		Optional<Cliente> clienteExistente= clienteRepository.findById(id);
		if(clienteExistente.isPresent()) {
			Cliente cliente = clienteExistente.get();
			cliente.setNome(clienteAtualizado.getNome());
			cliente.setTelefone(clienteAtualizado.getTelefone());
			cliente.setEmail(clienteAtualizado.getEmail());
			
			return clienteRepository.save(cliente);
		
		} else {
			return null;
	
		}
	}	
}