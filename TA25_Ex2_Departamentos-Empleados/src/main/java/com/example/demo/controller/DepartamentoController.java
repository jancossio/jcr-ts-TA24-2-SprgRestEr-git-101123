package com.example.demo.controller;

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

import com.example.demo.dto.Departamento;
import com.example.demo.service.DepartamentoServiceImpl;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	DepartamentoServiceImpl departamentoServiceImpl;
	
	@GetMapping("/all")
	public List<Departamento> listarDepartamento(){
		return departamentoServiceImpl.listarDepartamentos();
	}
	
	@PostMapping("/add")
	public Departamento salvarDepartamento(@RequestBody Departamento departamento) {
		
		return departamentoServiceImpl.guardarDepartamento(departamento);
	}
	
	@GetMapping("/{id}")
	public Departamento departamentoXID(@PathVariable(name="id") Integer id) {
		
		Departamento departamento_xid= new Departamento();
		
		departamento_xid=departamentoServiceImpl.departamentoXID(id);
		
		//System.out.println("articulo XID: "+departamento_xid);
		
		return departamento_xid;
	}
	
	@PutMapping("/{id}")
	public Departamento actualizarDepartamento(@PathVariable(name="id")Integer id,@RequestBody Departamento departamento) {
		
		Departamento departamento_seleccionado= new Departamento();
		Departamento departamento_actualizado= new Departamento();
		
		departamento_seleccionado= departamentoServiceImpl.departamentoXID(id);
		
		departamento_seleccionado.setNombre(departamento.getNombre());
		departamento_seleccionado.setPresupuesto(departamento.getPresupuesto());
		
		departamento_actualizado = departamentoServiceImpl.actualizarDepartamento(departamento_seleccionado);
		
		//System.out.println("El video actualizado es: "+ departamento_actualizado);
		
		return departamento_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarDepartamento(@PathVariable(name="id")Integer id) {
		departamentoServiceImpl.eliminarDepartamento(id);
	}
}
