package com.flores.ensayo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flores.ensayo.entity.Categoria;
import com.flores.ensayo.entity.Personal;
import com.flores.ensayo.service.CategoriaService;
import com.flores.ensayo.service.PersonalService;

@Controller
@RequestMapping("/personal")
public class PersonalController {
	@Autowired
	private PersonalService servicioPersonal;
	
	@Autowired
	private CategoriaService servicioCategoria;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("personal", servicioPersonal.listarTodos());
		model.addAttribute("categoria", servicioCategoria.listarCategoria());
		return "personal";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
						@RequestParam("nombre") String nom,
						@RequestParam("apellido") String ape,
						@RequestParam("edad") int edad,
						@RequestParam("direccion") String dir,
						@RequestParam("telefono") String tel,
						@RequestParam("correo") String cor,
						@RequestParam("categoria")int codCate,
						RedirectAttributes redirect) {
		try {
			Personal per = new Personal();
			
			per.setNombre(nom);
			per.setApellido(ape);
			per.setEdad(edad);
			per.setDireccion(dir);
			per.setTelefono(tel);
			per.setCorreo(cor);
			
			Categoria cat = new Categoria();
			
			cat.setCodigo(codCate);
			
			per.setCategoria(cat);
			
			if(cod==0) {
				servicioPersonal.registrar(per);
				redirect.addFlashAttribute("mensaje", "Personal Registrado");
			}
			else {
				per.setCodigo(cod);
				servicioPersonal.actualizar(per);
				redirect.addFlashAttribute("mensaje", "Personal Actualizar");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/personal/lista";
	}
}
