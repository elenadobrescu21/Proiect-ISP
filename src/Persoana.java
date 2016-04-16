
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

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public Cont getCont() {
		return cont;
	}

	public void setCont(Cont cont) {
		this.cont = cont;
	}
	

}
