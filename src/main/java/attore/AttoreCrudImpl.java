package attore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entytyManager.EntityManagerUtil;

public class AttoreCrudImpl implements AttoreCrud {

	public List<Attore> findAllAttori() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query query = em.createNamedQuery(Attore.FIND_ALL);
		return query.getResultList();
	}
	public List<Attore> findMinorenni(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query query = em.createNamedQuery(Attore.MILLENIALS);
		return query.getResultList();
	}

	public Attore saveAttore(Attore actor) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(actor);
		em.getTransaction().commit();
		return actor;
	}

	public Attore updateAttore(Attore actor) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(actor);
		em.getTransaction().commit();
		return actor;
	}

	public Attore findById(int id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		return em.find(Attore.class, id);
	}

}
