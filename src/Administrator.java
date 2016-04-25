import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrator {
	// Grasu zicea ca ar fi mers si conturi de admin
	private ArrayList<Cont> conturiElev;
	private ArrayList<Cont> conturiCadruDidactic;
	private ArrayList<Activitate> activitati;

	public Administrator() {
		conturiElev = new ArrayList<Cont>();
		conturiCadruDidactic = new ArrayList<Cont>();
	}

	// metoda Vali
	public void adaugaActivitate() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduceti nume activitate");
		String nume = scan.nextLine();
		System.out.println("Introduceti data activitate");
		System.out.println("Ziua: ");
		int zi = scan.nextInt();
		System.out.println("Luna: ");
		int luna = scan.nextInt();
		System.out.println("An: ");
		int an = scan.nextInt();
		Data dataDesfasurare = new Data(zi, luna, an);
		System.out.println("Introduceti numar maxim de participanti:");
		int nrMaxParticipanti = scan.nextInt();
		System.out.println("Introduceti taxa: ");
		float taxa = scan.nextFloat();
		System.out.println("Introduceti termen limita inscriere: ");
		System.out.println("Ziua: ");
		int ziLimita = scan.nextInt();
		System.out.println("Luna: ");
		int lunaLimita = scan.nextInt();
		System.out.println("An: ");
		int anLimita = scan.nextInt();
		Data dataLimita = new Data(ziLimita, lunaLimita, anLimita);
		System.out.println("Ora: ");
		int ora = scan.nextInt();

		System.out.println("Alegeti tipul activitatii: ");
		System.out.println("C - concurs");
		System.out.println("S - sedinta");
		System.out.println("W - workshop");
		System.out.println("E - excursie");
		char c;
		do {
			c = scan.next().charAt(0);
		} while (c != 'c' && c != 's' && c != 'w' && c != 'e');

		// Daca e concurs
		if (c == 'c') {
			System.out.println("Activitate de tip concurs");
			System.out.println("Introduceti disciplina concurs: ");
			String disciplina = scan.nextLine();
			System.out.println("Introduceti sponsor:");
			System.out.println("Nume firma: ");
			String firmaSponsor = scan.nextLine();
			Sponsor sp = new Sponsor(firmaSponsor);
			Activitate a = new Concurs(nume, dataDesfasurare, taxa, dataLimita, nrMaxParticipanti, ora, disciplina, sp);
		}
		// De implementat:
		// sedinta/workshop/excursie

		// Cicu - Fix Bug Leak
		// Cred ca poate fi inchis si mai sus
		// Scannerul trebuie inchis dupa ce nu mai se citeste din consola/fisier
		scan.close();

	}

	public void adaugaContElev(Cont c) {
		conturiElev.add(c);

	}

	public void creareCont(Persoana p) {
		// Lista curenta de conturi
		List<Cont> lista = new ArrayList<Cont>();

		// Daca adaugi elevi, foloseste lista de elevi
		if (p instanceof Elev) {
			lista = this.conturiElev;
		}
		// Daca adaugi cadre didactice, foloseste lista de cadre
		else {
			lista = this.conturiCadruDidactic;
		}

		String nume = p.getNume();
		String prenumePersoana = p.getPrenume();
		String[] prenume = prenumePersoana.split(" ");
		String username = nume + "." + prenume[0];
		String parola = "parola";
		Cont cont = new Cont(username, parola);

		// Verificare daca exista cont de forma nume.prenume
		for (Cont c : lista) {
			if (c.getUsername().equals(cont.getUsername())) {
				int numarPrenume = prenume.length;
				if (numarPrenume > 1) {
					username = username + "_" + prenume[1];
					cont.setUsername(username);
				} else {
					String CNP = p.getCNP();
					String numbers = CNP.substring(Math.max(0, CNP.length() - 4));
					username = username + numbers;
					cont.setUsername(username);
				}

			}
		}

		lista.add(cont);
		p.setCont(cont);

	}

	/*
	 * public void creareContElev(Elev e) { String numeElev = e.getNume();
	 * String prenumeElev = e.getPrenume(); String[] prenume =
	 * prenumeElev.split(" "); String username = numeElev + "." + prenume[0];
	 * String parola = "parola"; Cont contElev = new Cont(username, parola);
	 * for(Cont c : this.conturiElev) { if
	 * (c.getUsername().equals(contElev.getUsername())) { int numarPrenume =
	 * prenume.length; if(numarPrenume > 1) { username = username + "_" +
	 * prenume[1]; contElev.setUsername(username); } else { String CNP =
	 * e.getCNP(); String numbers = CNP.substring(Math.max(0, CNP.length() -
	 * 4)); username = username + numbers; contElev.setUsername(username); }
	 * 
	 * } }
	 * 
	 * this.conturiElev.add(contElev); e.setCont(contElev); }
	 * 
	 * public void creareContCadruDidactic(CadruDidactic cd){
	 * 
	 * String numeProfesor = cd.getNume(); String prenumeProfesor =
	 * cd.getPrenume(); String[] prenume = prenumeProfesor.split(" "); String
	 * username = numeProfesor + "." + prenume[0]; String parola = "parola";
	 * Cont contProfesor = new Cont(username, parola); for(Cont c :
	 * this.conturiElev) { if
	 * (c.getUsername().equals(contProfesor.getUsername())) { int numarPrenume =
	 * prenume.length; if(numarPrenume > 1) { username = username + "_" +
	 * prenume[1]; contProfesor.setUsername(username); } else { String CNP =
	 * cd.getCNP(); String numbers = CNP.substring(Math.max(0, CNP.length() -
	 * 4)); username = username + numbers; contProfesor.setUsername(username); }
	 * 
	 * } }
	 * 
	 * this.conturiCadruDidactic.add(contProfesor); cd.setCont(contProfesor);
	 * 
	 * 
	 * 
	 * }
	 */

	// Cicu - doar o functie de verificare
	// In diagrama e doar verificareCont

	public boolean verificareContElev(Cont c) {
		boolean contExistent = false;
		for (Cont cont : this.conturiElev) {
			if (c.equals(cont)) {
				contExistent = true;
				break;
			}
		}
		return contExistent;
	}

	public boolean verificareContProfesor(Cont c) {
		boolean contExistent = false;
		for (Cont cont : this.conturiCadruDidactic) {
			if (c.equals(cont)) {
				contExistent = true;
				break;
			}
		}
		return contExistent;

	}

	/* De implementat , Modificarile poate le putem face tot intr-o functie
	
	public void modificareDateElev() {

	}

	public void modificareDateCadruD() {

	}

	public void cautaActivitate() {

	}
	*/

}
