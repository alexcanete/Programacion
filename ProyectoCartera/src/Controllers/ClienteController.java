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

    public Cliente searchByPk(Cliente oCliente, Connection oConnection) {
        Cliente oClienteResult = null;
        String sSQL = "SELECT * FROM Cliente WHERE sDni = '" + oCliente.getsDni() + "'";

        try {
            Statement stmt = oConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sSQL);
            if (rs.next()) {
                oClienteResult = new Cliente(oCliente.getsDni());
                oClienteResult.setsNombre(rs.getString(2));
                oClienteResult.setsApellidos(rs.getString(3));
                oClienteResult.setsDni(rs.getString(4));
                oClienteResult.setsFechaNacimiento(rs.getString(5));

            }
            stmt.close();
        } catch (SQLException e) {
            oClienteResult = null;
        }

        return oClienteResult;
    }

    /*public List<Cliente> searchByDireccion(String sDireccion, Connection oConnection) {
        List<Cliente> oListaClientes = new ArrayList<Cliente>();
        String sSQL = "SELECT sDni, sNombre, sApellidos FROM Cliente WHERE sDireccion = '" + sDireccion + "'";

        try {
            Statement stmt = oConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sSQL);
            while (rs.next()) {
                Cliente oClienteResult = new Cliente(rs.getString(1));
                oClienteResult.setsNombre(rs.getString(2));
                oClienteResult.setsApellidos(rs.getString(3));
                oListaClientes.add(oClienteResult);
            }
            stmt.close();
        } catch (SQLException e) {
            oListaClientes = null;
        }

        return oListaClientes;
    }*/
}
