package b8p3;

public class Climatizador {
	private boolean booEncendido;
	float fTActual;
	private float fTDeseada;
	
	public Climatizador (boolean booEncendido, float fTActual, float fTDeseada) {
		setBooEncendido(booEncendido);
		setfTActual(fTActual);
		setfTDeseada(fTDeseada);
		
	}

	public boolean isBooEncendido() {
		return booEncendido;
	}

	public void setBooEncendido(boolean booEncendido) {
		this.booEncendido = booEncendido;
	}

	public float getfTActual() {
		return fTActual;
	}

	public void setfTActual(float fTActual) {
		this.fTActual = fTActual;
	}

	public float getfTDeseada() {
		return fTDeseada;
	}

	public void setfTDeseada(float fTDeseada) {
		this.fTDeseada = fTDeseada;
	}

	@Override
	public String toString() {
		return "Climatizador [booEncendido=" + booEncendido + ", fTActual=" + fTActual + ", fTDeseada=" + fTDeseada
				+ "]";
	}
	public void enfriar(float fTActual, float fTDeseada ) {
		float fTempe;
		for (fTempe = fTActual ; fTActual < fTDeseada; i++) {
			
		}
		
		
	}
}
