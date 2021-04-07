package Models;

public class Cliente implements ICliente{
    private Usuario uIdUsuario;
    private String sDni;
    private String sNombre;
    private String sApellidos;
    private String sFechaNacimiento;

    public cliente (String sDni){
        setsDni(sDni);

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



    
}
