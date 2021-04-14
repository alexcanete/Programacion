package Controllers;

import java.util.*;
import Models.*;
import java.sql.*;

public class UsuarioController{
    private List<Usuario> lUsuarios;

	public UsuarioController() {
		lUsuarios = new ArrayList<Usuario>();
	}

	public List<Usuario> getLista() {
		return lUsuarios;
	}

	public void setLista(List<Usuario> lUsuarios) {
		this.lUsuarios = lUsuarios;
	}

	/*
	 * ######## # CRUD # ########
	 */
	public boolean add(Usuario oUsuario, Connection oConnection) {
		boolean bExito = false;
		if (oUsuario != null && oUsuario.checkUsuario()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "INSERT INTO Usuario VALUES (";
				if (oUsuario.getsCorreo() != null) {
					sSQL += "'" + oUsuario.getsCorreo() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oUsuario.getsContrasenia() != null) {
					sSQL += "'" + oUsuario.getsContrasenia() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ")";

				if (stmt.executeUpdate(sSQL) > 0) {
					bExito = true;
				}
				stmt.close();
			} catch (SQLException e) {
				bExito = false;
			}
		}
		return bExito;
	}

	public boolean remove(Usuario oUsuario, Connection oConnection) {

		boolean bExito = false;
		if (oUsuario != null && oUsuario.getsCorreo() != null) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "DELETE FROM Usuario WHERE email = ";
				if (oUsuario.getsCorreo() != null) {
					sSQL += "'" + oUsuario.getsCorreo() + "'";
				} else {
					sSQL += "NULL";
				}

				if (stmt.executeUpdate(sSQL) > 0) {
					bExito = true;
				}
				stmt.close();
			} catch (SQLException e) {
				bExito = false;
			}
		}
		return bExito;
	}

	public boolean update(Usuario oUsuario, Connection oConnection) {
		boolean bExito = false;
		if (oUsuario != null && oUsuario.checkUsuario()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE Usuario SET password = ";
				if (oUsuario.getsContrasenia() != null) {
					sSQL += "'" + oUsuario.getsContrasenia() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += " WHERE email = ";
				if (oUsuario.getsCorreo() != null) {
					sSQL += "'" + oUsuario.getsCorreo() + "'";
				} else {
					sSQL += "NULL";
				}

				if (stmt.executeUpdate(sSQL) > 0) {
					bExito = true;
				}
				stmt.close();
			} catch (SQLException e) {
				bExito = false;
			}
		}
		return bExito;
	}

	public List<Usuario> readAll() {
		return this.getLista();
	}

	public Usuario searchByPk(Usuario oUsuario, Connection oConnection) {
		Usuario oUsuarioResult = null;
		String sSQL = "SELECT * FROM Usuario WHERE email = '" + oUsuario.getsCorreo() + "'";

		try {
			Statement stmt = oConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			if (rs.next()) {
				oUsuarioResult = new Usuario(oUsuario.getsCorreo());
				oUsuarioResult.setsContrasenia(rs.getString(2));
			}
			stmt.close();
		} catch (SQLException e) {
			oUsuarioResult = null;
		}

		return oUsuarioResult;
	}

    
}
