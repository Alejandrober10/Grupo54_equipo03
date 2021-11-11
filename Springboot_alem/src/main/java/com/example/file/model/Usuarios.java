package com.example.file.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
//@Table(name ="usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Long ed= (long) id;
	
	@Column
	private String cedula_usuario;
	@Column
	private String nombre_usuario; 
	@Column
	private String email_usuario;
	@Column
	private String username; //username
	@Column
	private String password; //password
	
	@Column
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="authorities_users",
	joinColumns=@JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="authority_id"))
	private Set<Authority> authority;

	
	
	public Usuarios() {
		super();
	}
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    Long ed = (long) id;
	    result = prime * result + ((ed == null) ? 0 :ed.hashCode());
	    return result;
	}
	
	//Setters and Getters

	public Usuarios(int id, String cedula_usuario, String nombre_usuario, String email_usuario, String username,
			String password) {
		super();
		this.id = id;
		this.cedula_usuario = cedula_usuario;
		this.nombre_usuario = nombre_usuario;
		this.email_usuario = email_usuario;
		this.username = username;
		this.password = password;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(String cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Usuarios other = (Usuarios) obj;
	    if (ed == null) {
	        if (other.ed != null)
	            return false;
	        } else if (!ed.equals(other.ed))
	            return false;
	        return true;
	}

	@Override
	public String toString() {
	    return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	}

