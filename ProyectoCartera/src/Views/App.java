package Views;

import Models.Cliente;
import Models.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        Usuario oUsuario = new Usuario("juan", "juan@gmail.com","123");
        System.out.println(oUsuario.getsCorreo());
    }
}
