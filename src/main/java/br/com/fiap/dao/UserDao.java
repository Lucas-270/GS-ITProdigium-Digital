package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.User;
import br.com.fiap.util.EntityManagerFacade;

public class UserDao {

	private EntityManager manager = EntityManagerFacade.get();
	
	public void save(User user) {
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();

		manager.close();
	}
	
	public List<User> getAll(){
		String jpql = "Select u From User u";
		TypedQuery<User> createQuery = manager.createQuery(jpql, User.class);
		return createQuery.getResultList();
	}
}
