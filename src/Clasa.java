import java.util.ArrayList;

public class Clasa {
	private String nume;
	private CadruDidactic responsabil;

	public Clasa(String nume, CadruDidactic responsabil) {
		this.nume = nume;
		this.responsabil = responsabil;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public CadruDidactic getResponsabil() {
		return responsabil;
	}

	public void setResponsabil(CadruDidactic responsabil) {
		this.responsabil = responsabil;
	}

}
