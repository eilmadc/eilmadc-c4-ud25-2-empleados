/**
 * 
 */
package com.ex02.c4.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex02.c4.dto.Empleado;

/**
 * @author elena-01
 *
 */
public interface IEmpleadoDAO extends JpaRepository<Empleado, Long>{

	Optional<Empleado> findByDni(String dni);

	void deleteByDni(String dni);

}
