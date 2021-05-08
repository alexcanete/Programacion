package Models;

import java.util.Objects;

public class Billetera {
    
    private String sNombreBilletera;
    private String sSaldoActual;
    private Billetera obNombreBilletera;
    private Cliente oClienteDni;


    public Billetera(String sNombreBilletera, String sSaldoActual2){
        setsNombreBilletera(sNombreBilletera);
    }

    public Billetera(String sNombreBilletera2) {
    }

    public String getsNombreBilletera() {
        return this.sNombreBilletera;
    }

    public void setsNombreBilletera(String sNombreBilletera) {
        if(sNombreBilletera != null && sNombreBilletera.length() > 1 && sNombreBilletera.length()< 254){
            this.sNombreBilletera = sNombreBilletera;
        }
    }

    public String getsSaldoActual() {
        return this.sSaldoActual;
    }

    public void setsSaldoActual(String sSaldoActual) {
        if(sSaldoActual != null && sSaldoActual.length() > 1 && sSaldoActual.length()< 254){
            this.sSaldoActual = sSaldoActual;
        }
    }

    

    public Billetera getobNombreBilletera() {
        return this.obNombreBilletera;
    }

    public void setobNombreBilletera(Billetera obNombreBilletera) {
        this.obNombreBilletera = obNombreBilletera;
    }

    public Cliente getoClienteDni() {
        return this.oClienteDni;
    }

    public void setoClienteDni(Cliente oClienteDni) {
        this.oClienteDni = oClienteDni;
    }


    
    public String toString() {
        return "{" +
            " sNombreBilletera='" + getsNombreBilletera() + "'" +
            ", sSaldoActual='" + getsSaldoActual() + "'" +
            ", obNombreBilletera='" + getobNombreBilletera() + "'" +
            ", oClienteDni='" + getoClienteDni() + "'" +
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

    public boolean checkBilletera() {
		boolean bExito = false;
		if (this.getsNombreBilletera() != null && this.getsSaldoActual() != null) {
			bExito = true;
		}
		return bExito;
	}
}
