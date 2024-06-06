package br.unipar.programacaointernet.pdvweb.repository;

import br.unipar.programacaointernet.pdvweb.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
        Cliente findClienteById(Integer id);
}
