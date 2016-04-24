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
		String luna = " ";
		switch (this.luna) {
		case 1:
			luna = "Ianuarie";
		case 2:
			luna = "Februarie";
		case 3:
			luna = "Martie";
		case 4:
			luna = "Aprilie";
		case 5:
			luna = "Mai";
		case 6:
			luna = "Iunie";
		case 7:
			luna = "Iulie";
		case 8:
			luna = "August";
		case 9:
			luna = "Septembrie";
		case 10:
			luna = "Octombrie";
		case 11:
			luna = "Noiembrie";
		case 12:
			luna = "Decembrie";
		}

		return this.zi + " " + luna + " " + this.an;
	}

	public int comparaCuDataCurenta() {
		Date date = new Date();
		String data = date.toString();
		String[] splited = data.split("\\s+");
		String luna = splited[1];
		String ziua = splited[2];
		String an = splited[5];
		int lunaInteger = 0;
		int rezultat = -9777;
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
