
package Control;

import Model.Produto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class ProdutoEJB {

    @PersistenceContext
    EntityManager em;

    public void salvar(Produto produto) {
        em.merge(produto);
    }

    public void apaga(Produto produto) {

        System.out.println("Vou apagar o produto " + produto.getDescricao() + " id=" + produto.getId());
        em.getTransaction().begin();
        em.remove(produto);
        em.getTransaction().commit();
    }

    public void edita(Produto produto) {
        em.getTransaction().begin();
        em.refresh(produto);
        em.getTransaction().commit();
    }

    public void findAll() {
        Query query = em.createQuery("SELECT u from Produto u");
    }
}
