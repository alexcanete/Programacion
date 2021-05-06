package Controllers;

import java.util.*;
import Models.*;
import java.sql.*;
import com.google.gson.*;


public class ClienteController {
    private List<Cliente> lClientes;

    public ClienteController() {
        lClientes = new ArrayList<Cliente>();
    }

    public List<Cliente> getLista() {
        return lClientes;
    }

    public void setLista(List<Cliente> lClientes) {
        this.lClientes = lClientes;
    }

    /*
     * ######## # CRUD # ########
     */
    public boolean add(Cliente oCliente, Connection oConnection) {
        boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oCliente) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call cliente_create(?)}");
				statement.setString(1, json);

                System.out.println(json);//prueba (borrar)
				statement.execute();
				statement.close();

				bExito = true;

			} catch (SQLException ex) {
				bExito = false;
			}
            
		}
		return bExito;
    }


    public boolean update(Cliente oCliente) {
		boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oCliente) + "]";

			bExito = Controller.executeProcedure(json, "{call cliente_update(?)}");
		}
		return bExito;
	}

    public List<Cliente> readAll() {
		List<Cliente> lClientes = new ArrayList<Cliente>();

		try {

			CallableStatement statement = Controller.getConnection().prepareCall("{call cliente_search_all()}");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Cliente oCliente = new Cliente(rs.getString(1));
				oCliente.setsNombre(rs.getString(2));
				oCliente.setsApellidos(rs.getString(3));
				lClientes.add(oCliente);
			}

			statement.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return lClientes;
	}


    public Cliente searchByPk(Cliente oCliente) {
		Cliente oClienteResult = null;
		if (oCliente != null && oCliente.getsDni() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oCliente) + "]";

			try {

				CallableStatement statement = Controller.getConnection().prepareCall("{call cliente_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oClienteResult = new Cliente(oCliente.getsDni());
					oClienteResult.setsNombre(rs.getString(2));
					oClienteResult.setsApellidos(rs.getString(3));
					oClienteResult.setsFechaNacimiento(rs.getString(4));
				oClienteResult.setuUsuario(new Usuario(rs.getString(5)));
				}

				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oClienteResult;
	}

    
    
}
