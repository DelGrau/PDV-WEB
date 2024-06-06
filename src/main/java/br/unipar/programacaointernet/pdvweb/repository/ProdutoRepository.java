package br.unipar.programacaointernet.pdvweb.repository;

import br.unipar.programacaointernet.pdvweb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Produto findProdutoById(Integer id);
}