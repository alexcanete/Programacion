package Models;

import java.util.Objects;

public class BilletePais {
    private Operacion oIdOperacion;
    private Billete oIdBillete;
    private Pais oNombrePais;

    public BilletePais(Operacion oIdOperacion, Billete oIdBillete, Pais oNombrePais){
        setoIdOperacion(oIdOperacion);
        setoIdBillete(oIdBillete);
        setoNombrePais(oNombrePais);
    }


    public Operacion getoIdOperacion() {
        return this.oIdOperacion;
    }

    public void setoIdOperacion(Operacion oIdOperacion) {
        this.oIdOperacion = oIdOperacion;
    }

    public Billete getoIdBillete() {
        return this.oIdBillete;
    }

    public void setoIdBillete(Billete oIdBillete) {
        this.oIdBillete = oIdBillete;
    }

    public Pais getoNombrePais() {
        return this.oNombrePais;
    }

    public void setoNombrePais(Pais oNombrePais) {
        this.oNombrePais = oNombrePais;
    }

       public String toString() {
        return "{" +
            " oIdOperacion='" + getoIdOperacion() + "'" +
            ", oIdBillete='" + getoIdBillete() + "'" +
            ", oNombrePais='" + getoNombrePais() + "'" +
            "}";
    }

    
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BilletePais)) {
            return false;
        }
        BilletePais billetePais = (BilletePais) o;
        return Objects.equals(oIdOperacion, billetePais.oIdOperacion) && Objects.equals(oIdBillete, billetePais.oIdBillete) && Objects.equals(oNombrePais, billetePais.oNombrePais);
    }

    public int hashCode() {
        return Objects.hash(oIdOperacion, oIdBillete, oNombrePais);
    }


}
