package Models;

import java.util.Objects;

public class Billete implements IBillete {
    private int iIdBillete;
    private String sTipoBillete;
    private String sValorBilleteEU;


    public Billete (int iIdBillete){
        setiIdBillete(iIdBillete);
    }
    public Billete(int iIdBillete, String sTipoBillete ,String sValorBillete){
        setiIdBillete(iIdBillete);
        setsTipoBillete(sTipoBillete);
        setsValorBilleteEU(sValorBillete);
    }


    public int getiIdBillete() {
        return this.iIdBillete;
    }

    public void setiIdBillete(int iIdBillete) {
        this.iIdBillete = iIdBillete;
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
        return "{" +
            " iIdBillete='" + getiIdBillete() + "'" +
            ", sTipoBillete='" + getsTipoBillete() + "'" +
            ", sValorBilleteEU='" + getsValorBilleteEU() + "'" +
            "}";
    }

    
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Billete)) {
            return false;
        }
        Billete billete = (Billete) o;
        return iIdBillete == billete.iIdBillete && Objects.equals(sTipoBillete, billete.sTipoBillete) && Objects.equals(sValorBilleteEU, billete.sValorBilleteEU);
    }

    
    public int hashCode() {
        return Objects.hash(iIdBillete, sTipoBillete, sValorBilleteEU);
    }


}
