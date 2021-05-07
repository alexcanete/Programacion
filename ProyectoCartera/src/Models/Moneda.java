package Models;

import java.util.Objects;

public class Moneda implements IMoneda {
    private String sTipoMoneda;
    private String sValorMonedaEU;

    public Moneda(String sTipoMoneda) {
        setsTipoMoneda(sTipoMoneda);
    }

    public Moneda(String sTipoMoneda, String sValorMonedaEU) {
        setsTipoMoneda(sTipoMoneda);
        setsValorMonedaEU(sValorMonedaEU);
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
        return "{" + ", sTipoMoneda='" + getsTipoMoneda() + "'"
                + ", sValorMonedaEU='" + getsValorMonedaEU() + "'" + "}";
    }

    public boolean equals(Object o) {

        Moneda moneda = (Moneda) o;
        boolean boEquals = false;

        if (!(this.getsTipoMoneda() == moneda.getsTipoMoneda())) {
            boEquals = true;
        }
        return boEquals;
    }

    public int hashCode() {
        return Objects.hash(sTipoMoneda);
    }

    public boolean checkMoneda() {
		boolean bExito = false;
		if (this.getsTipoMoneda() != null && this.getsValorMonedaEU() != null) {
			bExito = true;
		}
		return bExito;
	}

}
