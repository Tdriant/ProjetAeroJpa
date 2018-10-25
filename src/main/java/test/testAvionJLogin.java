package test;

import static org.junit.Assert.*;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoLogin;
import dao.DaoLoginFactory;
import model.Login;
import util.Context;


public class testAvionJLogin {
	private static DaoLogin daoLogin;
	
	@BeforeClass
	public static void initiDaoPersonne() {
		daoLogin = DaoLoginFactory.getInstance();
	}

	@AfterClass
	public static void fermetureJpa() {
		Context.destroy();
	}

	@Test
	public void insert() {
		Login login = new Login("boubou", "azerty", false);
		daoLogin.create(login);
		assertNotNull(login.getId());
		
	}

//	@Test
//	public void findByKey() {
//		Personne p = new Stagiaire("find", "find");
//		daoPersonne.create(p);
//		assertNotNull(daoPersonne.findByKey(p.getId()));
//	}
//
//	@Test
//	public void update() {
//		Personne p = new Stagiaire("update", "update");
//		daoPersonne.create(p);
//		p = daoPersonne.findByKey(p.getId());
//		p.setNom("nom update");
//		daoPersonne.update(p);
//		assertEquals("nom update", daoPersonne.findByKey(p.getId()).getNom());
//	}
//
//	@Test
//	public void FindAll() {
//		assertNotNull(daoPersonne.findAll());
//	}
//
//	@Test
//	public void delete() {
//		Personne p = new Stagiaire("delete", "delete");
//		daoPersonne.create(p);
//		daoPersonne.delete(p);
//		assertNull(daoPersonne.findByKey(p.getId()));
//
//	}
//
//	@Test
//	public void deleteByKey() {
//		Personne p = new Stagiaire("delete", "delete");
//		daoPersonne.create(p);
//		daoPersonne.deleteByKey(p.getId());
//		assertNull(daoPersonne.findByKey(p.getId()));
//
//	}


}
