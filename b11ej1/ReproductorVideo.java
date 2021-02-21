public class ReproductorVideo extends ReproductorPortatil implements IReproductorVideo {
    private boolean boReproduceWMV;
    private boolean boreReproduceDIVX;
    private boolean boReproduceMPG;
    private boolean boReproduceDVD;
    private boolean boReproduceJPG;

    public ReproductorVideo(String sMarca, String sModelo, float fTamanyoDePantalla){

        super.setsMarca(sMarca);
        super.setsModelo(sModelo);
        setfTamanyoDePantalla(fTamanyoDePantalla);

    }
    
    public boolean isBoReproduceWMV() {
        return boReproduceWMV;
    }

    public void setBoReproduceWMV(boolean boReproduceWMV) {
        this.boReproduceWMV = boReproduceWMV;
    }

    public boolean isBoreReproduceDIVX() {
        return boreReproduceDIVX;
    }

    public void setBoreReproduceDIVX(boolean boreReproduceDIVX) {
        this.boreReproduceDIVX = boreReproduceDIVX;
    }

    public boolean isBoReproduceMPG() {
        return boReproduceMPG;
    }

    public void setBoReproduceMPG(boolean boReproduceMPG) {
        this.boReproduceMPG = boReproduceMPG;
    }

    public boolean isBoReproduceDVD() {
        return boReproduceDVD;
    }

    public void setBoReproduceDVD(boolean boReproduceDVD) {
        this.boReproduceDVD = boReproduceDVD;
    }

    public boolean isBoReproduceJPG() {
        return boReproduceJPG;
    }

    public void setBoReproduceJPG(boolean boReproduceJPG) {
        this.boReproduceJPG = boReproduceJPG;
    }

    @Override
    public String toString() {
        return "sMArca [sMarca=" + super.getsMarca() + ", sModelo=" + super.getsModelo() +", fTamanyoDePantalla=" + fTamanyoDePantalla()= +"]";
    }
    
}
