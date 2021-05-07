package Controllers;

import java.util.*;

import com.google.gson.Gson;

import Models.*;
import java.sql.*;

public class UsuarioController{
    

	/*
	 * ######## # CRUD # ########
	 */
	

	public boolean remove(Usuario oUsuario) {

		boolean bExito = false;
		if (oUsuario != null && oUsuario.getsNombreUsuario() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oUsuario) + "]";
			System.out.println(json);
			bExito = Controller.executeProcedure(json, "{call cliente_delete(?)}");
		}
		return bExito;
	}

	public boolean update(Usuario oUsuario) {
		boolean bExito = false;
		if (oUsuario != null && oUsuario.checkUsuario()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oUsuario) + "]";

			bExito = Controller.executeProcedure(json, "{call usuario_update(?)}");
		}
		return bExito;
	}

	public List<Usuario> readAll() {
		List<Usuario> lUsuarios = new ArrayList<Usuario>();

		try {

			CallableStatement statement = Controller.getConnection().prepareCall("{call usuario_search_all()}");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Usuario oUsuario = new Usuario(rs.getString(1));
				oUsuario.setsContrasenia(rs.getString(2));
				lUsuarios.add(oUsuario);
			}

			statement.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return lUsuarios;
	}

	public Usuario searchByPk(Usuario oUsuario) {
		Usuario oUsuarioResult = null;
		if (oUsuario != null && oUsuario.getsNombreUsuario() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oUsuario) + "]";

			try {

				CallableStatement statement = Controller.getConnection().prepareCall("{call usuario_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oUsuarioResult = new Usuario(oUsuario.getsNombreUsuario());
					oUsuarioResult.setsCorreo(rs.getString(2));
					oUsuarioResult.setsContrasenia(rs.getString(3));
				}

				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return oUsuarioResult;
	}

    
}
