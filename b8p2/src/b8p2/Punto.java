package b8p2;

public class Punto {

	private double dX, dY;
	
	public Punto () {
		setdX(dX);
		setdY(dY);
	}
	public Punto (double dX, double dY) {
		setdX(dX);
		setdY(dY);
	}

	public void borrar() {
		setdX(0);
		setdY(0);
	}
	
	public void mover(double dX, double dY) {
		this.dX= dX;
		this.dY= dY;
	}
	
	public void mover(Punto punto) {
		this.dX= punto.getdX();
		this.dY= punto.getdY();
	}
	
	public double getdX() {
		return dX;
	}

	public void setdX(double dX) {
		this.dX = dX;
	}

	public double getdY() {
		return dY;
	}

	public void setdY(double dY) {
		this.dY = dY;
	}

	
	
	@Override
	public String toString() {
		return "Punto [dX=" + dX + ", dY=" + dY + "]";
	}
}
