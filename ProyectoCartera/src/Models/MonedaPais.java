package Models;

import java.util.Objects;

public class MonedaPais {
    private Operacion oIdOperacion;
    private Moneda mIdMoneda;
    private Pais pNombrePais;

    public MonedaPais(Operacion oIdOperacion, Moneda mIdMoneda, Pais pNombrePais) {
        setoIdOperacion(oIdOperacion);
        setmIdMoneda(mIdMoneda);
        setpNombrePais(pNombrePais);
    }

    public Operacion getoIdOperacion() {
        return this.oIdOperacion;
    }

    public void setoIdOperacion(Operacion oIdOperacion) {
        this.oIdOperacion = oIdOperacion;
    }

    public Moneda getmIdMoneda() {
        return this.mIdMoneda;
    }

    public void setmIdMoneda(Moneda mIdMoneda) {
        this.mIdMoneda = mIdMoneda;
    }

    public Pais getpNombrePais() {
        return this.pNombrePais;
    }

    public void setpNombrePais(Pais pNombrePais) {
        this.pNombrePais = pNombrePais;
    }

    
    public boolean equals(Object o) {
        boolean boEquals = false;
        if (this.oIdOperacion != null && this.mIdMoneda!= null&& this.pNombrePais!= null && oIdOperacion.equals(o) && mIdMoneda.equals(o) && pNombrePais.equals(o)) {
            boEquals = true;

        }
        return boEquals;

    }

    public int hashCode() {
        return Objects.hash(oIdOperacion, mIdMoneda, pNombrePais);
    }


    
    public String toString() {
        return "{" +
            " oIdOperacion='" + getoIdOperacion() + "'" +
            ", mIdMoneda='" + getmIdMoneda() + "'" +
            ", pNombrePais='" + getpNombrePais() + "'" +
            "}";
    }

    public boolean checkMonedapais() {
		boolean bExito = false;
		if (this.getmIdMoneda() !=null && this.getpNombrePais() != null) {
			bExito = true;
		}
		return bExito;
	}

}
