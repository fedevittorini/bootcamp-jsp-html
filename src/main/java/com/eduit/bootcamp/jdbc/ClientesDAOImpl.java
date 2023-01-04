package com.eduit.bootcamp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.eduit.bootcamp.jdbc.domain.Clientes;

public class ClientesDAOImpl implements DAO<Clientes, String> {

	private Properties propeties;
	
	public ClientesDAOImpl(final Properties prop) {
		this.propeties = prop;
	}

	@Override
	public Clientes getElementById(String theId) throws Exception {
		throw new RuntimeException("There is no ID on clientes, therefore getElementById shouldn't be called, "
				+ "use getElementByDNI instead");
	}
	
	public Clientes getElementByDNI(final String tipoDocumento, String documento) throws Exception  {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT * FROM clientes WHERE " + Clientes.T_DOCUMENTO_FIELD+"=" + tipoDocumento 
				+ " AND " + Clientes.DOCUMENTO_FIELD+"=" + documento;
		
		ResultSet rs = statement.executeQuery(sqlProd);
		if (rs.next()) {
			Clientes c = buildCliente(rs);
			return c;
		} else {
			return null;			
		}
			
	}

	public List<Clientes> getElementsByAttributes(Map<String, Object> theAttributes) throws Exception {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT * FROM clientes ";
		int i = 0;
		for (Map.Entry<String, Object> entry : theAttributes.entrySet()) {
			if (i == 0) {
				sqlProd = sqlProd + " WHERE ";
			} else {
				sqlProd = sqlProd + " AND ";
			}
			sqlProd = sqlProd + entry.getKey() + "='" + entry.getValue() + "'";
			i++;
		}
		ResultSet rs = statement.executeQuery(sqlProd);
		List<Clientes> output = new ArrayList<Clientes>();
		while (rs.next()) {
			Clientes c = buildCliente(rs);
			output.add(c);
		} 
		return output;
	}

	public boolean delete(Clientes theEntity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Clientes> getAll() throws Exception {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT TipoDocumento, Documento, RazonSocial, Correo, FechaNacimiento, Telefono FROM clientes";
		ResultSet rs = statement.executeQuery(sqlProd);
		List<Clientes> output = new ArrayList<Clientes>();
		while (rs.next()) {
			Clientes c = buildCliente(rs);
			output.add(c);
		} 
		return output;
	}
	
	@Override
	public Clientes save(Clientes theEntity) throws Exception {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "INSERT INTO clientes (TipoDocumento, Documento, RazonSocial, Correo, FechaNacimiento, Telefono)"
				+ " VALUES "
				+ "('"+theEntity.getTipoDocumento()+"',"
				+ "'"+theEntity.getDocumento()+"',"
				+ "'"+theEntity.getRazonSocial()+"',"
				+ "'"+theEntity.getCorreo()+"',"
				+ "'"+theEntity.getFechaNacimiento()+"',"
				+ "'"+theEntity.getTelefono()+"');"
				+ " ";
		if (statement.execute(sqlProd)) {
			return theEntity;
		} else {
			return null;
		}
	}

	private Clientes buildCliente(final ResultSet rs) throws Exception {
		return new Clientes(rs.getString(Clientes.T_DOCUMENTO_FIELD),
				rs.getString(Clientes.T_DOCUMENTO_FIELD),
				rs.getString(Clientes.RAZON_SOCIAL_FIELD),
				rs.getString(Clientes.CORREO_FIELD),
				rs.getDate(Clientes.FECHA_NAC_FIELD),
				rs.getString(Clientes.TELEFONO_FIELD));
	}
}
