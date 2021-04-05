package Models;

public class Usuario implements IUsuario {
    private String sNombreUsuario;
    private String sCorreo;
    private String sContrasenia;

    public Usuario(String sNombreUsuario) {
        setsNombreUsuario(sNombreUsuario);
    }

    public Usuario(String sNombreUsuario, String sCorreo, String sContrasenia) {
        setsNombreUsuario(sNombreUsuario);
        setsCorreo(sCorreo);
        setsContrasenia(sContrasenia);
    }





    public String getsNombreUsuario() {
        return this.sNombreUsuario;
    }

    public void setsNombreUsuario(String sNombreUsuario) {
        this.sNombreUsuario = sNombreUsuario;
    }

    public String getsCorreo() {
        return this.sCorreo;
    }

    public void setsCorreo(String sCorreo) {
        this.sCorreo = sCorreo;
    }

    public String getsContrasenia() {
        return this.sContrasenia;
    }

    public void setsContrasenia(String sContrasenia) {
        this.sContrasenia = sContrasenia;
    }


}
`