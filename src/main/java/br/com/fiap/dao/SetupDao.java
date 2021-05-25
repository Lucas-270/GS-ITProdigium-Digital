package br.com.fiap.dao;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Setup;
import br.com.fiap.model.User;
import br.com.fiap.util.EntityManagerFacade;

public class SetupDao {

	private EntityManager manager = EntityManagerFacade.get();
	
	private FacesContext context = FacesContext.getCurrentInstance();

	private User userSession = (User) context.getExternalContext().getSessionMap().get("user");
	
	public void save(Setup setup) {
		UserDao userDao = new UserDao();
		User user = userDao.findByEmail(userSession.getEmail());
		
		setup.setIdUser(user.getId());
		
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();
		
		manager.close();
	}

	public List<Setup> getAll() {
		String jpql = "SELECT s from Setup s";
		TypedQuery<Setup> createQuery = manager.createQuery(jpql, Setup.class);
		return createQuery.getResultList();
	}
	
	public List<Setup> getAllPerUser() {
		UserDao userDao = new UserDao();
		User user = userDao.findByEmail(userSession.getEmail());
		
		String jpql = "SELECT s from Setup s where idUser = :idUser";
		TypedQuery<Setup> createQuery = manager.createQuery(jpql, Setup.class);
		createQuery.setParameter("idUser", user.getId());
		return createQuery.getResultList();
	}

	public Setup findById(Long id) {
		return manager.find(Setup.class, id);
	}

	public void update(Setup setup) {
		manager.getTransaction().begin();
		manager.merge(setup);
		manager.flush();
		manager.getTransaction().commit();
	}
	
	public void delete(Setup setup) {
		manager.getTransaction().begin();
		manager.remove(setup);
		manager.flush();
		manager.getTransaction().commit();
	}

}
