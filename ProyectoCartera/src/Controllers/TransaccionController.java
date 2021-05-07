package Controllers;

import Models.*;
import java.sql.ResultSet;
import java.sql.*;
import com.google.gson.*;

public class TransaccionController {
    
    public boolean add(Transaccion oTransaccion) {
        boolean bExito = false;
        if (oTransaccion != null && oTransaccion.checkTransaccion()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oTransaccion) + "]";
            System.out.println(json);

            bExito = Controller.executeProcedure(json, "{call transaccion_create(?)}");

        }
        return bExito;
    }

    public boolean update(Transaccion oTransaccion) {
        boolean bExito = false;
        if (oTransaccion != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oTransaccion) + "]";

            bExito = Controller.executeProcedure(json, "{call moneda_update(?)}");
        }
        return bExito;
    }

    public Transaccion search(Transaccion oTransaccion) {
        Transaccion oTransaccionResult = null;
        if (oTransaccion != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oTransaccion) + "]";

            try {

                CallableStatement statement = Controller.getConnection().prepareCall("{call moneda_search_by_pk(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oTransaccionResult = new Transaccion(oTransaccion.getiIdTransaccion());
                    oTransaccionResult.setiIdTransaccion(rs.getInt(2));
                    oTransaccionResult.setsFecha(rs.getString(3));
                }

                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return oTransaccionResult;
    }

    public boolean remove(Transaccion oTransaccion) {

        boolean bExito = false;
        if (oTransaccion != null) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oTransaccion) + "]";
            bExito = Controller.executeProcedure(json, "{call Transaccion_delete(?)}");
        }
        return bExito;
    }
}
