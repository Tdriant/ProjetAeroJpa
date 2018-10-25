

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
		Client client = new Client("tutu", 2022222222, 5284, "dlnvoqizsvb");
		daoClient.create(client);
		assertNotNull(client.getId());
		
	}

	@Test
	public void findByKey() {
		Client client = new Client("tutu", 2022222222, 5284, "dlnvoqizsvb");
		daoClient.create(client);
		assertNotNull(daoClient.findByKey(client.getId()));
	}

	@Test
	public void update() {
		Client client = new Client("tutu", 2022222222, 5284, "dlnvoqizsvb");
		daoClient.create(client);
		client = daoClient.findByKey(client.getId());
		client.setNom("coco");
		daoClient.update(client);
		assertEquals("coco", daoClient.findByKey(client.getId()).getNom());
	}

	@Test
	public void FindAll() {
		assertNotNull(daoClient.findAll());
	}

	@Test
	public void delete() {
		Client client = new Client("tutu", 2022222222, 5284, "dlnvoqizsvb");
		daoClient.create(client);
		daoClient.delete(client);
		assertNull(daoClient.findByKey(client.getId()));

	}

	@Test
	public void deleteByKey() {
		Client client = new Client("tutu", 2022222222, 5284, "dlnvoqizsvb");
		daoClient.create(client);
		daoClient.deleteByKey(client.getId());
		assertNull(daoClient.findByKey(client.getId()));

	}


}
