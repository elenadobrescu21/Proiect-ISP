import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrator {
	private ArrayList<Cont> conturiElev;
	private ArrayList<Cont> conturiCadruDidactic;
	//Toate activitatile posibile
	private ArrayList<Activitate> activitati;
	private Cont cont;

	public Administrator() {
		this.conturiElev = new ArrayList<Cont>();
		this.conturiCadruDidactic = new ArrayList<Cont>();
		this.activitati = new ArrayList<Activitate>();
		cont = new Cont("admin", "admin");
	}
	
	public void adaugaActivitate(Activitate a) {
		this.activitati.add(a);
	}
	
	public ArrayList<Activitate> getActivitati() {
		return activitati;
	}

	public void setActivitati(ArrayList<Activitate> activitati) {
		this.activitati = activitati;
	}

	// metoda Vali
	public void adaugaActivitate(List<Sponsor> sponsori, List<Sala> sali, List<Clasa> clase ) { 
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
			System.out.println("Introduceti nr sala: ");
			int sala = scan.nextInt();
			Sala salaConcurs = new Sala();
			for(Sala s : sali) {
				if(s.getNrSala() == sala) {
					salaConcurs = s;
					break;					
				}
			}
			Sponsor sp = new Sponsor(firmaSponsor);
			Concurs concurs = new Concurs(nume, dataDesfasurare, taxa, dataLimita, nrMaxParticipanti, ora, disciplina, sp, salaConcurs);
			sp.adaugaActivitateSponsorizata(concurs);
			sponsori.add(sp);
			this.activitati.add(concurs);
		}
		
		if(c == 's') {
			System.out.println("Activitate de tip sedinta");
			System.out.println("Introducei clasa: ");
			String numeClasa = scan.nextLine();
			System.out.println("Introduceti nr sala: ");
			int sala = scan.nextInt();
			Sala salaSedinta= new Sala();
			for(Sala s : sali) {
				if(s.getNrSala() == sala) {
					salaSedinta = s;
					break;					
				}
			}
			for(Clasa cls:clase) {
				if(cls.getNume().equals(numeClasa)) {
					Sedinta s = new Sedinta(nume, dataDesfasurare, taxa, dataLimita,nrMaxParticipanti, ora, cls);
					this.activitati.add(s);
					break;
				}
			}		
		}
		
		if(c == 'w') {
			System.out.println("Activitate de tip workshop");
			System.out.println("Introduceti tematica: ");
			String tematica = scan.nextLine();
			System.out.println("Introduceti nr sala: ");
			int sala = scan.nextInt();
			Sala salaWorkshop = new Sala();
			for(Sala s : sali) {
				if(s.getNrSala() == sala) {
					salaWorkshop = s;
					break;					
				}
			}
			Workshop w = new Workshop(nume, dataDesfasurare, taxa, dataLimita, nrMaxParticipanti, ora, tematica, salaWorkshop);	
			this.activitati.add(w);
		}
		
		if(c == 'e') {
			System.out.println("Activitate de tip excursie");
			System.out.println("Cate obiective turistice se vor vizita?");
			int nrObiective = scan.nextInt();
			ArrayList<ObiectivTuristic> obiective = new ArrayList<ObiectivTuristic>(nrObiective);
			for(int i = 0; i < nrObiective; i++) {
				Scanner scan6 = new Scanner(System.in);
				System.out.println("Nume obiectiv: ");
				String numeObiectiv = scan6.nextLine();
				System.out.println("Locatie: ");
				String locatie = scan6.nextLine();
				obiective.add(new ObiectivTuristic(numeObiectiv, locatie));
				
			}
			Excursie e = new Excursie(nume, dataDesfasurare, taxa, dataLimita, nrMaxParticipanti, ora, obiective);
			this.activitati.add(e);
		}
		
		// Cicu - Fix Bug Leak
		// Cred ca poate fi inchis si mai sus
		// Scannerul trebuie inchis dupa ce nu mai se citeste din consola/fisier
		//scan.close();

	}

	public void adaugaContElev(Cont c) {
		conturiElev.add(c);

	}
  /*
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

	} */

	public void creareContElev(Elev e) {
		String numeElev = e.getNume();
		String prenumeElev = e.getPrenume();
		String[] prenume = prenumeElev.split(" ");
		String username = numeElev + "." + prenume[0];
		String parola = "parola";
		Cont contElev = new Cont(username, parola);
		for (Cont c : this.conturiElev) {
			if (c.getUsername().equals(contElev.getUsername())) {
				int numarPrenume = prenume.length;
				if (numarPrenume > 1) {
					username = username + "_" + prenume[1];
					contElev.setUsername(username);
				} else {
					String CNP = e.getCNP();
					String numbers = CNP.substring(Math.max(0, CNP.length() - 4));
					username = username + numbers;
					contElev.setUsername(username);
				}

			}
		}

		this.conturiElev.add(contElev);
		e.setCont(contElev);
	}

	public void creareContCadruDidactic(CadruDidactic cd) {

		String numeProfesor = cd.getNume();
		String prenumeProfesor = cd.getPrenume();
		String[] prenume = prenumeProfesor.split(" ");
		String username = numeProfesor + "." + prenume[0];
		String parola = "parola";
		Cont contProfesor = new Cont(username, parola);
		for (Cont c : this.conturiElev) {
			if (c.getUsername().equals(contProfesor.getUsername())) {
				int numarPrenume = prenume.length;
				if (numarPrenume > 1) {
					username = username + "_" + prenume[1];
					contProfesor.setUsername(username);
				} else {
					String CNP = cd.getCNP();
					String numbers = CNP.substring(Math.max(0, CNP.length() - 4));
					username = username + numbers;
					contProfesor.setUsername(username);
				}

			}
		}

		this.conturiCadruDidactic.add(contProfesor);
		cd.setCont(contProfesor);

	}
	

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

	 //De implementat , Modificarile poate le putem face tot intr-o functie
	
	//am considerat ca pentru un elev se poate modifica doar clasa
	public void modificareDateElev(Clasa clasa, List<Elev> listaElevi, String numeElev, String prenumeElev) {
		for(Elev e : listaElevi) {
			if(e.getNume().equals(numeElev)&& e.getPrenume().equals(prenumeElev)) {
				e.setClasa(clasa);
			}
		}
	}

	//am considerat ca isi poate modifica doar numele
	public void modificareDateCadruD(List<CadruDidactic> profesori, String numeActual, String prenume, String numeNou) {
		for(CadruDidactic c : profesori) {
			if(c.getNume().equals(numeActual) && c.getPrenume().equals(prenume)) {
				c.setNume(numeNou);
			}
		}

	}

	public void cautaActivitate() {

	}

	public ArrayList<Cont> getConturiElev() {
		return conturiElev;
	}

	public void setConturiElev(ArrayList<Cont> conturiElev) {
		this.conturiElev = conturiElev;
	}

	public ArrayList<Cont> getConturiCadruDidactic() {
		return conturiCadruDidactic;
	}

	public void setConturiCadruDidactic(ArrayList<Cont> conturiCadruDidactic) {
		this.conturiCadruDidactic = conturiCadruDidactic;
	}

	public Cont getCont() {
		return cont;
	}

	public void setCont(Cont cont) {
		this.cont = cont;
	}
	
}
