public class Cliente {
    private String sDni;
    private String sNombre;
    private String sApellidos;
    private int iTelefono;
    private String sTipoCliente;

    public Cliente(String sDni, String sNombre, String sApellidos, int iTelefono, String sTipoCliente) {
        setsDni(sDni);
        setsNombre(sNombre);
        setsApellidos(sApellidos);
        setsTipoCliente(sTipoCliente);
        setiTelefono(iTelefono);
    }

    public String getsDni() {
        return sDni;
    }

    public void setsDni(String sDni) {
        this.sDni = sDni;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        if(sNombre.length()>=0 & sNombre.length()<=150){
            this.sNombre = sNombre;
        }
    }

    public String getsApellidos() {
        return sApellidos;
    }

    public void setsApellidos(String sApellidos) {
        if(sApellidos.length()>=0 & sApellidos.length()<=150){
            this.sApellidos = sApellidos;
        }
    }

    public int getiTelefono() {
        return iTelefono;
    }

    public void setiTelefono(int iTelefono) {
        if(iTelefono>=000000001 & iTelefono<=999999999)
        this.iTelefono = iTelefono;
    }

    public String getsTipoCliente() {
        return sTipoCliente;
    }

    public void setsTipoCliente(String sTipoCliente) {
        this.sTipoCliente = sTipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente [iTelefono=" + iTelefono + ", sApellidos=" + sApellidos + ", sDni=" + sDni + ", sNombre="
                + sNombre + ", sTipoCliente=" + sTipoCliente + "]";
    }
}
