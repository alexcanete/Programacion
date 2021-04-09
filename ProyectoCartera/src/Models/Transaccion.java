package Models;

import java.util.Objects;

public class Transaccion implements ITransaccion{
    private int iIdTransaccion;
    private String sFecha;
    private Operacion oIdOperacion;

    public Transaccion(int iIdTransaccion) {
        setiIdTransaccion(iIdTransaccion);
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

    



}
