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

import com.example.demo.dto.Empleado;
import com.example.demo.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	@GetMapping("/all")
	public List<Empleado> listarEmpleado(){
		return empleadoServiceImpl.listarEmpleados();
	}
	
	@PostMapping("/add")
	public Empleado salvarEmpleado(@RequestBody Empleado empleado) {
		
		return empleadoServiceImpl.guardarEmpleado(empleado);
	}
	
	@GetMapping("/{id}")
	public Empleado empleadoXID(@PathVariable(name="id") String id) {
		
		Empleado empleado_xid= new Empleado();
		
		empleado_xid=empleadoServiceImpl.empleadoXID(id);
		
		//System.out.println("articulo XID: "+empleado_xid);
		
		return empleado_xid;
	}
	
	@PutMapping("/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")String id,@RequestBody Empleado empleado) {
		
		Empleado empleado_seleccionado= new Empleado();
		Empleado empleado_actualizado= new Empleado();
		
		empleado_seleccionado= empleadoServiceImpl.empleadoXID(id);
		
		empleado_seleccionado.setId(empleado.getId());
		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setApellido(empleado.getApellido());
		empleado_seleccionado.setDepartamento(empleado.getDepartamento());

		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		//System.out.println("El video actualizado es: "+ empleado_actualizado);
		
		return empleado_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarEmpleado(@PathVariable(name="id")String id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}
}
