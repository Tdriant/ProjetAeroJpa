import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoVille;
import dao.DaoVilleFactory;
import model.Ville;
import util.Context;

public class villeTestSimple {

	private static DaoVille daoVille;

	@BeforeClass
	public static void initDaoVille() {

		daoVille = DaoVilleFactory.getInstance();

	}

	@AfterClass
	public static void fermeturJpa() {

		Context.destroy();

	}

	@Test
	public void insert() {

		Ville paris;

		paris = new Ville("paris");

		assertNull(paris.getId());

		daoVille.create(paris);

		assertNotNull(paris.getId());

	}

	@Test

	public void findByKey() {

		Ville paris;

		paris = new Ville("paris");

		daoVille.create(paris);

		assertNotNull(daoVille.findByKey(paris.getId()));

	}

	@Test

	public void update() {

		Ville antony;

		antony = new Ville("antony");

		daoVille.create(antony);

		antony = daoVille.findByKey(antony.getId());

		antony.setNom("antony");

		daoVille.update(antony);

		assertEquals("antony", daoVille.findByKey(antony.getId()).getNom());

	}

	@Test

	public void findAll() {

		assertNotNull(daoVille.findAll());

	}

	@Test

	public void delete() {

		Ville paris;

		paris = new Ville("paris");

		daoVille.create(paris);

		daoVille.delete(paris);

		assertNull(daoVille.findByKey(paris.getId()));

	}

	@Test

	public void deleteByKey() {

		Ville paris;

		paris = new Ville("paris");

		daoVille.create(paris);

		daoVille.deleteByKey(paris.getId());

		assertNull(daoVille.findByKey(paris.getId()));

	}

}
