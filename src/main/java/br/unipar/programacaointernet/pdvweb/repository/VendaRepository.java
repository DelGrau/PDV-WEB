package br.unipar.programacaointernet.pdvweb.repository;

import br.unipar.programacaointernet.pdvweb.model.Venda;

import java.util.List;

public interface VendaRepository {
    List<Venda> findAllVendas();
    Venda findVendaById(Integer id);
    Venda saveVenda(Venda venda);
    Venda updateVenda(Venda venda);
    void deleteVenda(Venda venda);

}
