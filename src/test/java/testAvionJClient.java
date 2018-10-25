

import static org.junit.Assert.*;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoClient;
import dao.DaoClientFactory;
import model.Client;
import util.Context;


public class testAvionJClient {
	private static DaoClient daoClient;
	
	@BeforeClass
	public static void initiDaoPersonne() {
		daoClient = DaoClientFactory.getInstance();
	}

	@AfterClass
	public static void fermetureJpa() {
		Context.destroy();
	}

	@Test
	public void insert() {
		Client client = new Cli;
		daoClient.create(Client);
		assertNotNull(Client.getId());
		
	}

	@Test
	public void findByKey() {
		Client Client = new Client("toto", "tata", true);
		daoClient.create(Client);
		assertNotNull(daoClient.findByKey(Client.getId()));
	}

	@Test
	public void update() {
		Client Client = new Client("tutu", "huhuhu", true);
		daoClient.create(Client);
		Client = daoClient.findByKey(Client.getId());
		Client.setClient("coco");
		daoClient.update(Client);
		assertEquals("coco", daoClient.findByKey(Client.getId()).getClient());
	}

	@Test
	public void FindAll() {
		assertNotNull(daoClient.findAll());
	}

	@Test
	public void delete() {
		Client Client = new Client("toto", "tata", true);
		daoClient.create(Client);
		daoClient.delete(Client);
		assertNull(daoClient.findByKey(Client.getId()));

	}

	@Test
	public void deleteByKey() {
		Client Client = new Client("toto", "tata", true);
		daoClient.create(Client);
		daoClient.deleteByKey(Client.getId());
		assertNull(daoClient.findByKey(Client.getId()));

	}


}
