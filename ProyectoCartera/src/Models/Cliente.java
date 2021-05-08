package Models;

import java.util.Objects;
import java.util.regex.Pattern;

public class Cliente implements ICliente{
    private Usuario uUsuario;
    private String sDni;
    private String sNombre;
    private String sApellidos;
    private String sFechaNacimiento;
 
    
    

    public Cliente (String sDni){
        setsDni(sDni);

    }
    public Cliente (String sDni, String sNombre, String sApellidos, String sFechaNacimiento, Usuario uUsuario){
        setsDni(sDni);
        setsNombre(sNombre);
        setsApellidos(sApellidos);
        setsFechaNacimiento(sFechaNacimiento);
        setuUsuario(uUsuario);

    }

    public Usuario getuUsuario() {
        return this.uUsuario;
    }

    public void setuUsuario(Usuario uUsuario) {
        this.uUsuario = uUsuario;
    }

    public String getsDni() {
        return this.sDni;
    }

    public void setsDni(String sDni) {
        
        String DNI="[0-9]{7,8}[A-Z a-z]";
		if (Pattern.matches(DNI, sDni)) {
			this.sDni = sDni;
		}
	}

    
    public String getsNombre() {
        return this.sNombre;
    }

    public void setsNombre(String sNombre) {
        if(sNombre != null && sNombre.length()> 1 && sNombre.length()< 254){
            this.sNombre = sNombre;

        }
    }

    public String getsApellidos() {
        return this.sApellidos;
    }

    public void setsApellidos(String sApellidos) {
        if(sApellidos != null && sApellidos.length() > 1 && sApellidos.length()< 254){
            this.sApellidos = sApellidos;
        }
    }

    public String getsFechaNacimiento() {
        return this.sFechaNacimiento;
    }

    public void setsFechaNacimiento(String sFechaNacimiento) {
        if(sFechaNacimiento != null && sFechaNacimiento.length() > 1 && sFechaNacimiento.length()< 254){
            this.sFechaNacimiento = sFechaNacimiento;
        }
    }


    


    @Override
    public String toString() {
        return "{" +
            " uUsuario='" + getuUsuario() + "'" +
            ", sDni='" + getsDni() + "'" +
            ", sNombre='" + getsNombre() + "'" +
            ", sApellidos='" + getsApellidos() + "'" +
            ", sFechaNacimiento='" + getsFechaNacimiento() + "'" +
            "}";
    }

   

    public boolean equals(Object o) {
        Cliente cCliente = (Cliente) o;
        boolean boEquals=false;
        if (this.getsDni().equals(cCliente.getsDni())) {
            boEquals = true;
        }
        return boEquals;
       
    }
    
    public int hashCode() {
        return Objects.hash(sDni);
    }

    public boolean checkCliente() {
		boolean bExito = false;
		if (this.getsDni() != null && this.getsNombre() != null && this.getsApellidos() != null
				&& this.getuUsuario() != null && this.getuUsuario().checkUsuario()) {
			bExito = true;
		}
		return bExito;
	}

    
}
