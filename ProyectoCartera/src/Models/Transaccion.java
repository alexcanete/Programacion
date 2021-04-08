package Models;

import java.util.Objects;

public class Transaccion {
    private int iIdTransaccion;
    private String sFecha;

    public Transaccion(int iIdTransaccion) {
        setiIdTransaccion(iIdTransaccion);
    }

    public Transaccion(int iIdTransaccion, String sFecha) {
        setiIdTransaccion(iIdTransaccion);
        setsFecha(sFecha);
    }

    public int getiIdTransaccion() {
        return this.iIdTransaccion;
    }

    public void setiIdTransaccion(int iIdTransaccion) {
        this.iIdTransaccion = iIdTransaccion;
    }

    public String getsFecha() {
        return this.sFecha;
    }

    public void setsFecha(String sFecha) {
        this.sFecha = sFecha;
    }

    @Override
    public String toString() {
        return "{" +
            " iIdTransaccion='" + getiIdTransaccion() + "'" +
            ", sFecha='" + getsFecha() + "'" +
            "}";
    }

    


    
    public int hashCode() {
        return Objects.hash(iIdTransaccion);
    }



}
