package Models;

import java.util.Objects;

public class Billetera {
    
    private String sNombreBilletera;
    private int iSaldoActual;
    private Transaccion tTransaccionId;
    private Billetera bBilleteraId;
    private Cliente cClienteId;


    public Billetera(String sNombreBilletera){
        setsNombreBilletera(sNombreBilletera);
    }

    public String getsNombreBilletera() {
        return this.sNombreBilletera;
    }

    public void setsNombreBilletera(String sNombreBilletera) {
        this.sNombreBilletera = sNombreBilletera;
    }

    public int getiSaldoActual() {
        return this.iSaldoActual;
    }

    public void setiSaldoActual(int iSaldoActual) {
        this.iSaldoActual = iSaldoActual;
    }

    public Transaccion gettTransaccionId() {
        return this.tTransaccionId;
    }

    public void settTransaccionId(Transaccion tTransaccionId) {
        this.tTransaccionId = tTransaccionId;
    }

    public Billetera getbBilleteraId() {
        return this.bBilleteraId;
    }

    public void setbBilleteraId(Billetera bBilleteraId) {
        this.bBilleteraId = bBilleteraId;
    }

    public Cliente getcClienteId() {
        return this.cClienteId;
    }

    public void setcClienteId(Cliente cClienteId) {
        this.cClienteId = cClienteId;
    }


    
    public String toString() {
        return "{" +
            " sNombreBilletera='" + getsNombreBilletera() + "'" +
            ", iSaldoActual='" + getiSaldoActual() + "'" +
            ", tTransaccionId='" + gettTransaccionId() + "'" +
            ", bBilleteraId='" + getbBilleteraId() + "'" +
            ", cClienteId='" + getcClienteId() + "'" +
            "}";
    }
    
    

    
    public int hashCode() {
        return Objects.hash(sNombreBilletera);
    }

    

    public boolean equals(Object o) {
        Billetera bBilletera = (Billetera) o;
        boolean boEquals=false;
        if (this.getsNombreBilletera()==(bBilletera.getsNombreBilletera())) {
            boEquals = true;
        }
        return boEquals;
       
    }
}
