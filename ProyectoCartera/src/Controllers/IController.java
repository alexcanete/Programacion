package Controllers;

import java.sql.Connection;
import java.util.Map;

public interface IController {
    public final String PATH = "/home/alex/git-repositories/Programacion/ProyectoCartera";
    public final String CONFIG_URL = PATH + "/src/config/config.txt";

    //public PersonasController getoPersonasCtrl();

    public Connection getConnection();

    public boolean init() throws Exception;

    public void closeDb();

    public Map<String, String> getPropertiesDb() throws Exception;

    public Connection connectDb() throws Exception;
}
