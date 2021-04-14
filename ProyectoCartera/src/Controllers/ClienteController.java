package Controllers;

import java.util.*;
import Models.*;
import java.sql.*;

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

            try {
                Statement stmt = oConnection.createStatement();

                String sSQL = "INSERT INTO Cliente VALUES (";
                if (oCliente.getsDni() != null) {
                    sSQL += "'" + oCliente.getsDni() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                if (oCliente.getsNombre() != null) {
                    sSQL += "'" + oCliente.getsNombre() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                if (oCliente.getsApellidos() != null) {
                    sSQL += "'" + oCliente.getsApellidos() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                if (oCliente.getsFechaNacimiento() != null) {
                    sSQL += "'" + oCliente.getsFechaNacimiento() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

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

    
    public boolean remove(Cliente oCliente, Connection oConnection) {
        boolean bExito = false;
        if (oCliente != null && oCliente.getsDni() != null) {

            try {
                Statement stmt = oConnection.createStatement();

                String sSQL = "DELETE FROM Cliente WHERE dni = ";
                if (oCliente.getsDni() != null) {
                    sSQL += "'" + oCliente.getsDni() + "'";
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

    public boolean update(Cliente oCliente, Connection oConnection) {
        boolean bExito = false;
        if (oCliente != null && oCliente.checkCliente()) {

            try {
                Statement stmt = oConnection.createStatement();

                String sSQL = "UPDATE Cliente SET ";

                sSQL += "sDni = ";
                if (oCliente.getsDni() != null) {
                    sSQL += "'" + oCliente.getsDni() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                sSQL += "sNombre = ";
                if (oCliente.getsNombre() != null) {
                    sSQL += "'" + oCliente.getsNombre() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                sSQL += "sApellidos = ";
                if (oCliente.getsApellidos() != null) {
                    sSQL += "'" + oCliente.getsApellidos() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                sSQL += "sFechaNacimiento = ";
                if (oCliente.getsFechaNacimiento() != null) {
                    sSQL += "'" + oCliente.getsFechaNacimiento() + "'";
                } else {
                    sSQL += "NULL";
                }

                sSQL += " WHERE sDni = '" + oCliente.getsDni() + "'";

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

    public List<Cliente> readAll() {
        return this.getLista();
    }

    
    
}
