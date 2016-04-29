public class Sala {

	private int nrSala;
	private int nrLocuri;
	private int etaj;

	public Sala(int nrSala, int nrLocuri, int etaj) {
		this.nrSala = nrSala;
		this.nrLocuri = nrLocuri;
		this.etaj = etaj;
	}
	
	public Sala() {
		
	}

	public int getNrSala() {
		return nrSala;
	}

	public void setNrSala(int nrSala) {
		this.nrSala = nrSala;
	}

	public int getNrLocuri() {
		return nrLocuri;
	}

	public void setNumarLocuri(int nrLocuri) {
		this.nrLocuri = nrLocuri;
	}

	public int getEtaj() {
		return etaj;
	}

	public void setEtaj(int etaj) {
		this.etaj = etaj;
	}

	// De implementat
	// public void modificaSala(){}

}
