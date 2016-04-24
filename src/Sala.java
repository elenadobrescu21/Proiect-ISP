
public class Sala {

	private int numar;
	private int numarLocuri;
	private int etaj;

	public Sala(int numar, int numarLocuri, int etaj) {
		this.numar = numar;
		this.numarLocuri = numarLocuri;
		this.etaj = etaj;
	}

	public int getNumar() {
		return numar;
	}

	public void setNumar(int numar) {
		this.numar = numar;
	}

	public int getNumarLocuri() {
		return numarLocuri;
	}

	public void setNumarLocuri(int numarLocuri) {
		this.numarLocuri = numarLocuri;
	}

	public int getEtaj() {
		return etaj;
	}

	public void setEtaj(int etaj) {
		this.etaj = etaj;
	}

}
