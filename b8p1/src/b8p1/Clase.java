package b8p1;

public class Clase {

	private byte bDia;
	private byte bMes;
	private short shAnio;
	
	public Clase (byte bDia) {
		setbDia(bDia);
	}
	
	public Clase (byte bMes, short shanio) {
		setbMes(bMes);
		setshAnio(shAnio);
	}

	public byte getbDia() {
		return bDia;
	}

	public void setbDia(byte bDia) {
		this.bDia = bDia;
	}

	public byte getbMes() {
		return bMes;
	}

	public void setbMes(byte bMes) {
		this.bMes = bMes;
	}

	public short getShAnio() {
		return shAnio;
	}

	public void setshAnio(short shAnio) {
		this.shAnio = shAnio;
	}
	
	
	
	
	
}
