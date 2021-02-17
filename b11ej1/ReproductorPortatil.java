public class ReproductorPortatil implements IReproductorPortatil{
    private String sMarca, sModelo, sTipoDeAlmacenamiento, sCapacidadDeAlmacenamiento, sPantalla, sTipoDeBacteria;
    private boolean boReproduceSonido, boReproduceVideo;
    private byte bAutonomia;
    private float fPeso, fAncho, fAlto, fGrosor;  
    private int iCapacidadDeAlmacenamiento;  


    public ReproductorPortatil(String sMarca, String sModelo, String sTipoDeAlmacenamiento){
        setsMarca(sMarca);
        setsModelo(sModelo);
        setsTipoDeAlmacenamiento(sTipoDeAlmacenamiento);

    }

    @Override
    public boolean getboReproduceSonido() {
        return boReproduceSonido;
    }

    @Override
    public void setboReproduceSonido(boolean boReproduceSonido) {
        this.boReproduceSonido = boReproduceSonido;

    }

    @Override
    public boolean getboReproduceVideo() {
        return boReproduceVideo;
    }

    @Override
    public void setboReproduceVideo(boolean boReproduceVideo) {
        this.boReproduceSonido = boReproduceSonido;

    }

    @Override
    public String getsTipoDeAlmacenamiento() {
        return sTipoDeAlmacenamiento;
    }

    @Override
    public void setsTipoDeAlmacenamiento(String sTipoDeAlmacenamiento) {
        this.sTipoDeAlmacenamiento= sTipoDeAlmacenamiento;

    }

    @Override
    public int getciCapacidadDeAlmacenamiento() {
        return iCapacidadDeAlmacenamiento;
    }

    @Override
    public void setiCapacidadDeAlmacenamiento(int iCapacidadDeAlmacenamiento) {
        this.iCapacidadDeAlmacenamiento= iCapacidadDeAlmacenamiento;

    }

    @Override
    public String getsPantalla() {
        return sPantalla;
    }

    @Override
    public void setsPantalla(String sPantalla) {
        this.sPantalla = sPantalla;
    }

    @Override
    public String getsTipoDeBacteria() {
        return sTipoDeBacteria;
    }

    @Override
    public void setsTipoDeBacteria(String sTipoDeBacteria) {
        this.sTipoDeBacteria = sTipoDeBacteria;

    }

    @Override
    public String getsMarca() {
        return sMarca;
    }

    @Override
    public void setsMarca(String sMarca) {
        this.sMarca = sMarca;
    }

    @Override
    public String getsModelo() {
        return sModelo;
    }

    @Override
    public void setsModelo(String sModelo) {
       this.sModelo= sModelo;

    }

    @Override
    public byte getbAutonomia() {
        return bAutonomia;
    }

    @Override
    public void setsbAutonomia(byte bAutonomia) {
        this.bAutonomia = bAutonomia;

    }

    @Override
    public float getfPeso() {
        return fPeso;
    }

    @Override
    public void setfPeso(float fPeso) {
        this.fPeso = fPeso;

    }

    @Override
    public float getfAncho() {
        return fAncho;
    }

    @Override
    public void setfAncho(float fAncho) {
        this.fAncho= fAncho;

    }

    @Override
    public float getfAlto() {
        return fAlto;
    }

    @Override
    public void setfAlto(float fAlto) {
        this.fAlto= fAlto;

    }

    @Override
    public float getfGrosor() {
        return fGrosor;
    }

    @Override
    public void setfGrosor(float fGrosor) {
        this.fGrosor= fGrosor;

    }
    
	}