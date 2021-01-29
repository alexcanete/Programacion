package b9ej2;

public class Persona {
	private String sNombre, sApellido1, sApellido2;
	private byte bEdad, bEstado;
	private float fEstatura, fPeso;
	
	
	public Persona(String sNombre, String sApellido1, String sApellido2, byte bEdad, float fEstatura, float fPeso,byte bEstado) {
		setsNombre(sNombre);
		setsApellido1(sApellido1);
		setsApellido2(sApellido2);
		setbEdad(bEdad);
		setfEstatura(fEstatura);
		setfPeso(fPeso);
		setbEstado(bEstado);
	}
	
	public Persona(String sNombre, String sApellido1, String sApellido2) {
		setsNombre(sNombre);
		setsApellido1(sApellido1);
		setsApellido2(sApellido2);
	}


	public String getsNombre() {
		return sNombre;
	}


	private void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}


	public String getsApellido1() {
		return sApellido1;
	}


	private void setsApellido1(String sApellido1) {
		this.sApellido1 = sApellido1;
	}


	public String getsApellido2() {
		return sApellido2;
	}


	private void setsApellido2(String sApellido2) {
		this.sApellido2 = sApellido2;
	}


	public byte getbEstado() {
		return bEstado;
	}


	public void setbEstado(byte bEstado) {
		if (this.bEstado==1) {
			if (bEstado==2) {
				this.bEstado = bEstado;
			}
		}else if (this.bEstado== 2) {
			if (bEstado !=1) {
				this.bEstado = bEstado;
			}
		}else if (this.bEstado== 3) {
			if (bEstado== 4 || bEstado== 5) {
				this.bEstado = bEstado;
			}
		}else if (this.bEstado==4) {
			if (bEstado== 2) {
				this.bEstado = bEstado;
			}
		}else {
			if (bEstado==2) {
				this.bEstado = bEstado;
			}
		}
		
	}


	public byte getbEdad() {
		return bEdad;
	}


	public void setbEdad(byte bEdad) {
		if (this.bEdad >= 0 & this.bEdad <=150) {
			this.bEdad = bEdad;
		}
		
	}


	public float getfEstatura() {
		return fEstatura;
	}


	public void setfEstatura(float fEstatura) {
		if (this.fEstatura >=0.0 & this.fEstatura <= 3.0) {
			this.fEstatura = fEstatura;
		}
		
	}


	public float getfPeso() {
		return fPeso;
	}


	public void setfPeso(float fPeso) {
		if (this.fPeso >=0.0 & this.fPeso <=300.0) {
			this.fPeso = fPeso;
		}
		
	}
	


	
}

