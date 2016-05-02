import java.util.Date;
import java.util.Scanner;

public class Data {

	private int an;
	private int luna;
	private int zi;

	public Data(int zi, int luna, int an) {
		this.zi = zi;
		this.luna = luna;
		this.an = an;

	}

	public Data() {
		
	}

	// Cicu - l-am facut sa ma ajute la o functie
	public void modificaData() {
		System.out.println("Modificare Data");

		// Parametru pentru apelarea multipla sau nu a functiei
		int incercare = -1;
		boolean modifica = true;
		Scanner s = new Scanner(System.in);

		do {
			// Parametrii care vor fi folositi pentru modificarea functiei prin
			// seteri
			int NrZi_Nou = -1;
			int NrLuna_Nou = -1;
			int NrAn_Nou = -1;

			// Valoare ca sa verific daca optiunea introdusa de modificare e
			// valida ( daca e 1,2,3)
			int alegere = -1;

			do {
				System.out.println("Ce parametru vrei sa modifici din data ?");
				System.out.println("1.Zi / 2.Luna / 3.An");

				alegere = s.nextInt();

				switch (alegere) {
				case 1:
					System.out.println("Introdu alta zi = ");
					NrZi_Nou = s.nextInt();
					setZi(NrZi_Nou);
					break;
				case 2:
					System.out.println("Introdu alta luna = ");
					NrLuna_Nou = s.nextInt();
					setLuna(NrLuna_Nou);
					break;
				case 3:
					System.out.println("Introdu alt an = ");
					NrAn_Nou = s.nextInt();
					setAn(NrAn_Nou);
					break;
				}
			} while (alegere != 1 && alegere != 2 && alegere != 3);

			System.out.println("Modificare DATA cu succes !");

			System.out.println("Mai doresti sa modifici vreun parametru din DATA ?");
			System.out.println("1.DA / 2.NU");
			incercare = s.nextInt();

			switch (incercare) {
			case 1:
				modifica = true;
				break;
			case 2:
				modifica = false;
				break;
			}
		} while (modifica == true);

		System.out.println("Modificari DATA finalizate !");
		//s.close(); CRAPA DACA IL PUN WTF????
	}

	public int getAn() {
		return an;
	}

	public void setAn(int an) {
		this.an = an;
	}

	public int getLuna() {
		return luna;
	}

	public void setLuna(int luna) {
		this.luna = luna;
	}

	public int getZi() {
		return zi;
	}

	public void setZi(int zi) {
		this.zi = zi;
	}

	@Override
	public String toString() {
		String lunaString = " ";
		switch (this.luna) {
		case 1:
			lunaString = "Ianuarie";
			break;
		case 2:
			lunaString = "Februarie";
			break;
		case 3:
			lunaString = "Martie";
			break;
		case 4:
			lunaString = "Aprilie";
			break;
		case 5:
			lunaString = "Mai";
			break;
		case 6:
			lunaString = "Iunie";
			break;
		case 7:
			lunaString = "Iulie";
			break;
		case 8:
			lunaString = "August";
			break;
		case 9:
			lunaString = "Septembrie";
			break;
		case 10:
			lunaString = "Octombrie";
			break;
		case 11:
			lunaString = "Noiembrie";
			break;
		case 12:
			lunaString = "Decembrie";
			break;
		}

		return this.zi + " " + lunaString + " " + this.an;
	}

	public int comparaCuDataCurenta() {
		Date date = new Date();
		String data = date.toString();
		String[] splited = data.split("\\s+");
		String luna = splited[1];
		String ziua = splited[2];
		String an = splited[5];
		int lunaInteger = 0;
		int rezultat = -1;
		switch (luna) {
		case "Jan":
			lunaInteger = 1;
		case "Feb":
			lunaInteger = 2;
		case "Mar":
			lunaInteger = 3;
		case "Apr":
			lunaInteger = 4;
		case "May":
			lunaInteger = 5;
		case "June":
			lunaInteger = 6;
		case "July":
			lunaInteger = 7;
		case "Aug":
			lunaInteger = 8;
		case "Sept":
			lunaInteger = 9;
		case "Oct":
			lunaInteger = 10;
		case "Nov":
			lunaInteger = 11;
		case "Dec":
			lunaInteger = 12;
		}

		int ziuaInteger = Integer.parseInt(ziua);
		int anInteger = Integer.parseInt(an);

		if (this.zi == ziuaInteger && this.luna == lunaInteger && this.an == anInteger)
			rezultat = 0;
		if (this.luna == lunaInteger && this.an == anInteger)
			rezultat = ziuaInteger - this.zi;
		return rezultat;

	}

}
