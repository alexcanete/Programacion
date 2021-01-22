package b8p4;

public class MaquinaExpendedora {
	boolean booMoneda;
	int iNumeroSerie;
	float fCreditoAcumuladoUsuario, fCreditoConsumidoUsuario, fDineroMaquina, fMoneda;
	
	public MaquinaExpendedora(int iNumeroSerie, float fMoneda, float fCreditoAcumuladoUsuario, float fCreditoConsumidoUsuario, float fDineroMaquina) {
		setiNumeroSerie(iNumeroSerie);
		setfMoneda(fMoneda);
		setfCreditoAcumuladoUsuario(fCreditoAcumuladoUsuario);
		setfCreditoConsumidoUsuario(fCreditoConsumidoUsuario);
		setfDineroMaquina(fDineroMaquina);
		
		
	
	}

	public int getiNumeroSerie() {
		return iNumeroSerie;
	}

	public void setiNumeroSerie(int iNumeroSerie) {
		this.iNumeroSerie = iNumeroSerie;
	}

	public float getfCreditoAcumuladoUsuario() {
		return fCreditoAcumuladoUsuario;
	}

	public void setfCreditoAcumuladoUsuario(float fCreditoAcumuladoUsuario) {
		this.fCreditoAcumuladoUsuario = fCreditoAcumuladoUsuario;
	}

	public float getfCreditoConsumidoUsuario() {
		return fCreditoConsumidoUsuario;
	}

	public void setfCreditoConsumidoUsuario(float fCreditoConsumidoUsuario) {
		this.fCreditoConsumidoUsuario = fCreditoConsumidoUsuario;
	}

	public float getfDineroMaquina() {
		return fDineroMaquina;
	}

	public void setfDineroMaquina(float fDineroMaquina) {
		this.fDineroMaquina = fDineroMaquina;
	}

	public float getfMoneda() {
		return fMoneda;
	}

	public void setfMoneda(float fMoneda) {
		this.fMoneda = fMoneda;
	}

	@Override
	public String toString() {
		return "MaquinaExpendedora [iNumeroSerie=" + iNumeroSerie
				+ ", fCreditoAcumuladoUsuario=" + fCreditoAcumuladoUsuario + ", fCreditoConsumidoUsuario="
				+ fCreditoConsumidoUsuario + ", fDineroMaquina=" + fDineroMaquina + ", fMoneda=" + fMoneda + "]";
	}
	
	public boolean moneda(float fMoneda) {
		boolean booMoneda=false;
		if (fMoneda>0) {
			booMoneda= true;
		}
		return booMoneda;
	}
	public void imprimeMoneda() {
		if (booMoneda= true) {
			System.out.println("Ha introducido una moneda de "+this.getfMoneda()+" euros." );
		}
	}
	
	
}
