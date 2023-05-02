package com.crud.springboot.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "usuarios" /*, uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }), }*/)

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String clave;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	

	//@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@JoinTable(name = "usuarios_tipos", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "id_tipo_Usuario", referencedColumnName = "idTipoUsuario"))
	//private Set<TipoUsuario> TipoUsuario = new HashSet<>();

	

}