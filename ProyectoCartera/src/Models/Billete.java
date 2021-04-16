package Models;

import java.util.Objects;

public class Billete implements IBillete {
    private String sTipoBillete;
    private String sValorBilleteEU;

    public Billete(String sTipoBillete) {
        setsTipoBillete(sTipoBillete);
    }

    public Billete(String sTipoBillete, String sValorBillete) {
        setsTipoBillete(sTipoBillete);
        setsValorBilleteEU(sValorBillete);
    }

    public String getsTipoBillete() {
        return this.sTipoBillete;
    }

    public void setsTipoBillete(String sTipoBillete) {
        this.sTipoBillete = sTipoBillete;
    }

    public String getsValorBilleteEU() {
        return this.sValorBilleteEU;
    }

    public void setsValorBilleteEU(String sValorBilleteEU) {
        this.sValorBilleteEU = sValorBilleteEU;
    }

    public String toString() {
        return "{" + ", sTipoBillete='" + getsTipoBillete() + "'" + ", sValorBilleteEU='" + getsValorBilleteEU() + "'"
                + "}";
    }

    public boolean equals(Object o) {
        Billete bBillete = (Billete) o;
        boolean boEquals = false;
        if (this.getsTipoBillete() == (bBillete.getsTipoBillete())) {
            boEquals = true;
        }
        return boEquals;

    }

    public int hashCode() {
        return Objects.hash(sTipoBillete, sValorBilleteEU);
    }

}
