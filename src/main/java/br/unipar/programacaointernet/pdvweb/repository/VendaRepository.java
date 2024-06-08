package br.unipar.programacaointernet.pdvweb.repository;

import br.unipar.programacaointernet.pdvweb.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
    List<Venda> findAllVendas();
    Venda findVendaById(Integer id);
    Venda saveVenda(Venda venda);
    Venda updateVenda(Venda venda);
    void deleteVenda(Venda venda);

}
