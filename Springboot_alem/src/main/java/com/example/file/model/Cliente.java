package com.example.file.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.cache.annotation.CacheEvict;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idcliente;
    public String cedula;
    public String nombre;
    public String direccion;
    public String email;
    public String telefono;
    
    @OneToMany(mappedBy="cliente",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
   
    private List<Factura>facturas;
    
    
    
	public Cliente() {
		facturas = new ArrayList<Factura>();
	}
	public long getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(long idcliente) {
		this.idcliente = idcliente;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	
	public void addFactura(Factura factura) {
		facturas.add(factura);
		
	}
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
    
}
