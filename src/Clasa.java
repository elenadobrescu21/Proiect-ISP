import java.util.ArrayList;

public class Clasa {
	
	private String nume;
	private CadruDidactic responsabil;
	//Cicu - mai era si un arraylist de elevi in diagrama

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((responsabil == null) ? 0 : responsabil.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clasa other = (Clasa) obj;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (responsabil == null) {
			if (other.responsabil != null)
				return false;
		} else if (!responsabil.equals(other.responsabil))
			return false;
		return true;
	}
	
	

}
