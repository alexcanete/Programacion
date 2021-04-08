package Models;

import java.util.Objects;

public class Operacion {
    private int iIdOperacion;
    private boolean boTipoOperacion;

    public Operacion(int iIdOperacion) {
        setiIdOperacion(iIdOperacion);
    }

    public Operacion(int iIdOperacion, boolean boTipoOperacion) {
        setiIdOperacion(iIdOperacion);
        setboTipoOperacion(boTipoOperacion);
    }

    public int getiIdOperacion() {
        return this.iIdOperacion;
    }

    public void setiIdOperacion(int iIdOperacion) {
        this.iIdOperacion = iIdOperacion;
    }

    public boolean getboTipoOperacion() {
        return this.boTipoOperacion;
    }

    public void setboTipoOperacion(boolean boTipoOperacion) {
        this.boTipoOperacion = boTipoOperacion;
    }

    public String toString() {
        return "{" + " iIdOperacion='" + getiIdOperacion() + "'" + ", boTipoOperacion='" + getboTipoOperacion() + "'"
                + "}";
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Operacion)) {
            return false;
        }
        Operacion operacion = (Operacion) o;
        return iIdOperacion == operacion.iIdOperacion && boTipoOperacion == operacion.boTipoOperacion;
    }

    public int hashCode() {
        return Objects.hash(iIdOperacion);
    }

}
