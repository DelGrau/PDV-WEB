package br.unipar.programacaointernet.pdvweb.controller;

import br.unipar.programacaointernet.pdvweb.service.ProdutoService;
import br.unipar.programacaointernet.pdvweb.model.Produto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "/api/produto")
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoService.listar());
    }

    @PostMapping(path = "/getById")
    public ResponseEntity<Produto> getById(@RequestParam Integer id) {
        Produto produto = produtoService.buscarPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> delete(@RequestBody Produto produto) {
        Produto prod = produtoService.buscarPorId(produto.getId());
        if (prod != null) {
            produtoService.excluir(prod);
            return ResponseEntity.ok("Produto " + prod.getDescricao() + " deletado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/save")
    public ResponseEntity<String> save(@RequestBody Produto produto) {
        Produto existingProduto = produtoService.buscarPorId(produto.getId());
        if (existingProduto == null) {
            Produto newProd = new Produto();
            newProd.setDescricao(produto.getDescricao());
            newProd.setValor(produto.getValor());
            newProd.setCategoria(produto.getCategoria());
            produtoService.salvar(newProd);
            return ResponseEntity.ok("Produto " + produto.getDescricao() + " salvo com sucesso!");
        } else {
            produtoService.salvar(produto);
            return ResponseEntity.ok("Produto " + produto.getDescricao() + " atualizado com sucesso!");
        }
    }
}
