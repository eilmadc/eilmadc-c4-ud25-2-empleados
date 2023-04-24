/**
 * 
 */
package com.ex02.c4.service;

import java.util.List;

import com.ex02.c4.dto.Departamento;


/**
 * @author elena-01
 *
 */
public interface DepartamentoService {
	public List<Departamento> listDepartamentos(); 
	
	public Departamento saveDepartamento(Departamento departamento);
	
	public Departamento departamentoXID(int id);
	
	public Departamento updateDepartamento(Departamento departamento); 
	
	public void deleteDepartamento(int id);
}
