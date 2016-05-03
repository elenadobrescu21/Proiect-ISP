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

    /* TESTE GETTERI */
    @Test
    public void testGetNumeA() {
	String numeleActivitatii = activitate.getNume();
	assertSame(numeleActivitatii, "Sedinta");
    }

    @Test
    public void testGetDataDesfA() {
	Data desf = activitate.getDataDesfasurare();
	assertSame(desf, d1);
    }

    @Test
    public void testGetTaxa() {
	float taxa = activitate.getTaxa();
	assertEquals(taxa, 100.0, 0);
    }

    @Test
    public void testGetDataDesfL() {
	Data limita = activitate.getTermenLimitaInscriere();
	assertSame(limita, d2);
    }

    @Test
    public void testGetNrMaxA() {
	int nrMax = activitate.getNrMaximParticipanti();
	assertSame(nrMax, 20);
    }

    @Test
    public void testGetOraStartA() {
	int oraStart = activitate.getOraIncepere();
	assertSame(oraStart, 15);
    }

    @Test
    public void testGetCadruA() {
	CadruDidactic cd1 = activitate.getResponsabil();
	assertNull(cd1);
    }

    @Test
    public void testGetEleviA() {
	ArrayList<Elev> elevi = activitate.getEleviParticipanti();
	assertEquals(elevi.size(), 0);
    }

    @Test
    public void testGetConturiEleviAdm() {
	ArrayList<Cont> conturi = admin.getConturiElev();
	assertEquals(conturi.size(), 0);
    }

    @Test
    public void testGetConturiCDAdm() {
	ArrayList<Cont> conturi = admin.getConturiCadruDidactic();
	assertEquals(conturi.size(), 0);
    }

    @Test
    public void testGetActivitatiCD() {
	ArrayList<Activitate> activitatiCoordonate = cd.getActivitatiCoordonate();
	assertEquals(activitatiCoordonate.size(), 0);
    }

    @Test
    public void testGetNumeClasa() {
	String numeClasa = clasa.getNume();
	assertSame(numeClasa, "8A");
    }

    @Test
    public void testGetCDClasa() {
	CadruDidactic cd1 = clasa.getResponsabil();
	assertSame(cd1, cd);
    }

    @Test
    public void testGetClasaE() {
	Clasa cl = elev.getClasa();
	assertNull(cl);
    }

    @Test
    public void testGetNumerarE() {
	float numerar = elev.getNumerarCont();
	assertEquals(numerar, 500, 0);
    }

    @Test
    public void testGetActivitatiCurenteE() {
	ArrayList<Activitate> ac = elev.getActivitati();
	assertEquals(ac.size(), 0);
    }

    @Test
    public void testGetNumeOT() {
	String nume = obiectiv.getNume();
	assertSame(nume, "Pucioasa");
    }

    @Test
    public void testGetLocatie() {
	String locatie = obiectiv.getLocatie();
	assertSame(locatie, "Fagaras");
    }

    @Test
    public void testGetClasaCopil() {
	Clasa clcopil = parinte.getClasaCopil();
	assertSame(clcopil, clasa);
    }

    @Test
    public void testGetContParinte() {
	Cont c = parinte.getCont();
	assertNotNull(c);
    }

    @Test
    public void testGetOT() {
	ArrayList<ObiectivTuristic> aot = excursie.getObiectiveTuristice();
	assertEquals(aot.size(), 0);

    }

    @Test
    public void testGetZi() {
	int zi = d1.getZi();
	assertSame(zi, 18);
    }

    @Test
    public void testGetLuna() {
	int luna = d1.getLuna();
	assertSame(luna, 07);
    }

    @Test
    public void testGetAn() {
	int an = d1.getAn();
	assertEquals(an, 2016);
    }

    @Test
    public void testGetContUser() {
	String user = cont.getUsername();
	assertSame(user, "John");
    }

    @Test
    public void testGetContPass() {
	String parola = cont.getParola();
	assertSame(parola, "1234567890");
    }

    @Test
    public void testGetDisciplina() {
	String disci = concurs.getDisciplina();
	assertSame(disci, "Matematica");
    }

    @Test
    public void testGetSponsor() {
	Sponsor sp = concurs.getSponsor();
	assertSame(sp, sponsor);
    }

    @Test
    public void testGetSalaConcurs() {
	Sala sl = concurs.getSala();
	assertSame(sl, sala);
    }

    @Test
    public void testGetNumePers() {
	String nume = persoana.getNume();
	assertSame(nume, "John");
    }

    @Test
    public void testGetPrenPers() {
	String prenume = persoana.getPrenume();
	assertSame(prenume, "Doe");
    }

    @Test
    public void testGetCNPPers() {
	String cnp = persoana.getCNP();
	assertSame(cnp, "999");
    }

    @Test
    public void testGetContPers() {
	Cont c = persoana.getCont();
	assertNull(c);
    }

    @Test
    public void testGetNrSala() {
	int nrSala = sala.getNrSala();
	assertSame(nrSala, 1);
    }

    @Test
    public void testGetNrLocuriSala() {
	int nrLocuri = sala.getNrLocuri();
	assertSame(nrLocuri, 15);
    }

    @Test
    public void testGetNrEtajSala() {
	int nrEtaj = sala.getEtaj();
	assertSame(nrEtaj, 3);
    }

    @Test
    public void testGetClasaSedinta() {
	Clasa cl = sedinta.getClasa();
	assertSame(cl, clasa);
    }

    @Test
    public void testGetSalaSedinta() {
	Sala sl = sedinta.getSala();
	assertNull(sl);
    }

    @Test
    public void testGetFirma() {
	String firma = sponsor.getFirma();
	assertSame(firma, "Nike");
    }

    @Test
    public void testGetActivitatiSponsorizate() {
	ArrayList<Activitate> ase = sponsor.getActivitatiSponsorizate();
	assertEquals(ase.size(), 0);
    }

    @Test
    public void testGetTematica() {
	String tematica = workshop.getTematica();
	assertSame(tematica, "Programare");
    }

    @Test
    public void testGetSalaWorkshop() {
	Sala sl = workshop.getSala();
	assertSame(sl, sala);
    }

    /* TESTE SETTERI */

    // SETTERI CLASA PERSOANA
    @Test
    public void testSetNumePers() {
	String numeNou = "Mihai";
	persoana.setNume(numeNou);
	assertSame(persoana.getNume(), "Mihai");
    }

    @Test
    public void testSetPrenumePers() {
	String prenumeNou = "Bobita";
	persoana.setPrenume(prenumeNou);
	assertSame(persoana.getPrenume(), "Bobita");
    }

    @Test
    public void testSetCNPPers() {
	String CNPNou = "150";
	persoana.setCNP(CNPNou);
	assertSame(persoana.getCNP(), "150");
    }

    @Test
    public void testSetContPers() {
	Cont contNou = new Cont("Jelly", "Bean");
	persoana.setCont(contNou);
	assertSame(persoana.getCont(), contNou);
    }

    // SETTERI CLASA SALA
    @Test
    public void testSetNrSala() {
	int nrSalaNou = 18;
	sala.setNrSala(nrSalaNou);
	assertSame(sala.getNrSala(), 18);
    }

    @Test
    public void testSetNrLocuri() {
	int nrLocuriNou = 35;
	sala.setNumarLocuri(nrLocuriNou);
	assertSame(sala.getNrLocuri(), 35);

    }

    @Test
    public void testSetNrEtaj() {
	int nrEtajNou = 2;
	sala.setEtaj(nrEtajNou);
	assertSame(sala.getEtaj(), 2);

    }

    // SETTERI CLASA DATA
    @Test
    public void testSetZi() {
	int ziNoua = 9;
	d1.setZi(ziNoua);
	assertSame(d1.getZi(), 9);
    }

    @Test
    public void testSetLuna() {
	int lunaNoua = 2;
	d1.setLuna(lunaNoua);
	assertSame(d1.getLuna(), 2);
    }

    @Test
    public void testSetAn() {
	int anNou = 2018;
	d1.setAn(anNou);
	assertEquals(d1.getAn(), 2018);
    }

    // SETTERI CLASA CONT
    @Test
    public void testSetContUsername() {
	String usernameNou = "Boss";
	cont.setUsername(usernameNou);
	assertSame(cont.getUsername(), "Boss");
    }

    @Test
    public void testSetContPass() {
	String passNou = "888";
	cont.setParola(passNou);
	assertSame(cont.getParola(), "888");
    }

    // SETTERI CLASA ELEV
    @Test
    public void testSetClasaElev() {
	Clasa cl = new Clasa("9A", cd);
	elev.setClasa(cl);
	assertSame(elev.getClasa(), cl);
    }

    @Test
    public void testSetNumerarElev() {
	float cash = 950;
	elev.setNumerarCont(cash);
	assertEquals(elev.getNumerarCont(), 950, 0);
    }

    // SETTERI CLASA CONCURS
    @Test
    public void testSetDisciplina() {
	String disciplinaNoua = "Istorie";
	concurs.setDisciplina(disciplinaNoua);
	assertSame(concurs.getDisciplina(), "Istorie");
    }

    // SETTERI CLASA WORKSHOP
    @Test
    public void testSetTematicaWorkshop() {
	String tematicaNoua = "Film";
	workshop.setTematica(tematicaNoua);
	assertSame(workshop.getTematica(), "Film");
    }

    @Test
    public void testSetSalaWorkshop() {
	Sala salaNoua = new Sala(2, 4, 9);
	workshop.setSala(salaNoua);
	assertSame(workshop.getSala(), salaNoua);
    }

    // SETTERI CLASA SPONSOR
    @Test
    public void testSetFirma() {
	String firmaNoua = "BMW";
	sponsor.setFirma(firmaNoua);
	assertSame(sponsor.getFirma(), "BMW");
    }

    @Test
    public void testSetActivitatiSponsorizate() {
	ArrayList<Activitate> aseNoi = new ArrayList<Activitate>();
	aseNoi.add(activitate);
	sponsor.setActivitatiSponsorizate(aseNoi);
	assertSame(sponsor.getActivitatiSponsorizate(), aseNoi);
    }

    // SETTERI CLASA SEDINTA
    @Test
    public void testSetClasaSedinta() {
	Clasa clasaNoua = new Clasa("9B", cd);
	sedinta.setClasa(clasaNoua);
	assertSame(sedinta.getClasa(), clasaNoua);
    }

    @Test
    public void testSetSalaSedinta() {
	Sala salaNoua = new Sala(1, 1, 1);
	sedinta.setSala(salaNoua);
	assertSame(sedinta.getSala(), salaNoua);
    }

    // SETTERI CLASA EXCURSIE
    @Test
    public void testSetObiective() {
	ArrayList<ObiectivTuristic> obtNoi = new ArrayList<ObiectivTuristic>();
	obtNoi.add(obiectiv);
	excursie.setObiectiveTuristice(obtNoi);
	assertSame(excursie.getObiectiveTuristice(), obtNoi);
    }

    // SETTERI CLASA CLASA
    @Test
    public void testSetClasaNume() {
	String numeNou = "12A";
	clasa.setNume(numeNou);
	assertSame(clasa.getNume(), "12A");
    }

    @Test
    public void testSetClasaResponsabil() {
	CadruDidactic cdNou = new CadruDidactic("Andreea", "Mantea", "666");
	clasa.setResponsabil(cdNou);
	assertSame(clasa.getResponsabil(), cdNou);
    }

    // SETTERI CLASA CADRU DIDACTIC
    @Test
    public void testSetActivitatiCoordonateCD() {
	ArrayList<Activitate> acoordNoi = new ArrayList<Activitate>();
	acoordNoi.add(activitate);
	cd.setActivitatiCoordonate(acoordNoi);
	assertSame(cd.getActivitatiCoordonate(), acoordNoi);
    }

    // SETTERI CLASA ADMINISTRATOR
    @Test
    public void testSetContAdmin() {
	Cont nou = new Cont("boss", "banana");
	admin.setCont(nou);
	assertSame(admin.getCont(), nou);
    }

    // SETTERI CLASA ACTIVITATE
    @Test
    public void testSetDataDesfasurare() {
	activitate.setDataDesfasurare(d2);
	assertSame(activitate.getDataDesfasurare(), d2);
    }

    @Test
    public void testSetTaxa() {
	activitate.setTaxa(199);
	assertEquals(activitate.getTaxa(), 199, 0);
    }

    @Test
    public void testSetNumeActivitate() {
	String numeNou = "Conferinta";
	activitate.setNume(numeNou);
	assertSame(activitate.getNume(), numeNou);
    }

    @Test
    public void testSetLimitaInscriere() {
	activitate.setTermenLimitaInscriere(d1);
	assertSame(activitate.getTermenLimitaInscriere(), d1);
    }

    @Test
    public void testSetNrMax() {
	activitate.setNrMaximParticipanti(250);
	assertEquals(activitate.getNrMaximParticipanti(), 250);
    }

    @Test
    public void testSetOraStart() {
	activitate.setOraIncepere(30);
	assertSame(activitate.getOraIncepere(), 30);
    }

    @Test
    public void testSetResponsabil() {
	CadruDidactic cd2 = new CadruDidactic("Jean", "Jaque", "23");
	activitate.setResponsabil(cd2);
	assertSame(activitate.getResponsabil(), cd2);
    }

    /* TESTE CONSTRUCTORI */
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
