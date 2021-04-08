package Models;

import java.util.Objects;

public class Billetera {
    
    private int iIdBilletera;
    private int iSaldoActual;
    private Transaccion tTransaccionId;
    private Billetera bBilleteraId;
    private Cliente cClienteId;


    public Billetera(int iIdBilletera){
        setiIdBilletera(iIdBilletera);
    }

    public int getiIdBilletera() {
        return this.iIdBilletera;
    }

    public void setiIdBilletera(int iIdBilletera) {
        this.iIdBilletera = iIdBilletera;
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
            " iIdBilletera='" + getiIdBilletera() + "'" +
            ", iSaldoActual='" + getiSaldoActual() + "'" +
            ", tTransaccionId='" + gettTransaccionId() + "'" +
            ", bBilleteraId='" + getbBilleteraId() + "'" +
            ", cClienteId='" + getcClienteId() + "'" +
            "}";
    }
    
    

    
    public int hashCode() {
        return Objects.hash(iIdBilletera);
    }


}
