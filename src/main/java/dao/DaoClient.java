package dao;

import java.util.List;

import model.Client;

public interface DaoClient extends DaoGeneric<Client, Integer>{
	List<Client> findByKeyWithReservation(Integer key);
}
