package Controllers;

import Models.*;
import java.sql.ResultSet;
import java.sql.*;
import com.google.gson.*;

public class BilleteraController {
    public boolean add(Billetera oBilletera) {
        boolean bExito = false;
        if (oBilletera != null && oBilletera.checkBilletera()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oBilletera) + "]";
            System.out.println(json);

            bExito = Controller.executeProcedure(json, "{call Billetera_create(?)}");

        }
        return bExito;
    }

    public boolean update(Billetera oBilletera) {
        boolean bExito = false;
        if (oBilletera != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oBilletera) + "]";

            bExito = Controller.executeProcedure(json, "{call Billetera_update(?)}");
        }
        return bExito;
    }

    public Billetera search(Billetera oBilletera) {
        Billetera oBilleteraResult = null;
        if (oBilletera != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oBilletera) + "]";

            try {

                CallableStatement statement = Controller.getConnection().prepareCall("{call Billetera_search_by_pk(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oBilleteraResult = new Billetera(oBilletera.getsNombreBilletera(), json);
                    oBilleteraResult.setsNombreBilletera(rs.getString(2));
                    oBilleteraResult.setsSaldoActual(rs.getString(3));
                }

                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return oBilleteraResult;
    }

    public boolean remove(Billetera oBilletera) {

        boolean bExito = false;
        if (oBilletera != null) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oBilletera) + "]";
            bExito = Controller.executeProcedure(json, "{call Billetera_delete(?)}");
        }
        return bExito;
    }
    
}
