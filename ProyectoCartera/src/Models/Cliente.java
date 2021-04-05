package Models;

public class Cliente implements ICliente {
    String sDNI, sNombre, sApellidos, sTarjetaCredito, sFechaNacimiento;

    public String getsDNI() {
        return this.sDNI;
    }

    public void setsDNI(String sDNI) {
        this.sDNI = sDNI;
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

    public String getsTarjetaCredito() {
        return this.sTarjetaCredito;
    }

    public void setsTarjetaCredito(String sTarjetaCredito) {
        this.sTarjetaCredito = sTarjetaCredito;
    }

    public String getsFechaNacimiento() {
        return this.sFechaNacimiento;
    }

    public void setsFechaNacimiento(String sFechaNacimiento) {
        this.sFechaNacimiento = sFechaNacimiento;
    }

}
