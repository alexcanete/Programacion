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
		if (bDia<=31) {
			this.bDia = bDia;
		}
		
	}

	public byte getbMes() {
		return bMes;
	}

	public void setbMes(byte bMes) {
		if (bMes<=12) {
			this.bMes = bMes;
		}
		
	}

	public short getShAnio() {
		return shAnio;
	}

	public void setshAnio(short shAnio) {
		this.shAnio = shAnio;
	}
	
	
	
	
	
}
