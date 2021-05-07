package Controllers;

import java.sql.*;
import java.util.*;
import java.io.*;
import Models.Cliente;
import Models.Moneda;
import Models.Usuario;



public class Controller implements IController {

	private PersonasController oPersonasCtrl;
	private static Connection oConnection;
	private TransaccionController oTransaccionCtrl;
	private MonedaController oMonedaCtrl;


	public Controller() {
		oPersonasCtrl = new PersonasController();
		oTransaccionCtrl=new TransaccionController();
		oMonedaCtrl= new MonedaController();
	}

	public MonedaController getMonedaCtrl(){
		return oMonedaCtrl;
	}

	public static Connection getConnection() {
		return oConnection;
	}

	public TransaccionController getoTransaccionCtrl() {
		return oTransaccionCtrl;
	}

	public PersonasController getoPersonasCtrl() {
		return oPersonasCtrl;
	}

	/*
	 * # DB METHODS
	 */
	public boolean init() throws Exception {
		boolean bExito = false;
		oConnection = connectDb();
		if (oConnection != null) {
			bExito = true;
		}
		return bExito;
	}

	public void closeDb() {
		if (oConnection != null) {
			try {
				oConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Map<String, String> getPropertiesDb() throws Exception {

		Map<String, String> mapProperties = new HashMap<String, String>();

		// Database credentials
		File file = new File(CONFIG_URL);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String linea;
		while ((linea = br.readLine()) != null) {
			linea = linea.replaceAll(" ", "");
			String sParam = linea.substring(0, linea.indexOf(":"));
			String sValue = linea.substring(linea.indexOf(":") + 1, linea.length());
			mapProperties.put(sParam, sValue);
		}
		br.close();
		return mapProperties;
	}

	public Connection connectDb() throws Exception {

		Map<String, String> mapProperties = getPropertiesDb();

		Connection conn = null;
		String sURL = "jdbc:mysql://" + mapProperties.get("SERVER") + ":" + mapProperties.get("PORT") + "/"
				+ mapProperties.get("DB");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(sURL, mapProperties.get("USER"), mapProperties.get("PASSWORD"));
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public boolean addCliente(Cliente oCliente) {
		return oPersonasCtrl.getoClientCtrl().add(oCliente, oConnection);
	}

	public boolean removeUsuario(Usuario uUsuario) {
		return oPersonasCtrl.getoUserCtrl().remove(uUsuario);
	}

	public boolean updateCliente(Cliente oCliente) {
		return oPersonasCtrl.getoClientCtrl().update(oCliente);
	}

	

	
	public static boolean executeProcedure(String json, String sFunction) {

		boolean bExito = false;
		try {

			CallableStatement statement = oConnection.prepareCall(sFunction);
			statement.setString(1, json);
			if (statement.executeUpdate() > 0) {
				bExito = true;
			}
			statement.close();

		} catch (SQLException ex) {
			bExito = false;
		}

		return bExito;

	}

	public Cliente searchCliente(Cliente cliente) {
		return null;
	}

	public Moneda searchMoneda(Moneda moneda){
		return null;
	}

	public boolean updateMoneda(Moneda oMoneda) {
		return oMonedaCtrl.update(oMoneda);
	}

	

}
