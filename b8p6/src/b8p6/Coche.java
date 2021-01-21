package b8p6;

public class Coche {

	private String sModelo, sColor, sTipo, sSeguro, sMatricula;
	private short shAnio;
	private boolean boMetalizada;
	
	public Coche (String sModelo, String sColor, String sTipo, String sSeguro, String sMatricula, short shAnio, boolean boMetalizado){
		
		
	}

	public String getsModelo() {
		return sModelo;
	}

	public void setsModelo(String sModelo) {
		this.sModelo = sModelo;
	}

	public String getsColor() {
		return sColor;
	}

	public void setsColor(String sColor) {
		this.sColor = sColor;
	}

	public String getsTipo() {
		return sTipo;
	}

	public void setsTipo(String sTipo) {
		this.sTipo = sTipo;
	}

	public String getsSeguro() {
		return sSeguro;
	}

	public void setsSeguro(String sSeguro) {
		this.sSeguro = sSeguro;
	}

	public String getsMatricula() {
		return sMatricula;
	}

	public void setsMatricula(String sMatricula) {
		this.sMatricula = sMatricula;
	}

	public short getShAnio() {
		return shAnio;
	}

	public void setShAnio(short shAnio) {
		this.shAnio = shAnio;
	}

	public boolean isBoMetalizada() {
		return boMetalizada;
	}

	public void setBoMetalizada(boolean boMetalizada) {
		this.boMetalizada = boMetalizada;
	}
}
