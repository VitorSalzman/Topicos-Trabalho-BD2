/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.ControladoresJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.ControladoresJPA.exceptions.NonexistentEntityException;
import persistencia.EstadoSol;

/**
 *
 * @author luizg
 */
public class EstadoSolJpaController implements Serializable {

    public EstadoSolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstadoSol estadoSol) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estadoSol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadoSol estadoSol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estadoSol = em.merge(estadoSol);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = estadoSol.getId();
                if (findEstadoSol(id) == null) {
                    throw new NonexistentEntityException("The estadoSol with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstadoSol estadoSol;
            try {
                estadoSol = em.getReference(EstadoSol.class, id);
                estadoSol.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadoSol with id " + id + " no longer exists.", enfe);
            }
            em.remove(estadoSol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadoSol> findEstadoSolEntities() {
        return findEstadoSolEntities(true, -1, -1);
    }

    public List<EstadoSol> findEstadoSolEntities(int maxResults, int firstResult) {
        return findEstadoSolEntities(false, maxResults, firstResult);
    }

    private List<EstadoSol> findEstadoSolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadoSol.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public EstadoSol findEstadoSol(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadoSol.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadoSolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadoSol> rt = cq.from(EstadoSol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}