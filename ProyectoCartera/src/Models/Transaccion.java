package Models;

import java.util.Objects;

public class Transaccion implements ITransaccion{
    private int iIdTransaccion;
    private String sFecha;
    private Operacion oIdOperacion;

    public Transaccion(int iIdTransaccion2) {
        setiIdTransaccion(iIdTransaccion2);
    }

    public Transaccion(int iIdTransaccion, String sFecha) {
        setiIdTransaccion(iIdTransaccion);
        setsFecha(sFecha);
    }
    public Transaccion(int iIdTransaccion, String sFecha, Operacion oIdOperacion){
        setiIdTransaccion(iIdTransaccion);
        setsFecha(sFecha);
        setoIdOperacion(oIdOperacion);
        
    }
    public Operacion getoIdOperacion() {
        return this.oIdOperacion;
    }

    public void setoIdOperacion(Operacion oIdOperacion) {
        this.oIdOperacion = oIdOperacion;
    }
    public int getiIdTransaccion() {
        return this.iIdTransaccion;
    }

    public void setiIdTransaccion(int iIdTransaccion) {
        if(iIdTransaccion > 1 && iIdTransaccion< 254){
            this.iIdTransaccion = iIdTransaccion;

        }
    }

    public String getsFecha() {
        return this.sFecha;
    }

    public void setsFecha(String sFecha) {
        if(sFecha != null && sFecha.length() > 8 && sFecha.length()< 254){
            this.sFecha = sFecha;

        }
    }

    @Override
    public String toString() {
        return "{" +
            " iIdTransaccion='" + getiIdTransaccion() + "'" +
            ", sFecha='" + getsFecha() + "/" +
            "}";
    }
    public boolean equals(Object o) {
        Transaccion tTransaccion = (Transaccion) o;
        boolean boEquals = false;
        if (tTransaccion!= null && this.getiIdTransaccion()==(tTransaccion.getiIdTransaccion())) {
            boEquals = true;
        }
        return boEquals;

    }
    
    


    
    public int hashCode() {
        return Objects.hash(iIdTransaccion);
    }

    public boolean checkTransaccion() {
		boolean bExito = false;
		if (this.getiIdTransaccion() == 0 && this.getsFecha() != null) {
			bExito = true;
		}
		return bExito;
	}



}
