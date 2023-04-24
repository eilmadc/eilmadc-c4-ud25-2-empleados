/**
 * 
 */
package com.ex02.c4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex02.c4.dao.IEmpleadoDAO;
import com.ex02.c4.dto.Empleado;

/**
 * @author elena-01
 *
 */

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	IEmpleadoDAO iEmpleadoDAO;

	@Override
	public List<Empleado> listEmpleados() {
		
		return iEmpleadoDAO.findAll();
	}

	@Override
	public Empleado saveEmpleado(Empleado empleado) {
		System.out.println("***** Este empleado : "+empleado);
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public Empleado empleadoByDni(String dni) {
		
		return iEmpleadoDAO.findByDni(dni).get();
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado) {
		
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public void deleteEmpleadoByDni(String dni) {
		
		iEmpleadoDAO.deleteByDni(dni);
	}

}
