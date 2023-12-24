package br.com.tales.testes;

import br.com.tales.dao.CategoriaDao;
import br.com.tales.dao.ProdutoDao;
import br.com.tales.model.Categoria;
import br.com.tales.model.Produto;
import br.com.tales.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("celulares");
        todos.forEach(p2 -> System.out.println(p2.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("REDMI NOTE 8");
        System.out.println("preco do produto -> " + precoDoProduto);
    }

    private static void cadastrarProduto(){
        Categoria celulares = new Categoria("celulares");
        Produto celular = new Produto("REDMI NOTE 8","muito legal", new BigDecimal(800), celulares);

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();

    }
}
