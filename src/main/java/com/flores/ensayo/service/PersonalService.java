package com.flores.ensayo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flores.ensayo.entity.Personal;
import com.flores.ensayo.repository.PersonalRepository;

@Service
public class PersonalService {
	@Autowired
	private PersonalRepository repo;
	
	public void registrar(Personal per) {
		repo.save(per);
	}
	public void actualizar(Personal per) {
		repo.save(per);
	}
	public List<Personal> listarTodos(){
		return repo.findAll();
	}
}
