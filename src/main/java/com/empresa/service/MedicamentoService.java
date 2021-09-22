package com.empresa.service;

import java.util.List;
import java.util.Optional; 
import com.empresa.entity.Medicamento;

public interface MedicamentoService {
	/*TAREA 1 INSERTAR ACTUALIZAR MEDICAMENTO*/
	public Medicamento insertaActualizaMedicamento(Medicamento obj);
	
	/*TAREA 1 LISTAR MEDICAMENTO*/
	public List<Medicamento> listaMedicamento();
	
	
	/*TAREA 2 LISTAR POR ID*/
	public abstract Optional<Medicamento> buscaPorId(int idMedicamento);
	
	/*TAREA 2 LISTAR POR NOMBRE LIKE*/
	public abstract List<Medicamento> buscarPorNombre(String nombre);
	
	/*TAREA 2 LISTAR POR STOCK MAYOR / MENOR*/
	public abstract List<Medicamento> buscarPorStock(int stock);
}
