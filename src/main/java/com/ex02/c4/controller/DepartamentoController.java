/**
 * 
 */
package com.ex02.c4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex02.c4.dto.Departamento;
import com.ex02.c4.service.DepartamentoServiceImpl;

/**
 * @author elena-01
 *
 */

@RestController
@RequestMapping("/api")
public class DepartamentoController {

	@Autowired
	DepartamentoServiceImpl departamentoServiceImpl;
	
	@GetMapping("/departamentos")
	public List<Departamento> listDepartmentos(){
		return departamentoServiceImpl.listDepartamentos();
	}
	
	@PostMapping("/departamentos")
	public Departamento saveDepartamento(@RequestBody Departamento departamento) {
		
		return departamentoServiceImpl.saveDepartamento(departamento);
	}
	
	@GetMapping("/departamentos/{codigo}")
	public Departamento departamentoXID(@PathVariable(name="codigo") int codigo) {
		
		return departamentoServiceImpl.departamentoXID(codigo);
	}
	
	@PutMapping("/departamentos/{codigo}")
	public Departamento updateDepartamento(@PathVariable(name="codigo")int codigo,@RequestBody Departamento departamento) {
		
		Departamento departamento_seleccionado= new Departamento();
		Departamento departamento_actualizado= new Departamento();
		
		departamento_seleccionado= departamentoServiceImpl.departamentoXID(codigo);
		
		departamento_seleccionado.setNombre(departamento.getNombre());
		departamento_seleccionado.setPresupuesto(departamento.getPresupuesto());
		
		departamento_actualizado = departamentoServiceImpl.updateDepartamento(departamento_seleccionado);
		
		
		return departamento_actualizado;
	}
	
	@DeleteMapping("/departamentos/{codigo}")
	public void eleiminarDepartamento(@PathVariable(name="codigo")int codigo) {
		departamentoServiceImpl.deleteDepartamento(codigo);
	}
	
	
	
}
