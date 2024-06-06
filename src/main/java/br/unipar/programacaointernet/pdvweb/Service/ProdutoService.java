package br.unipar.programacaointernet.pdvweb.Service;

import br.unipar.programacaointernet.pdvweb.model.Produto;
import br.unipar.programacaointernet.pdvweb.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Integer id) {
        return produtoRepository.findProdutoById(id);
    }

    public void salvar(Produto produto) {
        produtoRepository.save(produto);
    }

    public void excluir(Produto produto) {
        produtoRepository.delete(produto);
    }

    public List<Produto> Todos() {
        return produtoRepository.findAll();
    }
}
