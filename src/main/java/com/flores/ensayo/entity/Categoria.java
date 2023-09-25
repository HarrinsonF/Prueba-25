package com.flores.ensayo.entity;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_categoria")
public class Categoria {
	@Id
	@Column(name="idCategoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "categoria")
	List<Personal> listaCategoria;

	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Personal> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Personal> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
	
	
	
}
