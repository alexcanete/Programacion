package b9p1;

public class reloj {
	private byte bHora, bMinutos, bSegundos;
	
	public reloj () {
		
	}
	
	public reloj (byte bHora, byte bMinutos, byte bSegundos) {
		setbHora(bHora);
		setbMinutos(bMinutos);
		setbSegundos(bSegundos);
		
	}

	@Override
	public String toString() {
		return "Son las: " + bHora + ", bMinutos=" + bMinutos + ", bSegundos=" + bSegundos + "]";
	}

	public byte getbHora() {
		return bHora;
	}

	public void setbHora(byte bHora) {
		this.bHora = bHora;
	}

	public byte getbMinutos() {
		return bMinutos;
	}

	public void setbMinutos(byte bMinutos) {
		this.bMinutos = bMinutos;
	}

	public byte getbSegundos() {
		return bSegundos;
	}

	public void setbSegundos(byte bSegundos) {
		this.bSegundos = bSegundos;
	}
}
