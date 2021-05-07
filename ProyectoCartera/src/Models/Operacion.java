package Models;

import java.util.Objects;

public class Operacion {
    private int iIdOperacion;
    private String sTipoOperacion;

    public Operacion(int iIdOperacion) {
        setiIdOperacion(iIdOperacion);
    }

    public Operacion(int iIdOperacion, String sTipoOperacion) {
        setiIdOperacion(iIdOperacion);
        setsTipoOperacion(sTipoOperacion);
    }

    public int getiIdOperacion() {
        return this.iIdOperacion;
    }

    public void setiIdOperacion(int iIdOperacion) {
        this.iIdOperacion = iIdOperacion;
    }

    public String getsTipoOperacion() {
        return this.sTipoOperacion;
    }

    public void setsTipoOperacion(String sTipoOperacion) {
        
        if (sTipoOperacion.equals("Suma")) {
            this.sTipoOperacion = sTipoOperacion;
        }else if(sTipoOperacion.equals("Resta")){
            this.sTipoOperacion = sTipoOperacion;

        }
        
    }

    public String toString() {
        return "{" + " iIdOperacion='" + getiIdOperacion() + "'" + ", sTipoOperacion='" + getsTipoOperacion() + "'"
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

    public boolean checkOperacion() {
		boolean bExito = false;
		if (this.getiIdOperacion() == 0 && this.getsTipoOperacion() != null) {
			bExito = true;
		}
		return bExito;
	}

}
