package b9p2;

public class aparatos {
	private int iBombilla, iRadiador, iPlancha;
	
	public aparatos (int iBombilla, int iRadiador, int iPlancha) {
		setiBombilla(iBombilla);
		setiRadiador(iRadiador);
		setiPlancha(iPlancha);
	}

	@Override
	public String toString() {
		return "aparatos [iBombilla=" + iBombilla + ", iRadiador=" + iRadiador + ", iPlancha=" + iPlancha + "]";
	}

	public int getiBombilla() {
		return iBombilla;
	}

	public void setiBombilla(int iBombilla) {
		this.iBombilla = iBombilla;
	}

	public int getiRadiador() {
		return iRadiador;
	}

	public void setiRadiador(int iRadiador) {
		this.iRadiador = iRadiador;
	}

	public int getiPlancha() {
		return iPlancha;
	}

	public void setiPlancha(int iPlancha) {
		this.iPlancha = iPlancha;
	}
	
}
