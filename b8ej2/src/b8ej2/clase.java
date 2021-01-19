package b8ej2;

public class clase {
private String sNombre;
private int iCodigo;
private byte bCurso;

public clase (int iCodigo) {
	setiCodigo(iCodigo);
}
public clase (String sNombre, int iCodigo, byte bCurso) {
	setsNombre(sNombre);
	setiCodigo(iCodigo);
	setbCurso(bCurso);
}
public String getsNombre() {
	return sNombre;
}
public void setsNombre(String sNombre) {
	this.sNombre = sNombre;
}
public int getiCodigo() {
	return iCodigo;
}
public void setiCodigo(int iCodigo) {
	this.iCodigo = iCodigo;
}
public byte getbCurso() {
	return bCurso;
}
public void setbCurso(byte bCurso) {
	this.bCurso = bCurso;
}
}





