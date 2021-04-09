package Models;

import java.util.Objects;

public class Moneda implements IMoneda {
    private int iIdMoneda;
    private String sTipoMoneda;
    private String sValorMonedaEU;

    public Moneda(int iIdMoneda) {
        setiIdMoneda(iIdMoneda);
    }

    public Moneda(int iIdMoneda, String sTipoMoneda, String sValorMonedaEU) {
        setiIdMoneda(iIdMoneda);
        setsTipoMoneda(sTipoMoneda);
        setsValorMonedaEU(sValorMonedaEU);
    }

    public int getiIdMoneda() {
        return this.iIdMoneda;
    }

    public void setiIdMoneda(int iIdMoneda) {
        this.iIdMoneda = iIdMoneda;
    }

    public String getsTipoMoneda() {
        return this.sTipoMoneda;
    }

    public void setsTipoMoneda(String sTipoMoneda) {
        this.sTipoMoneda = sTipoMoneda;
    }

    public String getsValorMonedaEU() {
        return this.sValorMonedaEU;
    }

    public void setsValorMonedaEU(String sValorMonedaEU) {
        this.sValorMonedaEU = sValorMonedaEU;
    }

    public String toString() {
        return "{" + " iIdMoneda='" + getiIdMoneda() + "'" + ", sTipoMoneda='" + getsTipoMoneda() + "'"
                + ", sValorMonedaEU='" + getsValorMonedaEU() + "'" + "}";
    }

    public boolean equals(Object o) {

        Moneda moneda = (Moneda) o;
        boolean boEquals = false;

        if (!(this.getiIdMoneda() == moneda.getiIdMoneda())) {
            boEquals = true;
        }
        return boEquals;
    }

    public int hashCode() {
        return Objects.hash(iIdMoneda);
    }

}
