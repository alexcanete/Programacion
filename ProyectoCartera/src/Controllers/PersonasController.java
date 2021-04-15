package Controllers;

import Models.Cliente;
import Models.Usuario;
import java.sql.*;

public class PersonasController {

    private UsuarioController oUserCtrl;
    private ClienteController oClientCtrl;

    public PersonasController() {
        oUserCtrl = new UsuarioController();
        oClientCtrl = new ClienteController();
    }

    public UsuarioController getoUserCtrl() {
        return oUserCtrl;
    }

    public ClienteController getoClientCtrl() {
        return oClientCtrl;
    }

    /*
     * # CONTROLLER METHODS
     */

    public boolean removeCliente(Cliente oCliente, Connection oConnection) {
        boolean bExito = false;
        if (oClientCtrl.remove(oCliente, oConnection)) {
            bExito = true;
        }
        return bExito;
    }

    public Cliente searchCliente(Cliente oCliente, Connection oConnection) {
        Cliente oClienteRes = oClientCtrl.searchByPk(oCliente, oConnection);
        Usuario oUsuario = oUserCtrl.searchByPk(oClienteRes.getuUsuario(), oConnection);
        oClienteRes.setuUsuario(oUsuario);
        return oClienteRes;
    }

    
}