import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Elev extends Persoana {

	private Clasa clasa;
	// Activitati la care este inscris
	private ArrayList<Activitate> activitati;
	private float numerarCont;

	public Elev(String nume, String prenume, String CNP, float numerarCont) {
		super(nume, prenume, CNP);
		this.numerarCont = numerarCont;
		activitati = new ArrayList<Activitate>();
	}

	public Clasa getClasa() {
		return clasa;
	}

	public void setClasa(Clasa clasa) {
		this.clasa = clasa;
	}

	public ArrayList<Activitate> getActivitati() {
		return activitati;
	}

	public void setActivitati(ArrayList<Activitate> activitati) {
		this.activitati = activitati;
	}

	public double getNumerarCont() {
		return numerarCont;
	}

	public void setNumerarCont(float numerarCont) {
		this.numerarCont = numerarCont;
	}

	public void afiseazaInformatii() {
		System.out.println("Nume: " + this.getNume());
		System.out.println("Prenume: " + this.getPrenume());
		System.out.println("Clasa: " + this.getClasa().getNume());
		System.out.println("Numerar cont: " + this.getNumerarCont());
		System.out.println("Activititati: ");
		if (this.activitati.size() == 0) {
			System.out.println("Elevul nu s-a inscris la nicio activitate");
		} else {
			for (Activitate a : activitati) {
				System.out.println(a.getNume());
			}
		}

	}

	public void inscriereActivitate(Activitate a) {
		this.activitati.add(a);
	}

	// Functie Complexa - Alex
	// De moficiat parametrul in diagrama
	public void inscrieLaActivitate(Administrator admin) {

		boolean existaL = false; // locuri
		boolean existaB = false; // bani
		boolean termeni = false;
		boolean incercare = false;

		// Activitatile posibile create de un administrator
		ArrayList<Activitate> a_posibile = new ArrayList<Activitate>();
		a_posibile = admin.getActivitati();

		do {
			// Vezi toate activitatile (nume+data)
			for (int i = 0; i < a_posibile.size(); i++) {
				System.out.println(i + ") " + a_posibile.get(i).getNume() + " incepand cu "
						+ a_posibile.get(i).getDataDesfasurare() + " cu taxa de " + a_posibile.get(i).getTaxa()
						+ "RON");
			}

			// Elev care poate sa isi aleaga optiunea atat timp cat este valida
			// si nu participa deja la activitatea respectiva
			int alege = -2;
			do {
				Scanner s = new Scanner(System.in);
				System.out.println("Alege una dintre activitatile afisate mai sus");
				alege = s.nextInt();
				// s.close();
				// Index eronat , executa din nou

				// 2 conditii de realege o activitate
				// 1.1 Index eronat -> repeta actiunea
				// 1.2 Index corect , dar elevul participa la activitatea
				// respectiva
			} while (!a_posibile.contains(a_posibile.get(alege))
					|| (a_posibile.contains(a_posibile.get(alege)) && activitati.contains(a_posibile.get(alege))));

			// Cauta in lista daca optiunea introdusa este valida daca chiar
			// exista indexul respectiv
			// Exista index

			// Exista locuri ?
			if (a_posibile.get(alege).existaLocuri()) {
				existaL = true;
				// Exista bani in cont pt plata ?
				if (this.numerarCont - a_posibile.get(alege).getTaxa() >= 0) {
					existaB = true;
					// Intreaba daca accepta sau nu si daca introduce optiuni
					// valide
					int accept = -1;
					do {
						System.out.println("Accepti termeni si conditiile legate de activitatea la care ai aplicat ? ");
						System.out.println("Banii nu mai pot fi returnati dupa acceptarea termenilor si conditiilor !");
						System.out.println("1.Da accept / 2.Nu accept");

						Scanner sc = new Scanner(System.in);
						accept = sc.nextInt();
						// sc.close();
					} while (accept != 1 && accept != 2);

					// Trebuie verificat daca apasa 1 sau 2 - daca accepta
					// termeni sau nu accepta
					// Intra aici doar daca e 1 sau 2
					switch (accept) {

					// Accepta termeni si conditii
					case 1:
						termeni = true;
						// Plateste Taxa
						numerarCont -= a_posibile.get(alege).getTaxa();
						System.out.println("Taxa a fost platita cu succes !");
						System.out.println("Numerar curent = " + this.numerarCont);

						// Intreaba de FEEDBACK/COMMENTARII
						int feedback = -1;

						// Nu intra pe switch pana nu ai o optiune valida !
						do {
							System.out.println("Vrei sa lasi un comentariu ?");
							System.out.println("1.Da / 2.Nu");

							Scanner scan = new Scanner(System.in);
							feedback = scan.nextInt();
							// scan.close();
						} while (feedback != 1 && feedback != 2);

						switch (feedback) {
						// SCRIE IN FISIER
						case 1:
							// Nume elev + activitatea la care scrie
							// comentariul
							File file = new File(
									this.getNume() + this.getPrenume() + a_posibile.get(alege).getNume() + ".txt");
							try {
								file.createNewFile();
							} catch (IOException e1) {
								e1.printStackTrace();
							}

							FileWriter testWriter;
							try {
								testWriter = new FileWriter(file);
								PrintWriter filePrint = new PrintWriter(testWriter, true);
								Scanner scanner = new Scanner(System.in);
								String line = scanner.nextLine();
								filePrint.println(line);
								// scanner.close();

								filePrint.close();
							} catch (IOException e) {
								e.printStackTrace();
							}

							break;

						// IGNORA SCRIEREA IN FISIER
						case 2:
							System.out.println("Nu s-a adaugat niciun comentariu.");
							break;

						}
						activitati.add(a_posibile.get(alege));
						System.out.println("Inscriere cu succes !");
						break;

					// Nu accepta termeni si conditii
					// Vrei alta activitate ?
					case 2:
						termeni = false;
						int incercare_noua = -1;
						do {
							System.out.println("Inscriere esuata !");
							System.out.println("Vrei sa te inscri la o alta activitate ?");
							System.out.println("1.Da / 2.Nu");
							Scanner scanner = new Scanner(System.in);
							incercare_noua = scanner.nextInt();
							// scanner.close();
						} while (incercare_noua != 1 && incercare_noua != 2);
						switch (incercare_noua) {
						case 1:
							incercare = true;
							break;
						case 2:
							System.out.println("Abandon");
							return;
						}
						break;

					}

					// Nu accepti
					// Du-te inapoi la recitire valoare activitate index
				} else {
					// Nu ai destui bani in cont
					System.out.println("Nu ai destui bani sa te inscri la aceasta activitate !");
					existaB = false;

					// Vrei alta activitate ?
					int incercare_noua = -1;
					do {
						System.out.println("Inscriere esuata !");
						System.out.println("Vrei sa te inscri la o alta activitate ?");
						System.out.println("1.Da / 2.Nu");
						Scanner scanner = new Scanner(System.in);
						incercare_noua = scanner.nextInt();
						// scanner.close();
					} while (incercare_noua != 1 && incercare_noua != 2);
					switch (incercare_noua) {
					case 1:
						incercare = true;
						break;
					case 2:
						System.out.println("Abandon");
						return;
					}
				}
			} else {
				// Nu sunt locuri destule la activitatea aleasa
				System.out.println("Nu sunt locuri destule la activitatea aleasa !");
				existaL = false;

				// Vrei alta activitate ?
				int incercare_noua = -1;
				do {
					System.out.println("Inscriere esuata !");
					System.out.println("Vrei sa te inscri la o alta activitate ?");
					System.out.println("1.Da / 2.Nu");
					Scanner scanner = new Scanner(System.in);
					incercare_noua = scanner.nextInt();
					// scanner.close();
				} while (incercare_noua != 1 && incercare_noua != 2);
				switch (incercare_noua) {
				case 1:
					incercare = true;
					break;
				case 2:
					System.out.println("Abandon");
					return;

				}

			}
			// Nu exista locuri , bani , termeni si vrei sa incerci din nou
			// Nu exista locuri -> reia sau
			// Exista locuri si nu exista bani -> reia sau
			// Exista locuri , exista bani , nu exista termeni -> reia
		} while (existaL == false || (existaL == true && existaB == false)
					|| (existaL == true && existaB == true && termeni == false));
	}

	// Arata toate activitatile la care este inscris + toate detaliile pe
	// fiecare activitate
	public void veziActivitatiCurente() {
		for (Activitate a : activitati)
			a.vizualizareDetalii();
	}

	// Printeaza toate activitatile la care mai sunt locuri	
	public void veziActivitatiDisponibile(Administrator admin) {
		for (Activitate a : admin.getActivitati()) {
			if (a.existaLocuri()) {
				System.out.println(a.getNume());
			}
		}
	}

}
