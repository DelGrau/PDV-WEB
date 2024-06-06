package br.unipar.programacaointernet.pdvweb.repository;

import br.unipar.programacaointernet.pdvweb.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
    Venda findVendaById(Integer id);
}
