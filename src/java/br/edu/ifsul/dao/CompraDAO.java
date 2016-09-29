package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Compra;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.AssertFalse;

/**
 *
 * @author Érico
 */
@Stateless
public class CompraDAO implements Serializable {

    private List<Compra> lista;

    @PersistenceContext(unitName = "SW_Trabalho_Etapa1PU")
    private EntityManager em;

    public CompraDAO() {

    }

    public Compra inserir(Compra obj) throws Exception {
        em.persist(obj);
        return obj;
    }

    public Compra alterar(Compra obj) throws Exception {
        em.merge(obj);
        return obj;
    }

    public Boolean remover(Integer id) {
        try {
            Compra obj = em.find(Compra.class, id);
            em.merge(obj);
            em.remove(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Compra> getLista(){
        return em.createQuery("from Compra").getResultList();
    }

    public void setLista(List<Compra> lista) {
        this.lista = lista;
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }    
    
}
