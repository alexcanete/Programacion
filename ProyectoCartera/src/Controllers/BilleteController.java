package Controllers;

import Models.*;
import java.sql.ResultSet;
import java.sql.*;
import com.google.gson.*;


public class BilleteController {
    public boolean add(Billete oBillete) {
        boolean bExito = false;
        if (oBillete != null && oBillete.checkBillete()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oBillete) + "]";
            System.out.println(json);

            bExito = Controller.executeProcedure(json, "{call billete_create(?)}");

        }
        return bExito;
    }

    public boolean update(Billete oBillete) {
        boolean bExito = false;
        if (oBillete != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oBillete) + "]";

            bExito = Controller.executeProcedure(json, "{call billete_update(?)}");
        }
        return bExito;
    }

    public Billete search(Billete oBillete) {
        Billete oBilleteResult = null;
        if (oBillete != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oBillete) + "]";

            try {

                CallableStatement statement = Controller.getConnection().prepareCall("{call billete_search_by_pk(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oBilleteResult = new Billete(oBillete.getsTipoBillete());
                    oBilleteResult.setsTipoBillete(rs.getString(2));
                    oBilleteResult.setsValorBilleteEU(rs.getString(3));
                }

                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return oBilleteResult;
    }

    public boolean remove(Billete oBillete) {

        boolean bExito = false;
        if (oBillete != null) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oBillete) + "]";   
            System.out.println(json);


            bExito = Controller.executeProcedure(json, "{call billete_delete(?)}");
        }
        return bExito;
    }
}