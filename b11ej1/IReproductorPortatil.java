/**
 * ReproductorPortatil
 */
public interface IReproductorPortatil {

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
    
    public boolean getreproduceSonido();
    public void setreproduceSonido(boolean reproduceSonido);

    public boolean getreproduceVideo();
    public void setreproduceVideo(boolean reproduceVideo);

    public String gettipoDeAlmacenamiento();
    public void settipoDeAlmacenamiento(String tipoDeAlmacenamiento);

    public int getcapacidadDeAlmacenamiento();
    public void setcapacidadDeAlmacenamiento(int capacidadDeAlmacenamiento);

    public String getpantalla();
    public void setpantalla(String pantalla);

    public String gettipoDeBacteria();
    public void settipoDeBacteria(String tipoDeBacteria);

    public String getsMarca();
    public void setsMarca(String sMarca);

    public String getsModelo();
    public void setsModelo(String sModelo);

        

    
}