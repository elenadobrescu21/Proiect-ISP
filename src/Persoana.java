
public class Persoana {

	private String nume;
	private String prenume;
	private String CNP;
	private Cont cont;

	public Persoana(String nume, String prenume, String CNP) {
		this.nume = nume;
		this.prenume = prenume;
		this.CNP = CNP;
	}
	
	public Persoana() {
		
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String CNP) {
		this.CNP = CNP;
	}

	public Cont getCont() {
		return cont;
	}

	public void setCont(Cont cont) {
		this.cont = cont;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CNP == null) ? 0 : CNP.hashCode());
		result = prime * result + ((cont == null) ? 0 : cont.hashCode());
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((prenume == null) ? 0 : prenume.hashCode());
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
		Persoana other = (Persoana) obj;
		if (CNP == null) {
			if (other.CNP != null)
				return false;
		} else if (!CNP.equals(other.CNP))
			return false;
		if (cont == null) {
			if (other.cont != null)
				return false;
		} else if (!cont.equals(other.cont))
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (prenume == null) {
			if (other.prenume != null)
				return false;
		} else if (!prenume.equals(other.prenume))
			return false;
		return true;
	}
	
	

}
