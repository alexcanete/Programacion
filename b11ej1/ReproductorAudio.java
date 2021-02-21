public class ReproductorAudio implements IReproductorAudio extends ReproductorPortatil{
    private boolean boReproduceAudioCDs;
    private boolean boReproduceMp3;
    private boolean boReproduceWMA;
    private boolean boReproduceVorbis;

    public ReproductorAudio(boolean boReproduceAudioCDs, boolean boReproduceMp3, boolean boReproduceWMA, boolean boReproduceVorbis){
        setBoReproduceAudioCDs(boReproduceAudioCDs);
        setBoReproduceMp3(boReproduceMp3);
        setBoReproduceWMA(boReproduceWMA);
        setBoReproduceVorbis(boReproduceVorbis);
        
    }


	public boolean isBoReproduceAudioCDs() {
		return boReproduceAudioCDs;
	}
	public void setBoReproduceAudioCDs(boolean boReproduceAudioCDs) {
		this.boReproduceAudioCDs = boReproduceAudioCDs;
	}
	public boolean isBoReproduceMp3() {
		return boReproduceMp3;
	}
	public void setBoReproduceMp3(boolean boReproduceMp3) {
		this.boReproduceMp3 = boReproduceMp3;
	}
	public boolean isBoReproduceWMA() {
		return boReproduceWMA;
	}
	public void setBoReproduceWMA(boolean boReproduceWMA) {
		this.boReproduceWMA = boReproduceWMA;
	}
	public boolean isBoReproduceVorbis() {
		return boReproduceVorbis;
	}
	public void setBoReproduceVorbis(boolean boReproduceVorbis) {
		this.boReproduceVorbis = boReproduceVorbis;
	}
    
}
