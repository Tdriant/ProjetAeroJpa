import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
//
//import dao.DaoCAVol;
//import dao.DaoCAVolFactory;
import dao.DaoCompagnieAerienne;
import dao.DaoCompagnieAerienneFactory;
import dao.DaoVol;
import dao.DaoVolFactory;
import model.CompagnieAerienne;
import model.Vol;
import util.Context;

public class TestsCaVol {

//	private static DaoCAVol daoCAVol;
	private static DaoVol daoVol;
	private static DaoCompagnieAerienne daoCompagnieAerienne;

	@BeforeClass
	public static void initDaoCAVol() {
//		daoCAVol = DaoCAVolFactory.getInstance();
		daoVol = DaoVolFactory.getInstance();
		daoCompagnieAerienne = DaoCompagnieAerienneFactory.getInstance();
	}

	@AfterClass
	public static void fermeturJpa() {
		Context.destroy();
	}

	@Test
	public void insert() {
		Vol v1;
		Vol v2;
		CompagnieAerienne ca1;
		CompagnieAerienne ca2;
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
//		assertNull(v1.getId());
//		daoCAVol.create(v1);
//		assertNotNull(v1.getId());
	}

//	@Test
//	public void findByKey() {
//		Adresse a2;
//		a2 = new Adresse(4, "rue Marc Sangnier", "94700", "Maisons-Alfort", "Ecosse");
//		daoadresse.create(a2);
//		assertNotNull(daoadresse.findByKey(a2.getId()));
//	}
//
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
