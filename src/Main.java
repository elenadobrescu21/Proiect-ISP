import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int alegereTipCont() {
		int tipCont;
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("Alegeti tipul de cont cu care doriti sa va logati");
			System.out.println("1 - cont de cadru didactic");
			System.out.println("2 - cont de elev");
			System.out.println("3 - administrator");
			System.out.println("4 - secretara");
			System.out.println("5 - sponsor");
			System.out.println("6 - parinte");

			tipCont = s.nextInt();
		} while (tipCont != 1 && tipCont != 2 && tipCont != 3 && tipCont != 4 && tipCont != 5 && tipCont != 6);

		return tipCont;

	}

	public static void logareParinte(List<Parinte> parinti, List<Sedinta> activitati) {
		Scanner scan6 = new Scanner(System.in);
		System.out.println("Cont de parinte");
		String parolaParinte = "";
		String usernameParinte = "";
		boolean logat = false;
		boolean userExistent = false;
		Parinte parinteLogat = new Parinte();
		do {
			System.out.println("Introduceti username");
			usernameParinte = scan6.nextLine();
			for (Parinte p : parinti) {
				if (p.getCont().getUsername().equals(usernameParinte)) {
					userExistent = true;
					parinteLogat = p;
					break;
				}
			}
			System.out.println("Introduceti parola");
			parolaParinte = scan6.nextLine();
		} while (userExistent == false && parolaParinte.equals("parola") == false);
		parinteLogat.vizualizareSedinte(activitati);

	}

	public static void logareSecretara(Secretara secretara, List<Elev> listaElevi, List<CadruDidactic> listaProfesori) {
		Scanner s = new Scanner(System.in);
		System.out.println("Cont de secretara");
		String parolaSecretara = "";
		String usernameSecretara = "";
		boolean logat = false;
		do {
			System.out.println("Introduceti username");
			usernameSecretara = s.nextLine();
			System.out.println("Introduceti parola");
			parolaSecretara = s.nextLine();
		} while (usernameSecretara.equals("secretara") == false && parolaSecretara.equals("secretara") == false);
		logat = true;
		System.out.println("1 - Vizualizare date despre un elev");
		System.out.println("2 - Vizualizare date despre un cadru didactic");
		do {
			int alegere;
			do {
				System.out.println("Alegeti optiunea");
				alegere = s.nextInt();
			} while (alegere != 1 && alegere != 2);
			if (alegere == 1) {
				String numeElev = "";
				String prenumeElev = "";
				Scanner scan = new Scanner(System.in);
				System.out.println("Nume elev:");
				numeElev = scan.nextLine();
				System.out.println("Prenume elev:");
				prenumeElev = scan.nextLine();
				secretara.vizualizareDateElev(listaElevi, numeElev, prenumeElev);
				// scan.close();
			}
			if (alegere == 2) {
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Nume profesor: ");
				String numeProfesor = scan3.nextLine();
				System.out.println("Prenume profesor");
				String prenumeProfesor = scan3.nextLine();
				secretara.vizualizareDateCadruDidactic(listaProfesori, numeProfesor, prenumeProfesor);
			}
			System.out.println("Doriti sa va delogati? da/nu");
			Scanner scan2 = new Scanner(System.in);
			String raspuns = "";
			raspuns = scan2.nextLine();

			if (raspuns.equals("da")) {
				logat = false;
			}
		} while (logat == true);
	}

	public static void logareSponsor(List<Sponsor> sponsori) {
		Scanner scan5 = new Scanner(System.in);
		System.out.println("Cont de sponsor");
		String parolaSponsor = "";
		String usernameSponsor = "";
		boolean logat = false;
		boolean userExistent = false;
		Sponsor sponsorLogat = new Sponsor();
		do {
			System.out.println("Introduceti username");
			usernameSponsor = scan5.nextLine();
			for (Sponsor sp : sponsori) {
				if (sp.getFirma().equals(usernameSponsor)) {
					userExistent = true;
					sponsorLogat = sp;
					break;
				}
			}
			System.out.println("Introduceti parola");
			parolaSponsor = scan5.nextLine();
		} while (userExistent == false && parolaSponsor.equals("sponsor") == false);
		sponsorLogat.veziActivitatiSponsorizate();

	}

	public static void logareCadruDidactic(List<Elev> elevi, Administrator admin, List<CadruDidactic> profesori) {
		System.out.println("Cont de cadru didactic");
		List<Cont> conturiProfesori = new ArrayList<Cont>();
		Cont contTastatura;
		CadruDidactic profesorLogat = new CadruDidactic();
		conturiProfesori = admin.getConturiCadruDidactic();
		Scanner scan = new Scanner(System.in);
		boolean logat = false;
		do {
			System.out.println("Introduceti username");
			String usernameProfesor = scan.nextLine();
			System.out.println("Introduceti parola: ");
			String parolaProfesor = scan.nextLine();

			contTastatura = new Cont(usernameProfesor, parolaProfesor);
			for (Cont cont : conturiProfesori) {
				if (cont.equals(contTastatura)) {
					logat = true;
				}
			}
		} while (logat == false);

		for (CadruDidactic c : profesori) {
			if (c.getCont().equals(contTastatura)) {
				profesorLogat = c;
			}
		}
		System.out.println("Activitati coordonate");
		profesorLogat.veziActivitatiCoordonate();
		System.out.println("Doriti sa vizualizati date despre un elev?da/nu");
		String raspuns = scan.nextLine();
		if (raspuns.equals("da")) {
			System.out.println("Nume elev:");
			String numeElev = scan.nextLine();
			System.out.println("Prenume elev:");
			String prenumeElev = scan.nextLine();
			profesorLogat.veziDetaliiElev(numeElev, prenumeElev, elevi);
		}

	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		/*
		 * Cicu - ma incurca acum Elev e1 = new Elev("Dobrescu", "Elena",
		 * "2940621460044", 600); Elev e2 = new Elev("Bolboaca", "valeria",
		 * "2940621460046", 700); Elev e3 = new Elev("Cicu", "Alexandru",
		 * "1940621460044", 780);
		 * 
		 * List<Elev> listaElevi = new ArrayList<Elev>(); List<CadruDidactic>
		 * listaProfesori = new ArrayList<CadruDidactic>(); List<Sponsor>
		 * sponsori = new ArrayList<Sponsor>(); List<Clasa> clase = new
		 * ArrayList<Clasa>(); List<Sala> sali = new ArrayList<Sala>();
		 * List<Parinte> parinti = new ArrayList<Parinte>(); List<Sedinta>
		 * sedinte = new ArrayList<Sedinta>(); Secretara secretara = new
		 * Secretara("Voiculescu", "Monica","2840621460046" );
		 * 
		 * Sala s1 = new Sala(12, 50, 1); Sala s2 = new Sala(10, 50, 1); Sala s3
		 * = new Sala(11, 50, 1);
		 * 
		 * sali.add(s1); sali.add(s2); sali.add(s3);
		 * 
		 * CadruDidactic c1 = new CadruDidactic("Popescu", "Ioana",
		 * "2940621460043"); CadruDidactic c2 = new CadruDidactic("Ionescu",
		 * "Andreea", "2940621460042"); CadruDidactic c3 = new
		 * CadruDidactic("Popescu", "Andrei", "1940621460042");
		 * 
		 * Clasa cls = new Clasa("8A", c1); Clasa cls2 = new Clasa("7A", c2);
		 * Clasa cls3 = new Clasa("6A", c3);
		 * 
		 * Sponsor sp1 = new Sponsor("intel"); Sponsor sp2 = new Sponsor("ibm");
		 * 
		 * Parinte p1 = new Parinte("dobrescu", "steliana","2610621460044",
		 * cls);
		 * 
		 * parinti.add(p1);
		 * 
		 * e1.setClasa(cls); e2.setClasa(cls2); e3.setClasa(cls3);
		 * 
		 * listaElevi.add(e1); listaElevi.add(e2); listaElevi.add(e3);
		 * 
		 * listaProfesori.add(c1); listaProfesori.add(c2);
		 * listaProfesori.add(c3);
		 * 
		 * clase.add(cls); clase.add(cls2); clase.add(cls3);
		 * 
		 * sponsori.add(sp1); sponsori.add(sp2);
		 * 
		 * 
		 * Administrator admin = new Administrator(); admin.creareContElev(e1);
		 * admin.creareContElev(e2); admin.creareContElev(e3);
		 * 
		 * admin.creareContCadruDidactic(c1); admin.creareContCadruDidactic(c2);
		 * admin.creareContCadruDidactic(c3);
		 * 
		 * //creare concurs Data dataConcurs = new Data(25, 5, 2016); Data
		 * termenInscriereConcurs = new Data(23, 5, 2016);
		 * 
		 * Concurs concurs = new Concurs("Cangurul", dataConcurs, 10,
		 * termenInscriereConcurs, 50, 8, "matematica", sp1, s1);
		 * concurs.setResponsabil(c1);
		 * 
		 * //creare sedinta Data dataSedinta = new Data(21, 5, 2016); Data
		 * termenLimita = new Data(20, 5, 2015); Sedinta sedinta = new Sedinta(
		 * "Sedinta 8A", dataSedinta,0, termenLimita, 30, 17, cls,s1);
		 * sedinta.asigneazaResponsabil(clase); sedinte.add(sedinta);
		 * 
		 * //creare excursie ArrayList<ObiectivTuristic> obiective = new
		 * ArrayList<ObiectivTuristic>(); Data dataExcursie = new Data(1, 6,
		 * 2016); Data termenLimitaExcursie = new Data(29, 5, 2016);
		 * obiective.add(new ObiectivTuristic("Castelul Peles", "Sinaia"));
		 * obiective.add(new ObiectivTuristic("Castelul Pelisor", "Sinaia"));
		 * 
		 * Excursie excursie = new Excursie("Excursie la Sinaia", dataExcursie,
		 * 120, termenLimitaExcursie, 50, 8, obiective);
		 * excursie.asigneazaResponsabil(c2);
		 * 
		 * //creare workshop Data dataWorkshop = new Data(27, 5, 2016); Data
		 * termenLimitaWorkshop = new Data(25, 5, 2016); Workshop workshop = new
		 * Workshop("Workshop HTML", dataWorkshop, 0, termenLimitaWorkshop, 20,
		 * 15, "HTML", s2); workshop.asigneazaResponsabil(c3);
		 * 
		 * admin.adaugaActivitate(concurs); admin.adaugaActivitate(excursie);
		 * admin.adaugaActivitate(workshop); admin.adaugaActivitate(sedinta);
		 * 
		 * //admin.adaugaActivitate(sponsori, sali, clase);
		 * 
		 * Scanner s = new Scanner(System.in); String raspuns; do { int tipCont
		 * = alegereTipCont(); switch(tipCont) { case 1:
		 * logareCadruDidactic(listaElevi, admin, listaProfesori);break; case 4:
		 * logareSecretara(secretara,listaElevi, listaProfesori);break; case 5:
		 * logareSponsor(sponsori);break; case 6: logareParinte(parinti,
		 * sedinte); break; } System.out.println("Continuati?Da/nu"); raspuns =
		 * s.nextLine(); }while(raspuns.equals("da")); Cicu - ma incurca acum
		 */

		/*
		 * boolean logat = false; while(logat == false) { System.out.println(
		 * "Logare ca Elev"); System.out.println("Username:"); Scanner scan= new
		 * Scanner(System.in); String username= scan.nextLine();
		 * System.out.println("Parola:"); String parola = scan.nextLine(); Cont
		 * contDeVerificat = new Cont(username,parola); for(Elev e: listaElevi)
		 * { if(contDeVerificat.equals(e.getCont())) { System.out.println(
		 * "Logare cu succes"); e.afiseazaInformatii(); logat= true; break; }
		 * else System.out.println("Username sau parola incorecta");
		 * 
		 * } }
		 */

		// Verificare functie detalii activitate
		/*
		 * Activitate a = new Activitate("Sport", new Data(2016, 4, 25), 15, new
		 * Data(2016, 4, 29), 30, 10); //a.vizualizareDetalii();
		 * 
		 * // Verificare functii Cadru Didactic CadruDidactic cd = new
		 * CadruDidactic("Cicu", "Alexandru", "100110"); cd.adaugaActivitate(a);
		 * cd.veziActivitatiCoordonate();
		 */

		// TEST  FUNCTII ELEV +  MODIFICARE ACTIVITATE,DATA,SEDINTA,SALA,WORKSHOP- CICU
	

		// Verificare functie
		// e1.veziActivitatiCurente();

		// Verificare functie
		// e1.veziActivitatiDisponibile(admin);

		// TEST FUNCTII MODIFICARE ACTIVITATI SALI WORKSHOP - CICU
		// Modifica sala - merge
		Sala s = new Sala(10, 5, 2);
		/*
		 * s.modificaSala(); System.out.println("Nr sala = " + s.getNrSala());
		 * System.out.println("Nr locuri = " + s.getNrLocuri());
		 * System.out.println("Nr etaj = " + s.getEtaj());
		 */

		//Modificare activitate(include si modificare data)
		/*  Activitate a = new Activitate("Test",new Data(10,10,1999),15,new
		 Data(25,11,2060),10,50);
		 a.modificaActivitate();
		 a.vizualizareDetalii();
		*/
		
		// Verificare Modificare Workshop (include modificare activitate si modificare sala) 
		/*Workshop w = new Workshop("Test", new Data(10, 10, 1999), 15, new Data(25, 11, 2060), 10, 50, "lala", s);
		w.modificaWorkshop();
		s = w.getSala();
		System.out.println(s.getNrLocuri());
		System.out.println(s.getNrSala());
		System.out.println(s.getEtaj());
		System.out.println(w.getTematica());
		*/
		
		//Verificare Modificare Sedinta(include modificare activitate si modificare sala )
		Clasa c = new Clasa("Salam",new CadruDidactic());
		Sedinta s1 = new Sedinta("Test", new Data(10, 10, 1999), 15, new Data(25, 11, 2060), 10, 50, c, s);
		/*s1.modificaSedinta();
		Sala s2 = s1.getSala();
		Clasa c2 = s1.getClasa();
		//Verificare clasa din sedinta
		//System.out.println(c2.getNume());
		//Verificare sala din sedinta
		System.out.println(s2.getNrLocuri());
		System.out.println(s2.getNrSala());
		System.out.println(s2.getEtaj());
		*/
		
		// Verificare modificare activitate din Cadru Didactic 
		//admin.adaugaActivitate(s1);
		CadruDidactic cd = new CadruDidactic("Dobrescu","Elena","100");
		//cd.modificaActivitate(s1, admin);
		System.out.println("Nume nou clasa = " + s1.getClasa().getNume());
		
		/*CadruDidactic cd22 = new CadruDidactic();
		Class someClass = cd22.getClass();
		Field someField = someClass.getSuperclass().getField("nume");
		someField.setAccessible(true);
		boolean ok = false;
		System.out.println(someField.getName()); */
	  
	}

}
