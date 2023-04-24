/**
 * 
 */
package com.ex02.c4.service;

import java.util.List;

import com.ex02.c4.dto.Empleado;

/**
 * @author elena-01
 *
 */
public interface EmpleadoService {

	public List<Empleado> listEmpleados();

	public Empleado saveEmpleado(Empleado empleado);

	/* public Empleado empleadoXID(Long id); */

	public Empleado updateEmpleado(Empleado empleado);

	public void deleteEmpleadoByDni(String dni);

	public Empleado empleadoByDni(String dni);
}
