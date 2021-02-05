
public interface IPersona {
	public final byte bSoltero=1;
	public final byte bCasado=2;
	public final byte bSeparado=3;
	public final byte bDivorciado=4;
	public final byte bViudo=5;
	public String getsNombre();
	public void setsNombre(String sNombre);
	public String getsApellido1();
	public void setsApellido1(String sApellido1);
	public String getsApellido2();
	public void setsApellido2(String sApellido2);
	public byte getbEstado();
	public void setbEstado(byte bEstado);
	public byte getbEdad();
	public void setbEdad(byte bEdad);
	public float getfEstatura();
	public void setfEstatura(float fEstatura);
	public float getfPeso();
	public void setfPeso(float fPeso);
	
}
