public interface IReproductorVideo {

    public final String pantallanull="Ninguna";
    public final String txt="Texto";
    public final String monocromo="Monocromo";
    public final String color= "Color";
    public final String cd="CD";
    public final String dvd= "DVD";
    public final String memoriaflash= "MemoriaFlash";
    public final String minidisk= "Minidisk";
    public final String pilas="Pilas";
    public final String liion="Li-Ion";
    public final String WMV="WMV";
    public final String DIVX="DIVX";
    public final String MPG="MPG";
    public final String DVD="DVD";
    public final String JPG="JPG";
    
    
    public boolean getboReproduceSonido();
    public void setboReproduceSonido(boolean boReproduceSonido);

    public boolean getboReproduceVideo();
    public void setboReproduceVideo(boolean boReproduceVideo);

    public String getsTipoDeAlmacenamiento();
    public void setsTipoDeAlmacenamiento(String sTipoDeAlmacenamiento);

    public int getciCapacidadDeAlmacenamiento();
    public void setiCapacidadDeAlmacenamiento(int iCapacidadDeAlmacenamiento);

    public String getsPantalla();
    public void setsPantalla(String sPantalla);

    public String getsTipoDeBacteria();
    public void setsTipoDeBacteria(String sTipoDeBacteria);

    public String getsMarca();
    public void setsMarca(String sMarca);

    public String getsModelo();
    public void setsModelo(String sModelo);

    public byte getbAutonomia();
    public void setsbAutonomia(byte bAutonomia);    

    public float getfPeso();
    public void setfPeso(float fPeso);

    public float getfAncho();
    public void setfAncho(float fAncho);

    public float getfAlto();
    public void setfAlto(float fAlto);

    public float getfGrosor();
    public void setfGrosor(float fGrosor);

    public boolean getboReproduceWMV();
    public void setboReproduceWMV(boolean boReproduceWMV);

    public boolean getboReproduceDIVX();
    public void setboReproduceDIVX(boolean boReprodeceDIVX);

    public boolean getboReproduceMPG();
    public void setboReproduceMPG(boolean boReproduceMPG);

    public boolean getboReproduceDVD();
    public void setboReproduceDVD(boolean boReproduceDVD);

    public boolean getboReproduceJPG();
    public void setboReproduce(boolean boReproduceJPG);

    public float fTamanyoDePantalla();
    public void setfTamanyoDePantalla(float fTamanyoDePantalla);

    public boolean boTelevision();
    public void setboTelevision(boolean boTelevision);


}
