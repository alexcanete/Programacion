public interface IReproductorAudio{
    public final String sPantallanull="Ninguna";
    public final String sTxt="Texto";
    public final String sMonocromo="Monocromo";
    public final String sColor= "Color";
    public final String sCd="CD";
    public final String sDvd= "DVD";
    public final String sMemoriaflash= "MemoriaFlash";
    public final String sMinidisk= "Minidisk";
    public final String sPilas="Pilas";
    public final String sLiion="Li-Ion";
    
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

    public boolean getboReproduceAudioCDs();
    public void setboReproduceAudioCDs(boolean boReproduceAudioCDs);

    public boolean getboReproduceMP3();
    public void setboReproduceMP3(boolean boReproduceMP3);

    public boolean getboReproduWMA();
    public void setboReproduWMA(boolean boReproduceWMA);

    public boolean getboReproduceVorbis();
    public void setboReproduceVorbis(boolean boReproduceVorbis);

    public boolean getboAccesoPorCarpetas();
    public void setboAccesoPorCarpetas(boolean boAccesoPorCarpetas);

    public boolean getboRadio();
    public void setboRadio(boolean boRadio);

    public boolean getboGrabacionDeVoz();
    public void setboGrabacionDeVoz(boolean boGrabacioDeVoz);

    


}