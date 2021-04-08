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
        setSFecha(sFecha);
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
            " iIdTransaccion='" + getIIdTransaccion() + "'" +
            ", sFecha='" + getSFecha() + "'" +
            "}";
    }

    
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaccion)) {
            return false;
        }
        Transaccion transaccion = (Transaccion) o;
        return iIdTransaccion == transaccion.iIdTransaccion && Objects.equals(sFecha, transaccion.sFecha);
    }
    
    public boolean equals(Object o) {
        Transaccion tTransaccion = (Transaccion) o;
        boolean boEquals=false;
        if (this.getsDni().equals(cCliente.getsDni())) {
            boEquals = true;
        }
        return boEquals;
       
    }

    
    public int hashCode() {
        return Objects.hash(iIdTransaccion);
    }



}
