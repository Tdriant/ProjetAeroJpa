package model;
import dao.DaoAeroport;
import dao.DaoAeroportFactory;
import util.Context;

public class AeroportTestSimple {

	private static DaoAeroport daoAeroport;

@BeforeClass
	public static void initDaoAeroport() {

		daoAeroport = DaoAeroportFactory.getInstance();

	}

@AfterClass
	public static void fermeturJpa() {

		Context.destroy();

	}

@Test
	public void insert() {

		Aeroport cdg;

		cdg = new Aeroport("cdg");

		assertNull(georges.getId());

		daoAeroport.create(georges);

		assertNotNull(georges.getId());

	}

	@Test

	public void findByKey() {

		Aeroport irving;

		irving = new Aeroport("irving", "kershner");

		daoAeroport.create(irving);

		assertNotNull(daoAeroport.findByKey(irving.getId()));

	}

	@Test

	public void update() {

		Aeroport jj;

		jj = new Aeroport("jj", "abrahams");

		daoAeroport.create(jj);

		jj = daoAeroport.findByKey(jj.getId());

		jj.setNom("abrams");

		daoAeroport.update(jj);

		assertEquals("abrams", daoAeroport.findByKey(jj.getId()).getNom());

	}

	@Test

	public void findAll() {

		assertNotNull(daoAeroport.findAll());

	}

	@Test

	public void delete() {

		Aeroport ryan;

		ryan = new Aeroport("ryan", "johnson");

		daoAeroport.create(ryan);

		daoAeroport.delete(ryan);

		assertNull(daoAeroport.findByKey(ryan.getId()));

	}

	@Test

	public void deleteByKey() {

		Aeroport ryan;

		ryan = new Aeroport("ryan", "johnson");

		daoAeroport.create(ryan);

		daoAeroport.create(ryan);

		daoAeroport.deleteByKey(ryan.getId());

		assertNull(daoAeroport.findByKey(ryan.getId()));

	}

}
