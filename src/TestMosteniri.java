import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMosteniri {
	
	Persoana persoana;
	CadruDidactic cd;
	Parinte parinte;
	Secretara secretara;
	Activitate activitate;
	Sedinta sedinta;
	Workshop workshop;
	Excursie excursie;
	Concurs concurs;
	
	@Before
	public void setUp() {
		persoana = new Persoana();
		cd = new CadruDidactic();
		parinte = new Parinte();
		secretara = new Secretara();
		activitate = new Activitate();
		sedinta = new Sedinta();
		workshop = new Workshop();
		excursie = new Excursie();
		concurs = new Concurs();
	}
	
	
	@Test
	public void testMostenireCadruDidactic() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class cadruDidactic = cd.getClass();
		Class pers = persoana.getClass();
		boolean ok = false;
		if(pers.isAssignableFrom(cadruDidactic)) {
			ok = true;
		}
		assertTrue(ok);
	}
	
	@Test
	public void testMostenireSecretara() {
		Class clasaSecretara = secretara.getClass();
		Class pers = persoana.getClass();
		boolean ok = false;
		if(pers.isAssignableFrom(clasaSecretara )) {
			ok = true;
		}
		assertTrue(ok);
	}
	
	@Test
	public void testMostenireParinte() {
		Class clasaParinte = parinte.getClass();
		Class pers = persoana.getClass();
		boolean ok = false;
		if(pers.isAssignableFrom(clasaParinte )) {
			ok = true;
		}
		assertTrue(ok);
	}
	
	@Test
	public void testMostenireConcurs() {
		Class clasaConcurs = concurs.getClass();
		Class activ = activitate.getClass();
		boolean ok = false;
		if(activ.isAssignableFrom(clasaConcurs)) {
			ok = true;
		}
		assertTrue(ok);
		
	}
	
	@Test
	public void testMostenireExcursie() {
		Class clasaExcursie = excursie.getClass();
		Class activ = activitate.getClass();
		boolean ok = false;
		if(activ.isAssignableFrom(clasaExcursie)) {
			ok = true;
		}
		assertTrue(ok);		
	}
	
	@Test
	public void testMostenireWorkshop() {
		Class clasaWorkshop = workshop.getClass();
		Class activ = activitate.getClass();
		boolean ok = false;
		if(activ.isAssignableFrom(clasaWorkshop)) {
			ok = true;
		}
		assertTrue(ok);			
	}
	
	@Test
	public void testMostenireSedinta() {
		Class clasaSedinta = sedinta.getClass();
		Class activ = activitate.getClass();
		boolean ok = false;
		if(activ.isAssignableFrom(clasaSedinta)) {
			ok = true;
		}
		assertTrue(ok);	
		
	}
		
	@Test
	public void testSecretaracMostenestePersoana() {
		Class clasaSecretara = secretara.getClass();
		List<Field> fields = new ArrayList<Field>(); 
		Class superClass = clasaSecretara.getSuperclass();
		boolean ok = false;
		boolean numeGasit = false;
		boolean prenumeGasit = false;
		boolean CNPGasit = false;
		boolean contGasit = false;
		if(clasaSecretara.getSuperclass()!=null) {
			fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
		}
		for(Field f : fields) {
			if(f.getName().equals("nume")) {
				numeGasit = true;
			}
			if(f.getName().equals("prenume")) {
				prenumeGasit = true;
			}
			if(f.getName().equals("CNP")) {
				CNPGasit = true;
			}
			if(f.getName().equals("cont")) {
				contGasit = true;
			}
		}
		if(numeGasit && prenumeGasit && CNPGasit && contGasit) {
			ok = true;
		}
		assertTrue(ok);
	}
		
	
	
	@Test
	public void testCadruDidacticMostenestePersoana() {
		Class cadruDidactic = cd.getClass();
		List<Field> fields = new ArrayList<Field>(); 
		Class superClass = cadruDidactic.getSuperclass();
		boolean ok = false;
		boolean numeGasit = false;
		boolean prenumeGasit = false;
		boolean CNPGasit = false;
		boolean contGasit = false;
		if(cadruDidactic.getSuperclass()!=null) {
			fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
		}
		for(Field f : fields) {
			if(f.getName().equals("nume")) {
				numeGasit = true;
			}
			if(f.getName().equals("prenume")) {
				prenumeGasit = true;
			}
			if(f.getName().equals("CNP")) {
				CNPGasit = true;
			}
			if(f.getName().equals("cont")) {
				contGasit = true;
			}
		}
		if(numeGasit && prenumeGasit && CNPGasit && contGasit) {
			ok = true;
		}
		assertTrue(ok);
	}
	
	@Test
	public void testParinteMostenestePersoana() {
		Class clasaParinte = parinte.getClass();
		List<Field> fields = new ArrayList<Field>(); 
		Class superClass = clasaParinte.getSuperclass();
		boolean ok = false;
		boolean numeGasit = false;
		boolean prenumeGasit = false;
		boolean CNPGasit = false;
		boolean contGasit = false;
		if(clasaParinte.getSuperclass()!=null) {
			fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
		}
		for(Field f : fields) {
			if(f.getName().equals("nume")) {
				numeGasit = true;
			}
			if(f.getName().equals("prenume")) {
				prenumeGasit = true;
			}
			if(f.getName().equals("CNP")) {
				CNPGasit = true;
			}
			if(f.getName().equals("cont")) {
				contGasit = true;
			}
		}
		if(numeGasit && prenumeGasit && CNPGasit && contGasit) {
			ok = true;
		}
		assertTrue(ok);
	}
	
	@Test
	public void testSedintaMostenesteActivitate() {
		Class clasaSedinta = sedinta.getClass();
		List<Field> fields = new ArrayList<Field>(); 
		Class superClass = clasaSedinta.getSuperclass();
		boolean ok = false;
		boolean nume = false;
		boolean responsabil = false;
		boolean eleviParticipanti = false;
		boolean dataDesfasurare = false;
		boolean taxa = false;
		boolean termenLimitaInscriere = false;
		boolean nrMaximParticipanti = false;
		boolean oraIncepere = false;
		boolean stare = false;
		if(clasaSedinta.getSuperclass()!=null) {
			fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
		}
		for(Field f : fields) {
			if(f.getName().equals("nume")) {
				nume = true;
			}
			if(f.getName().equals("responsabil")) {
				responsabil = true;
			}
			if(f.getName().equals("eleviParticipanti")) {
				eleviParticipanti = true;
			}
			if(f.getName().equals("dataDesfasurare")) {
				dataDesfasurare = true;
			}
			if(f.getName().equals("taxa")) {
				taxa = true;
			}
			if(f.getName().equals("termenLimitaInscriere")) {
				termenLimitaInscriere = true;
			}
			if(f.getName().equals("nrMaximParticipanti")) {
				nrMaximParticipanti = true;
			}
			if(f.getName().equals("oraIncepere")) {
				oraIncepere = true;
			}
			if(f.getName().equals("stare")) {
				stare = true;
			}
			
		}
		if(nume && responsabil && eleviParticipanti && dataDesfasurare && taxa && termenLimitaInscriere
				&& nrMaximParticipanti && oraIncepere && stare) {
			ok = true;
		}
		assertTrue(ok);
	}
	
	@Test
	public void testConcursMostenesteActivitate() {
		Class clasaConcurs = concurs.getClass();
		List<Field> fields = new ArrayList<Field>(); 
		Class superClass = clasaConcurs.getSuperclass();
		boolean ok = false;
		boolean nume = false;
		boolean responsabil = false;
		boolean eleviParticipanti = false;
		boolean dataDesfasurare = false;
		boolean taxa = false;
		boolean termenLimitaInscriere = false;
		boolean nrMaximParticipanti = false;
		boolean oraIncepere = false;
		boolean stare = false;
		if(clasaConcurs.getSuperclass()!=null) {
			fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
		}
		for(Field f : fields) {
			if(f.getName().equals("nume")) {
				nume = true;
			}
			if(f.getName().equals("responsabil")) {
				responsabil = true;
			}
			if(f.getName().equals("eleviParticipanti")) {
				eleviParticipanti = true;
			}
			if(f.getName().equals("dataDesfasurare")) {
				dataDesfasurare = true;
			}
			if(f.getName().equals("taxa")) {
				taxa = true;
			}
			if(f.getName().equals("termenLimitaInscriere")) {
				termenLimitaInscriere = true;
			}
			if(f.getName().equals("nrMaximParticipanti")) {
				nrMaximParticipanti = true;
			}
			if(f.getName().equals("oraIncepere")) {
				oraIncepere = true;
			}
			if(f.getName().equals("stare")) {
				stare = true;
			}
			
		}
		if(nume && responsabil && eleviParticipanti && dataDesfasurare && taxa && termenLimitaInscriere
				&& nrMaximParticipanti && oraIncepere && stare) {
			ok = true;
		}
		assertTrue(ok);
	}
	
	@Test
	public void testWorkshopMostenesteActivitate() {
		Class clasaWorkshop= workshop.getClass();
		List<Field> fields = new ArrayList<Field>(); 
		Class superClass = clasaWorkshop.getSuperclass();
		boolean ok = false;
		boolean nume = false;
		boolean responsabil = false;
		boolean eleviParticipanti = false;
		boolean dataDesfasurare = false;
		boolean taxa = false;
		boolean termenLimitaInscriere = false;
		boolean nrMaximParticipanti = false;
		boolean oraIncepere = false;
		boolean stare = false;
		if(clasaWorkshop.getSuperclass()!=null) {
			fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
		}
		for(Field f : fields) {
			if(f.getName().equals("nume")) {
				nume = true;
			}
			if(f.getName().equals("responsabil")) {
				responsabil = true;
			}
			if(f.getName().equals("eleviParticipanti")) {
				eleviParticipanti = true;
			}
			if(f.getName().equals("dataDesfasurare")) {
				dataDesfasurare = true;
			}
			if(f.getName().equals("taxa")) {
				taxa = true;
			}
			if(f.getName().equals("termenLimitaInscriere")) {
				termenLimitaInscriere = true;
			}
			if(f.getName().equals("nrMaximParticipanti")) {
				nrMaximParticipanti = true;
			}
			if(f.getName().equals("oraIncepere")) {
				oraIncepere = true;
			}
			if(f.getName().equals("stare")) {
				stare = true;
			}
			
		}
		if(nume && responsabil && eleviParticipanti && dataDesfasurare && taxa && termenLimitaInscriere
				&& nrMaximParticipanti && oraIncepere && stare) {
			ok = true;
		}
		assertTrue(ok);
	}
	
	@Test
	public void testExcursieMostenesteActivitate() {
		Class clasaExcursie = excursie.getClass();
		List<Field> fields = new ArrayList<Field>(); 
		Class superClass = clasaExcursie.getSuperclass();
		boolean ok = false;
		boolean nume = false;
		boolean responsabil = false;
		boolean eleviParticipanti = false;
		boolean dataDesfasurare = false;
		boolean taxa = false;
		boolean termenLimitaInscriere = false;
		boolean nrMaximParticipanti = false;
		boolean oraIncepere = false;
		boolean stare = false;
		if(clasaExcursie.getSuperclass()!=null) {
			fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
		}
		for(Field f : fields) {
			if(f.getName().equals("nume")) {
				nume = true;
			}
			if(f.getName().equals("responsabil")) {
				responsabil = true;
			}
			if(f.getName().equals("eleviParticipanti")) {
				eleviParticipanti = true;
			}
			if(f.getName().equals("dataDesfasurare")) {
				dataDesfasurare = true;
			}
			if(f.getName().equals("taxa")) {
				taxa = true;
			}
			if(f.getName().equals("termenLimitaInscriere")) {
				termenLimitaInscriere = true;
			}
			if(f.getName().equals("nrMaximParticipanti")) {
				nrMaximParticipanti = true;
			}
			if(f.getName().equals("oraIncepere")) {
				oraIncepere = true;
			}
			if(f.getName().equals("stare")) {
				stare = true;
			}
			
		}
		if(nume && responsabil && eleviParticipanti && dataDesfasurare && taxa && termenLimitaInscriere
				&& nrMaximParticipanti && oraIncepere && stare) {
			ok = true;
		}
		assertTrue(ok);
	}

}
