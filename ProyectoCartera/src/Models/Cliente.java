package Models;

import java.util.Objects;

public class Cliente implements ICliente{
    private Usuario uIdUsuario;
    private String sDni;
    private String sNombre;
    private String sApellidos;
    private String sFechaNacimiento;

    public Cliente (String sDni){
        setsDni(sDni);

    }
    public Cliente (String sDni, String sNombre, String sApellidos, String sFechaNacimiento, Usuario uIdUsuario){
        setsDni(sDni);
        setsNombre(sNombre);
        setsApellidos(sApellidos);
        setsFechaNacimiento(sFechaNacimiento);
        setUIdUsuario(uIdUsuario);

    }

    public Usuario getUIdUsuario() {
        return this.uIdUsuario;
    }

    public void setUIdUsuario(Usuario uIdUsuario) {
        this.uIdUsuario = uIdUsuario;
    }

    public String getsDni() {
        return this.sDni;
    }

    public void setsDni(String sDni) {
        this.sDni = sDni;
    }

    public String getsNombre() {
        return this.sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsApellidos() {
        return this.sApellidos;
    }

    public void setsApellidos(String sApellidos) {
        this.sApellidos = sApellidos;
    }

    public String getsFechaNacimiento() {
        return this.sFechaNacimiento;
    }

    public void setsFechaNacimiento(String sFechaNacimiento) {
        this.sFechaNacimiento = sFechaNacimiento;
    }



    @Override
    public String toString() {
        return "{" +
            " uIdUsuario='" + getUIdUsuario() + "'" +
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

    
}
