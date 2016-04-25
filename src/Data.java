import java.util.Date;

public class Data {

	private int an;
	private int luna;
	private int zi;

	public Data(int an, int luna, int zi) {
		this.an = an;
		this.luna = luna;
		this.zi = zi;
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
