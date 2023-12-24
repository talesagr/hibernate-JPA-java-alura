package br.com.tales.dao;

import br.com.tales.model.Categoria;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
@AllArgsConstructor
public class CategoriaDao {

    private EntityManager em;

    public void cadastrar(Categoria categoria){
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria){
        this.em.merge(categoria);
    }
    public void remover(Categoria categoria){
        categoria = em.merge(categoria);
        this.em.remove(categoria);
    }
}
