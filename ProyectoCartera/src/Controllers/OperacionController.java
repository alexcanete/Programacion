package Controllers;


import Models.*;
import java.sql.ResultSet;
import java.sql.*;
import com.google.gson.*;


public class OperacionController {

    private OperacionController oOperacionCtrl;

    public OperacionController getOperacionCtrl(){
        return oOperacionCtrl;
    }

    

    public boolean add(Operacion oOperacion) {
        boolean bExito = false;
        if (oOperacion != null && oOperacion.checkOperacion()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oOperacion) + "]";
            System.out.println(json);

            bExito = Controller.executeProcedure(json, "{call Operacion_create(?)}");

        }
        return bExito;
    }

    public boolean update(Operacion oOperacion) {
        boolean bExito = false;
        if (oOperacion != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oOperacion) + "]";

            bExito = Controller.executeProcedure(json, "{call Operacion_update(?)}");
        }
        return bExito;
    }

    public Operacion search(Operacion oOperacion) {
        Operacion oOperacionResult = null;
        if (oOperacion != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oOperacion) + "]";

            try {

                CallableStatement statement = Controller.getConnection().prepareCall("{call Operacion_search_by_pk(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oOperacionResult = new Operacion(oOperacion.getiIdOperacion());
                    oOperacionResult.setiIdOperacion(rs.getInt(2));
                    oOperacionResult.setsTipoOperacion(rs.getString(3));
                }

                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return oOperacionResult;
    }

    public boolean remove(Operacion oOperacion) {

        boolean bExito = false;
        if (oOperacion != null) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oOperacion) + "]";
            bExito = Controller.executeProcedure(json, "{call Operacion_delete(?)}");
        }
        return bExito;
    }
}
