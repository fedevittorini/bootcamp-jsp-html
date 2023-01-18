package com.eduit.bootcamp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.eduit.bootcamp.jdbc.entity.Clientes;
import com.eduit.bootcamp.jdbc.entity.Usuarios;

public class UsuariosDAOImpl implements DAO<Usuarios, Long> {
	
	public static final String CTX_NAME = "usuariosDAOImpl";
	private SimpleDateFormat formater = new SimpleDateFormat("YYYY-mm-dd");
	private Properties propeties;
	
	public UsuariosDAOImpl(final Properties prop) {
		this.propeties = prop;
	}

	@Override
	public Usuarios getElementById(Long theId) throws Exception {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT " + Usuarios.ID_FIELD + ", " 
				+ Usuarios.USERNAME_FIELD + ", "
				+ Usuarios.FIRST_NAME_FIELD + ", "
				+ Usuarios.LAST_NAME_FIELD + ", "
				+ Usuarios.PASSWORD_FIELD + ", "
				+ Usuarios.DATE_CREATED_FIELD + ", "
				+ Usuarios.DATE_DELETED_FIELD
				+ " FROM " + Usuarios.TABLE_NAME 
				+ " WHERE " + Usuarios.ID_FIELD + "=" + theId;
		
		ResultSet rs = statement.executeQuery(sqlProd);
		if (rs.next()) {
			Usuarios c = buildUsuarios(rs);
			return c;
		} else {
			return null;			
		}
	}
	
	public List<Usuarios> getElementsByAttributes(Map<String, Object> theAttributes) throws Exception {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT " + Usuarios.ID_FIELD + ", " 
				+ Usuarios.USERNAME_FIELD + ", "
				+ Usuarios.FIRST_NAME_FIELD + ", "
				+ Usuarios.LAST_NAME_FIELD + ", "
				+ Usuarios.PASSWORD_FIELD + ", "
				+ Usuarios.DATE_CREATED_FIELD + ", "
				+ Usuarios.DATE_DELETED_FIELD
				+ " FROM " + Usuarios.TABLE_NAME;
		
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
		List<Usuarios> output = new ArrayList<Usuarios>();
		while (rs.next()) {
			Usuarios c = buildUsuarios(rs);
			output.add(c);
		} 
		return output;
	}

	public boolean delete(Usuarios theEntity) throws Exception {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "DELETE FROM " + Usuarios.TABLE_NAME 
				+ " WHERE " + Usuarios.ID_FIELD + "=" + theEntity.getId();
		
		return statement.execute(sqlProd);
	}
	
	public List<Usuarios> getAll() throws Exception {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT " + Usuarios.ID_FIELD + ", " 
				+ Usuarios.USERNAME_FIELD + ", "
				+ Usuarios.FIRST_NAME_FIELD + ", "
				+ Usuarios.LAST_NAME_FIELD + ", "
				+ Usuarios.PASSWORD_FIELD + ", "
				+ Usuarios.DATE_CREATED_FIELD + ", "
				+ Usuarios.DATE_DELETED_FIELD
				+ " FROM " + Usuarios.TABLE_NAME;
		ResultSet rs = statement.executeQuery(sqlProd);
		List<Usuarios> output = new ArrayList<Usuarios>();
		while (rs.next()) {
			Usuarios c = buildUsuarios(rs);
			output.add(c);
		} 
		return output;
	}
	
	@Override
	public Usuarios save(Usuarios theEntity) throws Exception {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "INSERT INTO " + Usuarios.TABLE_NAME + " ("
				+ Usuarios.USERNAME_FIELD + ", "
				+ Usuarios.FIRST_NAME_FIELD + ", "
				+ Usuarios.LAST_NAME_FIELD + ", "
				+ Usuarios.PASSWORD_FIELD + ", "
				+ Usuarios.DATE_CREATED_FIELD + ", "
				+ Usuarios.DATE_DELETED_FIELD
				+ ")"
				+ " VALUES "
				+ "('"+theEntity.getUsername()+"', "
				+ "'"+theEntity.getFirstName()+"', "
				+ "'"+theEntity.getLastName()+"', "
				+ "PASSWORD("+theEntity.getPassword()+"), "
				+ "'"+formater.format(theEntity.getDateCreated())+"', "
				+ "'"+formater.format(theEntity.getDateDeleted())+"');"
				+ " ";
		if (statement.execute(sqlProd)) {
			return theEntity;
		} else {
			return null;
		}
	}

	private Usuarios buildUsuarios(final ResultSet rs) throws Exception {
		return new Usuarios(rs.getLong(Usuarios.ID_FIELD),
				rs.getString(Usuarios.USERNAME_FIELD),
				rs.getString(Usuarios.FIRST_NAME_FIELD),
				rs.getString(Usuarios.LAST_NAME_FIELD),
				rs.getString(Usuarios.PASSWORD_FIELD),
				rs.getDate(Usuarios.DATE_CREATED_FIELD),
				rs.getDate(Usuarios.DATE_DELETED_FIELD));
	}
}
