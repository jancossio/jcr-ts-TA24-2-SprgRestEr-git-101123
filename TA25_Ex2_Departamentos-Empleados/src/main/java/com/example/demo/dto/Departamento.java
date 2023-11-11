package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {

	@Id
	@Column(name = "codigo")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "presupuesto")
	private Integer presupuesto;
	
	@OneToMany
    @JoinColumn(name="departamento")
    private List<Empleado> empleado;
	
	public Departamento(){
		
	}
	
	public Departamento(Integer id, String nombre, Integer presupuesto){
		super();
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Integer presupuesto) {
		this.presupuesto = presupuesto;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Empleado")
	public List<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", nombre=" + nombre + "]";
	}
}
