package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;
import com.empresa.util.Constantes;

@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping
	public ResponseEntity<List<Medicamento>> listarMedicamento(){
		List<Medicamento> lista =service.listaMedicamento();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaMedicamento(@RequestBody Medicamento obj){
		System.out.println(obj.getNombre());
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Medicamento  objSalida = service.insertaActualizaMedicamento(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
			
		
		return ResponseEntity.ok(salida);
	}
	
 
	
	
	
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento> buscarPorId(@PathVariable("paramId") int idMedicamento){
		Optional<Medicamento> optMedicamento =service.buscaPorId(idMedicamento);
		
		if(optMedicamento.isPresent()) {
			return ResponseEntity.ok(optMedicamento.get());
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	@GetMapping("/nombre/{nombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscarPorNombre(@PathVariable("nombre") String nombre){
		List<Medicamento> lista =service.buscarPorNombre(nombre);
		
        if( CollectionUtils.isEmpty(lista)) {
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(lista);
        }
	}
	
	@GetMapping("/stock/{stock}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscarPorStock(@PathVariable("stock") int stock){
		List<Medicamento> lista =service.buscarPorStock(stock);
		
        if( CollectionUtils.isEmpty(lista)) {
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(lista);
        }
	}	
}
