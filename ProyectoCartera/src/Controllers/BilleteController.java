package Controllers;

import Models.*;
import java.sql.ResultSet;
import java.sql.*;
import com.google.gson.*;


public class BilleteController {
    public boolean add(Billete obillete) {
        boolean bExito = false;
        if (obillete != null && obillete.checkBillete()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(obillete) + "]";
            System.out.println(json);

            bExito = Controller.executeProcedure(json, "{call billete_create(?)}");

        }
        return bExito;
    }

    public boolean update(Billete obillete) {
        boolean bExito = false;
        if (obillete != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(obillete) + "]";

            bExito = Controller.executeProcedure(json, "{call billete_update(?)}");
        }
        return bExito;
    }

    public Billete search(Billete obillete) {
        Billete obilleteResult = null;
        if (obillete != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(obillete) + "]";

            try {

                CallableStatement statement = Controller.getConnection().prepareCall("{call billete_search_by_pk(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    obilleteResult = new Billete(obillete.getsTipoBillete());
                    obilleteResult.setsTipoBillete(rs.getString(2));
                    obilleteResult.setsValorBilleteEU(rs.getString(3));
                }

                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return obilleteResult;
    }

    public boolean remove(Billete obillete) {

        boolean bExito = false;
        if (obillete != null) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(obillete) + "]";
            bExito = Controller.executeProcedure(json, "{call billete_delete(?)}");
        }
        return bExito;
    }
}