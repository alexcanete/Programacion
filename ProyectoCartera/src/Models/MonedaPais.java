package Models;

import java.util.Objects;

public class MonedaPais {
    private Operacion oIdOperacion;
    private Moneda oIdMoneda;
    private Pais oNombrePais;



    public Operacion getoIdOperacion() {
        return this.oIdOperacion;
    }

    public void setoIdOperacion(Operacion oIdOperacion) {
        this.oIdOperacion = oIdOperacion;
    }

    public Moneda getoIdMoneda() {
        return this.oIdMoneda;
    }

    public void setoIdMoneda(Moneda oIdMoneda) {
        this.oIdMoneda = oIdMoneda;
    }

    public Pais getoNombrePais() {
        return this.oNombrePais;
    }

    public void setoNombrePais(Pais oNombrePais) {
        this.oNombrePais = oNombrePais;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MonedaPais)) {
            return false;
        }
        MonedaPais monedaPais = (MonedaPais) o;
        return Objects.equals(oIdOperacion, monedaPais.oIdOperacion) && Objects.equals(oIdMoneda, monedaPais.oIdMoneda) && Objects.equals(oNombrePais, monedaPais.oNombrePais);
    }


    public int hashCode() {
        return Objects.hash(oIdOperacion, oIdMoneda, oNombrePais);
    }
    
}
