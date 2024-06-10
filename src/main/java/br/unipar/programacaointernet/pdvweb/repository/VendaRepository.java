package br.unipar.programacaointernet.pdvweb.repository;

import br.unipar.programacaointernet.pdvweb.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
    Venda findVendaById(Integer id);

    @Query(value = "SELECT v.id, v.observacoes, v.data, v.total, v.cliente, v.item_venda FROM Venda v WHERE v.data BETWEEN ?1 AND ?2")
    List<Venda> findVendaByData(LocalDate dataInicial, LocalDate dataFinal);
}