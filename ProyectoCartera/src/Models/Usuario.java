package Models;

import java.util.Objects;

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

    //Importante*****
    public boolean equals(Object o) {
        Usuario uUsuario = (Usuario) o;
        boolean boEquals=false;
        if (this.getsNombreUsuario().equals(uUsuario.getsNombreUsuario())) {
            boEquals = true;
        }
        return boEquals;
       
    }

    
    public int hashCode() {
        return Objects.hash(sNombreUsuario);
    }


}
