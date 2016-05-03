import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestAsocieri extends TestCase {
    Workshop workshop;
    Sala sala;
    Data dataDesfasurare;
    Data termenLimitaInscriere;
    Concurs concurs;
    Sponsor sponsor;

    @Before
    public void setUp() throws Exception {
	sala = new Sala(10, 25, 1);
	dataDesfasurare = new Data(27, 5, 2016);
	termenLimitaInscriere = new Data(25, 5, 2016);
	workshop = new Workshop("Workshop HTML", dataDesfasurare, 0, termenLimitaInscriere, 20, 15, "HTML", sala);
	sponsor = new Sponsor("IBM");
	concurs = new Concurs("Cangurul", dataDesfasurare, 10, termenLimitaInscriere, 50, 8, "matematica", sponsor,
		sala);

    }

    @After
    public void tearDown() throws Exception {
    }

    // teste pentru relatia de asociere Workshop-Sala
    @Test
    public void testAsociereWorkShopSala() {
	assertSame(workshop.getSala(), sala);
	assertEquals(workshop.getSala().getNrSala(), 10);
	assertEquals(workshop.getSala().getNrLocuri(), 25);
	assertEquals(workshop.getSala().getEtaj(), 1);
    }

    @Test
    public void testSetSala() {
	assertSame(workshop.getSala(), sala);
	Sala altaSala = new Sala(12, 24, 1);
	workshop.setSala(altaSala);
	// se verifica faptul ca workshopul are asociata noua sala
	assertSame(workshop.getSala(), altaSala);

    }

    @Test
    public void testGetSala() {
	Sala salaWorkshop = workshop.getSala();
	// verificarea faptului ca se returneaza chiar obiectul asociat
	assertSame(salaWorkshop, sala);
    }

    // teste pentru relatia Concurs-Sponsor
    @Test
    public void testAsociereConcursSponsor() {
	assertSame(concurs.getSponsor(), sponsor);
	assertEquals(concurs.getSponsor().getFirma(), "IBM");

    }

    @Test
    public void testSetSponsor() {
	assertSame(concurs.getSponsor(), sponsor);
	Sponsor altSponsor = new Sponsor("Intel");
	concurs.setSponsor(altSponsor);
	assertSame(concurs.getSponsor(), altSponsor);
    }

    @Test
    public void testGetSponsor() {
	Sponsor sponsorConcurs = concurs.getSponsor();
	assertSame(sponsorConcurs, sponsor);

    }

}
