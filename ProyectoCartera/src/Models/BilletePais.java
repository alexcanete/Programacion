package Models;

import java.util.Objects;

public class BilletePais {
    private Operacion oIdOperacion;
    private Billete bIdBillete;
    private Pais pNombrePais;

    public BilletePais(Operacion oIdOperacion, Billete bIdBillete, Pais pNombrePais){
        setoIdOperacion(oIdOperacion);
        setbIdBillete(bIdBillete);
        setpNombrePais(pNombrePais);
       
    }


    public Operacion getoIdOperacion() {
        return this.oIdOperacion;
    }

    public void setoIdOperacion(Operacion oIdOperacion) {
        this.oIdOperacion = oIdOperacion;
    }

    public Billete getoIdBillete() {
        return this.bIdBillete;
    }

    public void setbIdBillete(Billete bIdBillete) {
        this.bIdBillete = bIdBillete;
    }

    public Pais getoNombrePais() {
        return this.pNombrePais;
    }

    public void setpNombrePais(Pais pNombrePais) {
        this.pNombrePais = pNombrePais;
    }

       public String toString() {
        return "{" +
            " oIdOperacion='" + getoIdOperacion() + "'" +
            ", bIdBillete='" + getoIdBillete() + "'" +
            ", pNombrePais='" + getoNombrePais() + "'" +
            "}";
    }

    
    public boolean equals(Object o) {
        boolean boEquals = false;
        if (this.oIdOperacion != null && this.bIdBillete!= null&& this.pNombrePais!= null && oIdOperacion.equals(o) && bIdBillete.equals(o) && pNombrePais.equals(o)) {
            boEquals = true;

        }
        return boEquals;

    }

    public int hashCode() {
        return Objects.hash(oIdOperacion, bIdBillete, pNombrePais);
    }

    public boolean checkBilletePais() {
		boolean bExito = false;
		if (this.getoIdOperacion() != null && this.getoNombrePais() != null) {
			bExito = true;
		}
		return bExito;
	}


}
