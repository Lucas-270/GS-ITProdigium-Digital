package br.com.fiap.dao;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.PesquisaSatisfacao;
import br.com.fiap.model.User;
import br.com.fiap.util.EntityManagerFacade;

public class PesquisaSatisfacaoDao {

	private EntityManager manager = EntityManagerFacade.get();
	
	private FacesContext context = FacesContext.getCurrentInstance();
	
	public void save(PesquisaSatisfacao pesquisa) {
		User userSession = (User) context.getExternalContext().getSessionMap().get("user");
		UserDao userDao = new UserDao();
		User user = userDao.findByEmail(userSession.getEmail());
		
		pesquisa.setIdUser(user.getId());
		
		manager.getTransaction().begin();
		manager.persist(pesquisa);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	public void saveApi(PesquisaSatisfacao pesquisa) {
		manager.getTransaction().begin();
		manager.persist(pesquisa);
		manager.getTransaction().commit();
		
		manager.close();
	}

	public List<PesquisaSatisfacao> getAll() {
		String jpql = "SELECT s from PesquisaSatisfacao s";
		TypedQuery<PesquisaSatisfacao> createQuery = manager.createQuery(jpql, PesquisaSatisfacao.class);
		return createQuery.getResultList();
	}
	
	public List<PesquisaSatisfacao> getAllPerUser() {
		User userSession = (User) context.getExternalContext().getSessionMap().get("user");
		UserDao userDao = new UserDao();
		User user = userDao.findByEmail(userSession.getEmail());
		
		String jpql = "SELECT s from PesquisaSatisfacao s where idUser = :idUser";
		TypedQuery<PesquisaSatisfacao> createQuery = manager.createQuery(jpql, PesquisaSatisfacao.class);
		createQuery.setParameter("idUser", user.getId());
		return createQuery.getResultList();
	}

	public PesquisaSatisfacao findById(Long id) {
		return manager.find(PesquisaSatisfacao.class, id);
	}

	public void update(PesquisaSatisfacao pesquisa) {
		manager.getTransaction().begin();
		manager.merge(pesquisa);
		manager.flush();
		manager.getTransaction().commit();
	}
	
	public void delete(PesquisaSatisfacao pesquisa) {
		manager.getTransaction().begin();
		manager.remove(pesquisa);
		manager.flush();
		manager.getTransaction().commit();
	}

}
