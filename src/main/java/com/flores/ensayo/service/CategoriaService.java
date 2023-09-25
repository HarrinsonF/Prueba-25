package com.flores.ensayo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flores.ensayo.entity.Categoria;
import com.flores.ensayo.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> listarCategoria(){
		return repo.findAll();
	}
}
