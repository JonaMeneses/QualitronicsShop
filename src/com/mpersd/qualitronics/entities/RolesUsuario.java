package com.mpersd.qualitronics.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roles_usuarios database table.
 * 
 */
@Entity
@Table(name="roles_usuarios")
@NamedQuery(name="RolesUsuario.findAll", query="SELECT r FROM RolesUsuario r")
public class RolesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int nId;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="nIdUsuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="nIdRol")
	private Role role;

	public RolesUsuario() {
	}

	public int getNId() {
		return this.nId;
	}

	public void setNId(int nId) {
		this.nId = nId;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}