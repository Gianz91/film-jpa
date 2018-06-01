package film;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entytyManager.EntityManagerUtil;

public class FilmCrudImpl implements FilmCrud {

	public List<Film> findAllFilm() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query query = em.createNamedQuery(Film.FIND_ALL);
		return query.getResultList();
	}

	public Film saveFilm(Film movie) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(movie);
		em.getTransaction().commit();
		return movie;
	}

	public Film updateFilm(Film movie) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(movie);
		em.getTransaction().commit();
		return movie;
	}

	public Film findById(int id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		return em.find(Film.class, id);
	}

	@Override
	public List<Film> findAnimazione() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query query = em.createNamedQuery(Film.ANIMAZIONE);
		return query.getResultList();
	}

	@Override
	public List<Film> find3() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query query = em.createNamedQuery(Film.FIVEGUYS);
		return query.getResultList();
	}
	

}
