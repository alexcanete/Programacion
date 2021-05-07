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
        Pais pPais = (Pais) o;
        boolean boEquals = false;
        if (pPais!= null && this.getsNombrePais().equals(pPais.getsNombrePais())) {
            boEquals = true;
        }
        return boEquals;

    }

    public int hashCode() {
        return Objects.hashCode(sNombrePais);
    }

    public boolean checkPais() {
		boolean bExito = false;
		if (this.getsNombrePais() != null) {
			bExito = true;
		}
		return bExito;
	}
}
