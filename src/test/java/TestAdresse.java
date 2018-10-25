import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoAdresse;
import dao.DaoAdresseFactory;
import model.Adresse;
import util.Context;


public class TestAdresse {

	private static DaoAdresse daoadresse;

	@BeforeClass
	public static void initDaoRealisateur() {
		daoadresse = DaoAdresseFactory.getInstance();
	}

	@AfterClass
	public static void fermeturJpa() {
		Context.destroy();
	}

	@Test
	public void insert() {
		Adresse a1;
		a1 = new Adresse(5, "rue du bac", "75009", "Paris", "France");
		assertNull(a1.getId());
		daoadresse.create(a1);
		assertNotNull(a1.getId());
	}

	@Test
	public void findByKey() {
		Adresse a2;
		a2 = new Adresse(4, "rue Marc Sangnier", "94700", "Maisons-Alfort", "Ecosse");
		daoadresse.create(a2);
		assertNotNull(daoadresse.findByKey(a2.getId()));
	}

	@Test
	public void update() {
		Adresse a3;
		a3 = new Adresse(25, "rue Adrien Damalix", "94410", "Saint-Maurice", "Espagne");
		daoadresse.create(a3);
		a3 = daoadresse.findByKey(a3.getId());
		a3.setCodePostal("joinville-le-pont");
		daoadresse.update(a3);
		assertEquals("joinville-le-pont", daoadresse.findByKey(a3.getId()).getCodePostal());
	}

//	@Test
//	public void findAll() {
//		assertNotNull(daoRealisateur.findAll());
//	}
//
//	@Test
//	public void delete() {
//		Realisateur ryan;
//		ryan = new Realisateur("ryan", "johnson");
//		daoRealisateur.create(ryan);
//		daoRealisateur.delete(ryan);
//		assertNull(daoRealisateur.findByKey(ryan.getId()));
//	}
//
//	@Test
//	public void deleteByKey() {
//		Realisateur ryan;
//		ryan = new Realisateur("ryan", "johnson");
//		daoRealisateur.create(ryan);
//		daoRealisateur.create(ryan);
//		daoRealisateur.deleteByKey(ryan.getId());
//		assertNull(daoRealisateur.findByKey(ryan.getId()));
//
//	}
}
