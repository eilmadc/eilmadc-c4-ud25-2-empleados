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
	
	@GetMapping("/departamentos/{id}")
	public Departamento departamentoXID(@PathVariable(name="id") Long id) {
		
		Departamento departamento_xid= new Departamento();
		
		departamento_xid=departamentoServiceImpl.departamentoXID(id);
		
		System.out.println("Departamento XID: "+departamento_xid);
		
		return departamento_xid;
	}
	
	@PutMapping("/departamentos/{id}")
	public Departamento updateDepartamento(@PathVariable(name="id")Long id,@RequestBody Departamento departamento) {
		
		Departamento departamento_seleccionado= new Departamento();
		Departamento departamento_actualizado= new Departamento();
		
		departamento_seleccionado= departamentoServiceImpl.departamentoXID(id);
		
		departamento_seleccionado.setNombre(departamento.getNombre());
		departamento_seleccionado.setPresupuesto(departamento.getPresupuesto());
		
		departamento_actualizado = departamentoServiceImpl.updateDepartamento(departamento_seleccionado);
		
		
		return departamento_actualizado;
	}
	
	@DeleteMapping("/departamentos/{id}")
	public void eleiminarDepartamento(@PathVariable(name="id")Long id) {
		departamentoServiceImpl.deleteDepartamento(id);
	}
	
	
	
}
