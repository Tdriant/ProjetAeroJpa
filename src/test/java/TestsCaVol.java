import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoCAVol;
import dao.DaoCAVolFactory;
import dao.DaoCompagnieAerienne;
import dao.DaoCompagnieAerienneFactory;
import dao.DaoVol;
import dao.DaoVolFactory;
import model.CompagnieAerienne;
import model.CompagnieAerienneVol;
import model.CompagnieAerienneVolKey;
import model.Vol;
import util.Context;

public class TestsCaVol {

	private static DaoCAVol daoCAVol;
	private static DaoVol daoVol;
	private static DaoCompagnieAerienne daoCompagnieAerienne;
	private static Vol v1;
	private static Vol v2;
	private static CompagnieAerienne ca1;
	private static CompagnieAerienne ca2;

	@BeforeClass
	public static void initDaoCAVol() {
		daoCAVol = DaoCAVolFactory.getInstance();
		daoVol = DaoVolFactory.getInstance();
		daoCompagnieAerienne = DaoCompagnieAerienneFactory.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("DD/MM/YYYY");
		SimpleDateFormat heure = new SimpleDateFormat("HH-mm-ss");
		try {
			v1 = new Vol(date.parse("26/10/2018"), date.parse("27/10/2018"), heure.parse("11-50-00"), heure.parse("06-45-00"));
			v2 = new Vol(date.parse("15/05/2009"), date.parse("15/05/2009"), heure.parse("06-05-00"), heure.parse("12-30-00"));
			ca1 = new CompagnieAerienne("air france");
			ca2 = new CompagnieAerienne("delta");
			assertNull(v1.getId());
			assertNull(v2.getId());
			assertNull(ca1.getId());
			assertNull(ca2.getId());
			daoVol.create(v1);
			daoVol.create(v2);
			daoCompagnieAerienne.create(ca1);
			daoCompagnieAerienne.create(ca2);
			assertNotNull(v1.getId());
			assertNotNull(v2.getId());
			assertNotNull(ca1.getId());
			assertNotNull(ca2.getId());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void fermeturJpa() {
		Context.destroy();
	}

	@Test
	public void insert() {
		CompagnieAerienneVol cav1 = new CompagnieAerienneVol(new CompagnieAerienneVolKey(ca1, v1));
		assertNotNull(cav1.getKey());
		assertNotNull(cav1.getKey().getVol());
		assertNotNull(cav1.getKey().getCompagnieAerienne());
		daoCAVol.create(cav1);
	}

	@Test
	public void findByKey() {
		CompagnieAerienneVol cav2 = new CompagnieAerienneVol(new CompagnieAerienneVolKey(ca2, v2));
		daoCAVol.create(cav2);
		assertNotNull(daoCAVol.findByKey(new CompagnieAerienneVolKey(cav2.getKey().getCompagnieAerienne(), cav2.getKey().getVol())));
	}

//	@Test
//	public void update() {
//		Adresse a3;
//		a3 = new Adresse(25, "rue Adrien Damalix", "94410", "Saint-Maurice", "Espagne");
//		daoadresse.create(a3);
//		a3 = daoadresse.findByKey(a3.getId());
//		a3.setCodePostal("94850");
//		daoadresse.update(a3);
//		assertEquals("94850", daoadresse.findByKey(a3.getId()).getCodePostal());
//	}
//
//	@Test
//	public void findAll() {
//		assertNotNull(daoadresse.findAll());
//	}
//
//	@Test
//	public void delete() {
//		Adresse a4;
//		a4 = new Adresse(95, "rue du four", "77055", "Creil", "Finlande");
//		daoadresse.create(a4);
//		daoadresse.delete(a4);
//		assertNull(daoadresse.findByKey(a4.getId()));
//	}
//
//	@Test
//	public void deleteByKey() {
//		Adresse a5;
//		a5 = new Adresse(155, "rue du sport", "93420", "Bobigny", "Equateur");
//		daoadresse.create(a5);
//		daoadresse.create(a5);
//		daoadresse.deleteByKey(a5.getId());
//		assertNull(daoadresse.findByKey(a5.getId()));
//
//	}
}
