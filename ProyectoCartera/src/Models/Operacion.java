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
        Operacion oOperacion = (Operacion) o;
        boolean boEquals = false;
        if (oOperacion != null && this.getiIdOperacion()==(oOperacion.getiIdOperacion())) {
            boEquals = true;
        }
        return boEquals;

    }

    public int hashCode() {
        return Objects.hash(iIdOperacion);
    }

}
