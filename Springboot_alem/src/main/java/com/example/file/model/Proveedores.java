package com.example.file.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "proveedores")
public class Proveedores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproveedor;
	private String nit;
	private String nombre_proveedor;
	private String direccion;
	private String telefono;
	private String ciudad;
	
	
	public Proveedores() {
		super();
	}


	public Proveedores(int id, String nit, String nombre_proveedor, String direccion, String telefono, String ciudad) {
		super();
		this.idproveedor = id;
		this.nit = nit;
		this.nombre_proveedor = nombre_proveedor;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}
	

	public int getIdproveedor() {
		return idproveedor;
	}


	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}


	public String getNit() {
		return nit;
	}


	public void setNit(String nit) {
		this.nit = nit;
	}


	public String getNombre_proveedor() {
		return nombre_proveedor;
	}


	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
		

}
