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
		// TODO Auto-generated method stub
		return iEmpleadoDAO.findAll();
	}

	@Override
	public Empleado saveEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public Empleado empleadoXID(String dni) {
		// TODO Auto-generated method stub
		return iEmpleadoDAO.findByDni(dni).get();
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public void deleteEmpleadoByDni(String dni) {
		// TODO Auto-generated method stub
		iEmpleadoDAO.deleteByDni(dni);
	}

}
