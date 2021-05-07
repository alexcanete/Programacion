package Models;

import java.util.Objects;
import java.util.regex.Pattern;

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
        if(sNombreUsuario!=null && !sNombreUsuario.isEmpty() && sNombreUsuario.length() > 3 && sNombreUsuario.length() < 15){
            this.sNombreUsuario = sNombreUsuario;
        }
    }

    public String getsCorreo() {
        return this.sCorreo;
    }

    public void setsCorreo(String sCorreo) {
        String Correo = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        if (Pattern.matches(Correo, sCorreo)) {
            this.sCorreo = sCorreo;
        }

    }

    public String getsContrasenia() {
        return this.sContrasenia;
    }

    public void setsContrasenia(String sContrasenia) {
        if(sContrasenia != null && !sContrasenia.isEmpty() && sContrasenia.length() > 5 && sContrasenia.length() < 12){
            this.sContrasenia = sContrasenia;
        }
    }
    

    // Importante*****
    public boolean equals(Object o) {
        Usuario uUsuario = (Usuario) o;
        boolean boEquals = false;
        if (uUsuario!= null && this.getsNombreUsuario().equals(uUsuario.getsNombreUsuario())) {
            boEquals = true;
        }
        return boEquals;

    }

    public int hashCode() {
        return Objects.hash(sNombreUsuario);
    }

    public boolean checkUsuario() {
		boolean bExito = false;
		if (this.getsNombreUsuario() != null && this.getsContrasenia() != null) {
			bExito = true;
		}
		return bExito;
	}

    @Override
    public String toString() {
        return "{" +
            " sNombreUsuario='" + getsNombreUsuario() + "'" +
            ", sCorreo='" + getsCorreo() + "'" +
            ", sContrasenia='" + getsContrasenia() + "'" +
            "}";
    }


}
