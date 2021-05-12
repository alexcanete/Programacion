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
        if(sTipoBillete != null && sTipoBillete.length()>1 && sTipoBillete.length()< 254){
            this.sTipoBillete = sTipoBillete;
        }
    }

    public String getsValorBilleteEU() {
        return this.sValorBilleteEU;
    }

    public void setsValorBilleteEU(String sValorBilleteEU) {
        if(sValorBilleteEU != null && sValorBilleteEU.length() > 1 && sValorBilleteEU.length()< 254){
            this.sValorBilleteEU = sValorBilleteEU;
        }
    }

    public String toString() {
        return "{" + ", sTipoBillete='" + getsTipoBillete() + "'" + ", sValorBilleteEU='" + getsValorBilleteEU() + "'"
                + "}";
    }

    public boolean equals(Object o) {
        Billete bBillete = (Billete) o;
        boolean boEquals = false;
        if (bBillete != null && this.getsTipoBillete() == (bBillete.getsTipoBillete())) {
            boEquals = true;
        }
        return boEquals;

    }

    public int hashCode() {
        return Objects.hash(sTipoBillete, sValorBilleteEU);
    }

    
    public boolean checkBillete() {
		boolean bExito = false;
		if (this.sTipoBillete != null && this.getsValorBilleteEU() != null) {
			bExito = true;
		}
		return bExito;
	}

}
