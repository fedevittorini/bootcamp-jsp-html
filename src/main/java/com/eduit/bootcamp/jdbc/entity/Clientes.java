package com.eduit.bootcamp.jdbc.entity;

import java.io.Serializable;
import java.util.Date;

public class Clientes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String T_DOCUMENTO_FIELD = "TipoDocumento";
	public static String DOCUMENTO_FIELD = "Documento";
	public static String RAZON_SOCIAL_FIELD = "RazonSocial";
	public static String CORREO_FIELD = "Correo";
	public static String FECHA_NAC_FIELD = "FechaNacimiento";
	public static String TELEFONO_FIELD = "Telefono";
	
	private String tipoDocumento;
    private String documento;
    private String razonSocial;
    private String correo;
    private Date fechaNacimiento;
    private String telefono;
    
    public Clientes() {
    	
    }
    
	public Clientes(String tipoDocumento, String documento, String razonSocial, String correo, Date fechaNacimiento,
			String telefono) {
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.razonSocial = razonSocial;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String toString() {
		return "{TipoDocumento: [" + this.tipoDocumento + "] Documento: [" + this.documento + "] Correo: [" + this.correo + "]}";
	}
}
