package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pet;
import com.example.demo.repositories.PetRepository;
@Service
public class PetService {

private final PetRepository petRepository;
	
	@Autowired
	public PetService (PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	public Pet salvarPet (Pet pet) {
		return petRepository.save(pet);
	}
	
	public Pet buscarPorId (Long id) {
		return petRepository.findById(id).orElse(null);
	}

	public List<Pet> listarPet() {
		return petRepository.findAll();
	}
	
	public void deletarCadPet(Long id) {
		petRepository.deleteById(id);
	}
	
	public Pet atualizarCadPet(Long id, Pet petAtualizado) {
		Optional<Pet> petExistente= petRepository.findById(id);
		if(petExistente.isPresent()) {
			Pet pet = petExistente.get();
			pet.setNome(petAtualizado.getNome());
			pet.setTipo(petAtualizado.getTipo());
			pet.setRaca(petAtualizado.getRaca());
			pet.setIdade(petAtualizado.getIdade());
			
			return petRepository.save(pet);
		
		} else {
			return null;
	
		}
	}	
	
}
