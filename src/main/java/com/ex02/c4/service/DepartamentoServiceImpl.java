/**
 * 
 */
package com.ex02.c4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex02.c4.dao.IDepartamentoDAO;
import com.ex02.c4.dto.Departamento;

/**
 * @author elena-01
 *
 */

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	IDepartamentoDAO iDepartamentoDAO;

	@Override
	public List<Departamento> listDepartamentos() {

		return iDepartamentoDAO.findAll();
	}

	@Override
	public Departamento saveDepartamento(Departamento departamento) {

		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public Departamento departamentoXID(int codigo) {

		return iDepartamentoDAO.findById(codigo).get();
	}

	@Override
	public Departamento updateDepartamento(Departamento departamento) {

		return iDepartamentoDAO.save(departamento);
	}


	@Override
	public void deleteDepartamento(int id) {
		// TODO Auto-generated method stub
		
	}

}
