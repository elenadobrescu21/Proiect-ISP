
public class Persoana {

	protected String nume;
	protected String prenume;
	protected String CNP;
	protected Cont cont;

	public Persoana(String nume, String prenume, String CNP) {
		this.nume = nume;
		this.prenume = prenume;
		this.CNP = CNP;
		//relatia de compozitie-> obiectul de tip cont este creat in interiorul clasei
		this.cont = new Cont("username_default", "parola_default"); 
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
		return new Cont(this.cont.getUsername(), this.cont.getParola());
	}
	
	public String getUsername() {
		return this.cont.getUsername();
	}
	
	public String getParola() {
		return this.cont.getParola();
	}

	public void setCont(String username, String parola) {
		cont.setUsername(username);
		cont.setParola(parola);
	}
	
	public void setCont(Cont c) {
		this.cont.setUsername(c.getUsername());
		this.cont.setParola(c.getParola());
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
