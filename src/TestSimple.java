import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSimple {

	private Data d1, d2;
	private Elev elev;
	private Persoana persoana;
	private Cont cont;
	private Parinte parinte;
	private Secretara secretara;
	private CadruDidactic cd;
	private Activitate activitate;
	private Sedinta sedinta;
	private Sponsor sponsor;
	private Workshop workshop;
	private Excursie excursie;
	private Concurs concurs;
	private Clasa clasa;
	private Sala sala;
	private Administrator admin;
	private ObiectivTuristic obiectiv;

	@Before
	public void setUp() throws Exception {
		d1 = new Data(18, 07, 2016);
		d2 = new Data(17, 06, 2016);
		elev = new Elev("Cicu", "Alexandru", "105", 500);
		cd = new CadruDidactic("Bogdan", "Ionita", "594");
		activitate = new Activitate("Sedinta", d1, 100, d2, 20, 15);
		persoana = new Persoana("John", "Doe", "999");
		sala = new Sala(1, 15, 3);
		clasa = new Clasa("8A", cd);
		parinte = new Parinte("Cicu", "Cristi", "950", clasa);
		cont = new Cont("John", "1234567890");
		secretara = new Secretara("Marinela", "Veta", "050");
		sedinta = new Sedinta("NoteElevi", d1, 0, d2, 30, 12, clasa);
		obiectiv = new ObiectivTuristic("Pucioasa", "Fagaras");
		admin = new Administrator();
		sponsor = new Sponsor("Nike");
		workshop = new Workshop("Unity3D", d1, 0, d2, 10, 8, "Programare", sala);
		concurs = new Concurs("Cangurul", d1, 150, d2, 20, 10, "Matematica", sponsor, sala);
		excursie = new Excursie("Azuga", d1, 100, d2, 15, 5, new ArrayList<ObiectivTuristic>());

	}

	@After
	public void tearDown() throws Exception {
		d1 = null;
		d2 = null;
		elev = null;
		cd = null;
		activitate = null;
		persoana = null;
		sala = null;
		clasa = null;
		parinte = null;
		cont = null;
		secretara = null;
		sedinta = null;
		obiectiv = null;
		excursie = null;
		admin = null;
		sponsor = null;
		workshop = null;
		concurs = null;
	}

	@Test
	public void testConstructorConcurs() {
		assertEquals(concurs.getNume(), "Cangurul");
		assertEquals(concurs.getDataDesfasurare(), d1);
		assertEquals(concurs.getTaxa(), 150, 0);
		assertEquals(concurs.getTermenLimitaInscriere(), d2);
		assertEquals(concurs.getNrMaximParticipanti(), 20);
		assertEquals(concurs.getOraIncepere(), 10);
		assertEquals(concurs.getDisciplina(), "Matematica");
		assertEquals(concurs.getSponsor(), sponsor);
		assertEquals(concurs.getSala(), sala);
	}

	@Test
	public void testConstructorWorkshop() {
		assertEquals(workshop.getNume(), "Unity3D");
		assertEquals(workshop.getDataDesfasurare(), d1);
		assertEquals(workshop.getTaxa(), 0, 0);
		assertEquals(workshop.getTermenLimitaInscriere(), d2);
		assertEquals(workshop.getNrMaximParticipanti(), 10);
		assertEquals(workshop.getOraIncepere(), 8);
		assertEquals(workshop.getTematica(), "Programare");
		assertEquals(workshop.getSala(), sala);

	}

	@Test
	public void testConstructorSponsor() {
		assertEquals(sponsor.getFirma(), "Nike");
	}

	@Test
	public void testConstructorAdmin() {
		assertEquals(admin.getCont(), new Cont("admin", "admin"));
		assertEquals(admin.getActivitati().size(), 0);
		assertEquals(admin.getConturiCadruDidactic().size(), 0);
	}

	@Test
	public void testConstructorObiectivT() {
		assertEquals(obiectiv.getNume(), "Pucioasa");
		assertEquals(obiectiv.getLocatie(), "Fagaras");
	}

	@Test
	public void testConstructorSedinta() {
		assertEquals(sedinta.getNume(), "NoteElevi");
		assertEquals(sedinta.getDataDesfasurare(), d1);
		assertEquals(sedinta.getTaxa(), 0, 0);
		assertEquals(sedinta.getTermenLimitaInscriere(), d2);
		assertEquals(sedinta.getNrMaximParticipanti(), 30);
		assertEquals(sedinta.getOraIncepere(), 12);
		assertEquals(sedinta.getClasa(), clasa);
	}

	@Test
	public void testConstructorPersoana() {
		assertEquals(persoana.getNume(), "John");
		assertEquals(persoana.getPrenume(), "Doe");
		assertEquals(persoana.getCNP(), "999");
	}

	@Test
	public void testConstructorElev() {
		assertEquals(elev.getNume(), "Cicu");
		assertEquals(elev.getPrenume(), "Alexandru");
		assertEquals(elev.getCNP(), "105");
		assertEquals(elev.getNumerarCont(), 500f, 0);
	}

	@Test
	public void testConstructorCadruD() {
		assertEquals(cd.getNume(), "Bogdan");
		assertEquals(cd.getPrenume(), "Ionita");
		assertEquals(cd.getCNP(), "594");
	}

	@Test
	public void testConstructorData() {
		assertEquals(d1.getZi(), 18);
		assertEquals(d1.getLuna(), 07);
		assertEquals(d1.getAn(), 2016);
	}

	@Test
	public void testConstructorActivitate() {
		assertEquals(activitate.getNume(), "Sedinta");
		assertEquals(activitate.getDataDesfasurare(), d1);
		assertEquals(activitate.getTaxa(), 100, 0);
		assertEquals(activitate.getTermenLimitaInscriere(), d2);
		assertEquals(activitate.getNrMaximParticipanti(), 20);
		assertEquals(activitate.getOraIncepere(), 15);
	}

	@Test
	public void testConstructorSala() {
		assertEquals(sala.getNrSala(), 1);
		assertEquals(sala.getNrLocuri(), 15);
		assertEquals(sala.getEtaj(), 3);

	}

	@Test
	public void testConstructorClasa() {
		assertEquals(clasa.getNume(), "8A");
		assertEquals(clasa.getResponsabil(), cd);
	}

	@Test
	public void testConstructorParinte() {
		assertEquals(parinte.getNume(), "Cicu");
		assertEquals(parinte.getPrenume(), "Cristi");
		assertEquals(parinte.getCNP(), "950");
		assertEquals(parinte.getClasaCopil(), clasa);
	}

	@Test
	public void testConstructorCont() {
		assertEquals(cont.getUsername(), "John");
		assertEquals(cont.getParola(), "1234567890");
	}

	@Test
	public void testConstructorSecretara() {
		assertEquals(secretara.getNume(), "Marinela");
		assertEquals(secretara.getPrenume(), "Veta");
		assertEquals(secretara.getCNP(), "050");
	}

	@Test
	public void testConstructorExcursie() {
		assertEquals(excursie.getNume(), "Azuga");
		assertEquals(excursie.getDataDesfasurare(), d1);
		assertEquals(excursie.getTaxa(), 100, 0);
		assertEquals(excursie.getTermenLimitaInscriere(), d2);
		assertEquals(excursie.getNrMaximParticipanti(), 15);
		assertEquals(excursie.getOraIncepere(), 5);
		assertEquals(excursie.getObiectiveTuristice().size(), 0);
	}

}
