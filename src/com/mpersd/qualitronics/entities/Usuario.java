package com.mpersd.qualitronics.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int nId;

	private byte bActivo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaAlta;

	private int nEdad;

	private byte nTipo;

	private String sContraseña;

	private String sEmail;

	private String sMaterno;

	private String sNombre;

	private String sPaterno;

	//bi-directional many-to-one association to RolesUsuario
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<RolesUsuario> rolesUsuarios = new ArrayList<RolesUsuario>();

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Venta> ventas;

	public Usuario() {
	}

	public int getNId() {
		return this.nId;
	}

	public void setNId(int nId) {
		this.nId = nId;
	}

	public byte getBActivo() {
		return this.bActivo;
	}

	public void setBActivo(byte bActivo) {
		this.bActivo = bActivo;
	}

	public Date getDFechaAlta() {
		return this.dFechaAlta;
	}

	public void setDFechaAlta(Date dFechaAlta) {
		this.dFechaAlta = dFechaAlta;
	}

	public int getNEdad() {
		return this.nEdad;
	}

	public void setNEdad(int nEdad) {
		this.nEdad = nEdad;
	}

	public byte getNTipo() {
		return this.nTipo;
	}

	public void setNTipo(byte nTipo) {
		this.nTipo = nTipo;
	}

	public String getSContraseña() {
		return this.sContraseña;
	}

	public void setSContraseña(String sContraseña) {
		this.sContraseña = sContraseña;
	}

	public String getSEmail() {
		return this.sEmail;
	}

	public void setSEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getSMaterno() {
		return this.sMaterno;
	}

	public void setSMaterno(String sMaterno) {
		this.sMaterno = sMaterno;
	}

	public String getSNombre() {
		return this.sNombre;
	}

	public void setSNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getSPaterno() {
		return this.sPaterno;
	}

	public void setSPaterno(String sPaterno) {
		this.sPaterno = sPaterno;
	}

	public List<RolesUsuario> getRolesUsuarios() {
		return this.rolesUsuarios;
	}

	public void setRolesUsuarios(List<RolesUsuario> rolesUsuarios) {
		this.rolesUsuarios = rolesUsuarios;
	}

	public RolesUsuario addRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().add(rolesUsuario);
		rolesUsuario.setUsuario(this);

		return rolesUsuario;
	}

	public RolesUsuario removeRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().remove(rolesUsuario);
		rolesUsuario.setUsuario(null);

		return rolesUsuario;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setUsuario(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setUsuario(null);

		return venta;
	}

}