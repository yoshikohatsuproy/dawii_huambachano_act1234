package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{
	public abstract List<Medicamento> findBynombreContaining(String nombre);
	public abstract List<Medicamento> findBystockGreaterThan(int stock);
}
