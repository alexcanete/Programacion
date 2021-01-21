package b8p1;

public class Clase {

	private byte bDia, bMes;
	private short shAnio;
	
	public Clase (byte bDia, byte bMes, short shAnio) {
		setshAnio(shAnio);
		setbMes(bMes);
		setbDia(bDia);
	}

	public byte getbDia() {
		return bDia;
	}

	public void setbDia(byte bDia) {
		if(boBisiesto(this.getShAnio()) && this.getbMes() == 2) {
			if(bDia < 30) {
				this.bDia = bDia;
			}
		}
		else if(!boBisiesto(this.getShAnio()) && this.getbMes() == 2) {
			if(bDia < 29) {
				this.bDia = bDia;
			}
		}
		else {
			if(this.getbMes() % 2 != 0 && this.getbMes() <= 7) {
				if(bDia < 32) {
					this.bDia = bDia;
				}
			}
			else if(this.getbMes() % 2 == 0 && this.getbMes() > 7) {
				if(bDia < 32) {
					this.bDia = bDia;
				}
			}
			else if(this.getbMes() % 2 == 0 && this.getbMes() < 7) {
				if(bDia < 31) {
					this.bDia = bDia;
				}
			}
			else if(this.getbMes() % 2 != 0 && this.getbMes() > 7) {
				if(bDia < 31) {
					this.bDia = bDia;
				}
			}
		}
	}

	public byte getbMes() {
		return bMes;
	}

	public void setbMes(byte bMes) {
		if (bMes > 0 && bMes<=12) {
			this.bMes = bMes;
		}
	}

	public short getShAnio() {
		return shAnio;
	}

	public void setshAnio(short shAnio) {
		if(shAnio >= 0) {
			this.shAnio = shAnio;
		}
	}
	
	public boolean boBisiesto(short shAnio){
		boolean boBisiesto=false;
		if ((shAnio % 4 == 0 && shAnio % 100 != 0) || (shAnio % 100 == 0 && shAnio % 400 == 0)) {
			boBisiesto= true;
		}
		return boBisiesto;
	}
	
		
	

	
	public String toString() {
		return "Es el " + this.getbDia() + " del " + this.getbMes() + " del año " + this.getShAnio() ;
	}
}
	
	
	
	
	
	

