package br.com.fiap.dao;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.PontoTuristico;
import br.com.fiap.model.User;
import br.com.fiap.util.EntityManagerFacade;

public class PontoTuristicoDao {

	private EntityManager manager = EntityManagerFacade.get();
	
	private FacesContext context = FacesContext.getCurrentInstance();
	
	public void save(PontoTuristico ponto) {
		User userSession = (User) context.getExternalContext().getSessionMap().get("user");
		UserDao userDao = new UserDao();
		User user = userDao.findByEmail(userSession.getEmail());
		
		ponto.setIdUser(user.getId());
		
		manager.getTransaction().begin();
		manager.persist(ponto);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	public void saveApi(PontoTuristico ponto) {
		manager.getTransaction().begin();
		manager.persist(ponto);
		manager.getTransaction().commit();
		
		manager.close();
	}


	public List<PontoTuristico> getAll() {
		String jpql = "SELECT p from PontoTuristico p";
		TypedQuery<PontoTuristico> createQuery = manager.createQuery(jpql, PontoTuristico.class);
		return createQuery.getResultList();
	}
	
	public List<PontoTuristico> getAllPerUser() {
		User userSession = (User) context.getExternalContext().getSessionMap().get("user");
		UserDao userDao = new UserDao();
		User user = userDao.findByEmail(userSession.getEmail());
		
		String jpql = "SELECT p from PontoTuristico p where idUser = :idUser";
		TypedQuery<PontoTuristico> createQuery = manager.createQuery(jpql, PontoTuristico.class);
		createQuery.setParameter("idUser", user.getId());
		return createQuery.getResultList();
	}

	public PontoTuristico findById(Long id) {
		return manager.find(PontoTuristico.class, id);
	}

	public void update(PontoTuristico ponto) {
		manager.getTransaction().begin();
		manager.merge(ponto);
		manager.flush();
		manager.getTransaction().commit();
	}
	
	public void delete(PontoTuristico ponto) {
		manager.getTransaction().begin();
		manager.remove(ponto);
		manager.flush();
		manager.getTransaction().commit();
	}

}
