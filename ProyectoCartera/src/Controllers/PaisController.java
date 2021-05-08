package Controllers;

import Models.*;
import java.sql.ResultSet;
import java.sql.*;
import com.google.gson.*;

public class PaisController {
    public boolean add(Pais oPais) {
        boolean bExito = false;
        if (oPais != null && oPais.checkPais()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oPais) + "]";
            System.out.println(json);

            bExito = Controller.executeProcedure(json, "{call Pais_create(?)}");

        }
        return bExito;
    }


    public Pais search(Pais oPais) {
        Pais oPaisResult = null;
        if (oPais != null) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oPais) + "]";

            try {

                CallableStatement statement = Controller.getConnection().prepareCall("{call Pais_search_by_pk(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oPaisResult = new Pais(oPais.getsNombrePais());
                    oPaisResult.setsNombrePais(rs.getString(2));
                }

                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return oPaisResult;
    }

    public boolean remove(Pais oPais) {

        boolean bExito = false;
        if (oPais != null) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oPais) + "]";
            bExito = Controller.executeProcedure(json, "{call Pais_delete(?)}");
        }
        return bExito;
    }
}
