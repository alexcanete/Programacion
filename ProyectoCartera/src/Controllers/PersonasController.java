package Controllers;

import Models.Cliente;
import Models.Usuario;

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
    
    public Cliente searchCliente(Cliente oCliente) {
        Cliente oClienteRes = oClientCtrl.searchByPk(oCliente);
        if (oClienteRes != null) {
            Usuario oUsuario = oUserCtrl.searchByPk(oClienteRes.getuUsuario());
            oClienteRes.setuUsuario(oUsuario);
        }
        return oClienteRes;
    }

    

    
}