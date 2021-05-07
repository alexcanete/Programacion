package Controllers;

import Models.*;
import java.sql.ResultSet;
import java.sql.*;
import com.google.gson.*;


public class MonedaController {
    public boolean add(Moneda oMoneda) {
        boolean bExito = false;
        if (oMoneda != null && oMoneda.checkMoneda()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oMoneda) + "]";
            System.out.println(json);

            bExito = Controller.executeProcedure(json, "{call moneda_create(?)}");

        }
        return bExito;
    }

    public boolean update(Moneda oMoneda) {
        boolean bExito = false;
        if (oMoneda != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oMoneda) + "]";

            bExito = Controller.executeProcedure(json, "{call moneda_update(?)}");
        }
        return bExito;
    }

    public Moneda search(Moneda oMoneda) {
        Moneda oMonedaResult = null;
        if (oMoneda != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oMoneda) + "]";

            try {

                CallableStatement statement = Controller.getConnection().prepareCall("{call moneda_search_by_pk(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oMonedaResult = new Moneda(oMoneda.getsTipoMoneda());
                    oMonedaResult.setsTipoMoneda(rs.getString(2));
                    oMonedaResult.setsValorMonedaEU(rs.getString(3));
                }

                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return oMonedaResult;
    }

    public boolean remove(Moneda oMoneda) {

        boolean bExito = false;
        if (oMoneda != null) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oMoneda) + "]";
            bExito = Controller.executeProcedure(json, "{call moneda_delete(?)}");
        }
        return bExito;
    }
}
