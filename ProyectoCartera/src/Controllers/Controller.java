package Controllers;

import java.sql.*;
import java.util.*;
import java.io.*;

import Models.*;



public class Controller implements IController {

	private PersonasController oPersonasCtrl;
	private static Connection oConnection;
	private TransaccionController oTransaccionCtrl;
	private MonedaController oMonedaCtrl;
	private BilleteController oBilleteCtrl;
	private BilleteraController oBilleteraCtrl;
	private PaisController oPaisCtrl;
	private OperacionController oOperacionCtrl;



	public Controller() {
		oPersonasCtrl = new PersonasController();
		oTransaccionCtrl=new TransaccionController();
		oMonedaCtrl= new MonedaController();
		oBilleteCtrl=new BilleteController();
		oBilleteraCtrl=new BilleteraController();
		oPaisCtrl= new PaisController();
		oOperacionCtrl=new OperacionController();
	}

	public MonedaController getMonedaCtrl(){
		return oMonedaCtrl;
	}
	
	public BilleteController getBilleteCtrl() { 
		return oBilleteCtrl;
	}

	public static Connection getConnection() {
		return oConnection;
	}

	public TransaccionController getTransaccionCtrl() {
		return oTransaccionCtrl;
	}

	public PersonasController getoPersonasCtrl() {
		return oPersonasCtrl;
	}

	public BilleteraController getoBilleteraCtrl() {
		return oBilleteraCtrl;
	}
	public PaisController getoPaisCtrl() {
		return oPaisCtrl;
	}
	public OperacionController getoOperacionCtrl() {
		return oOperacionCtrl;
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


	public boolean removeMoneda(Moneda oMoneda) {
		return oMonedaCtrl.remove(oMoneda);
	}

	public Billete searchBillete(Billete billete)  {
		return null;
	}

	public boolean updateBillete(Billete oBillete) {
		return oBilleteCtrl.update(oBillete);
	}
	public boolean removeBillete(Billete oBillete) {
		return oBilleteCtrl.remove(oBillete);
	}

	public boolean updateTransaccion(Transaccion oTransaccion) {
		return oTransaccionCtrl.update(oTransaccion);
	}

	public Transaccion searchTransaccion(Transaccion transaccion) {
		return null;
	}
	

	public boolean removeTransaccion(Transaccion oTransaccion) {
		return oTransaccionCtrl.remove(oTransaccion);
	}


	public Billetera searchBilletera(Billetera billetera)  {
		return null;
	}

	public boolean updateBilletera(Billetera oBilletera) {
		return oBilleteraCtrl.update(oBilletera);
	}
	public boolean removeBilletera(Billetera oBilletera) {
		return oBilleteraCtrl.remove(oBilletera);
	}


	public Billetera searchPais(Pais Pais)  {
		return null;
	}

	public boolean removePais(Pais oPais) {
		return oPaisCtrl.remove(oPais);
	}


	public Operacion searchOperacion(Operacion operacion)  {
		return null;
	}

	public boolean updateOperacion(Operacion oOperacion) {
		return oOperacionCtrl.update(oOperacion);
	}
	public boolean removeOperacion(Operacion oOperacion) {
		return oOperacionCtrl.remove(oOperacion);
	}
}
