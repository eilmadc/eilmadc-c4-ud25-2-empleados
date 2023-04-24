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

import com.ex02.c4.dto.Empleado;
import com.ex02.c4.service.EmpleadoServiceImpl;

import jakarta.transaction.Transactional;



/**
 * @author elena-01
 *
 */

@RestController
@RequestMapping("/api")
public class EmpleadoController{

		@Autowired
		EmpleadoServiceImpl empleadoServiceImpl;
		
		@GetMapping("/empleados")
		public List<Empleado> listEmpleados(){
			return empleadoServiceImpl.listEmpleados();
		}
		
		
		@PostMapping("/empleados")
		public Empleado saveEmpleado(@RequestBody Empleado empleado) {
			System.out.println("****** Este empleado :"+empleado);
			return empleadoServiceImpl.saveEmpleado(empleado);
		}
		
		@GetMapping("/empleados/{dni}")
		public Empleado empleadoByDni(@PathVariable(name="dni") String dni) {

			return empleadoServiceImpl.empleadoByDni(dni);
		}
		
		@PutMapping("/empleados/{dni}")
		public Empleado updateEmpleado(@PathVariable(name="dni")String dni,@RequestBody Empleado empleado) {
			
			Empleado empleado_seleccionado= new Empleado();
			Empleado empleado_actualizado= new Empleado();
			
			empleado_seleccionado= empleadoServiceImpl.empleadoByDni(dni);
			
			empleado_seleccionado.setNombre(empleado.getNombre());
			empleado_seleccionado.setApellidos(empleado.getApellidos());
			empleado_seleccionado.setDepartamento(empleado.getDepartamento());
			
			empleado_actualizado = empleadoServiceImpl.updateEmpleado(empleado_seleccionado);
			
			System.out.println("El empleado actualizado es: "+ empleado_actualizado);
			
			return empleado_actualizado;
		}
		
		@Transactional
		@DeleteMapping("/empleados/{dni}")
		public void deleteEmpleadoByDni(@PathVariable(name="dni")String dni) {
			empleadoServiceImpl.deleteEmpleadoByDni(dni);
		}
		
}
