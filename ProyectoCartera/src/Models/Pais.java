package Models;

import java.util.Objects;

public class Pais {
    private String sNombrePais;

    public Pais(String sNombrePais) {
        setsNombrePais(sNombrePais);
    }

    public String getsNombrePais() {
        return this.sNombrePais;
    }

    public void setsNombrePais(String sNombrePais) {
        this.sNombrePais = sNombrePais;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pais)) {
            return false;
        }
        Pais pais = (Pais) o;
        return Objects.equals(sNombrePais, pais.sNombrePais);
    }

    public int hashCode() {
        return Objects.hashCode(sNombrePais);
    }

}
