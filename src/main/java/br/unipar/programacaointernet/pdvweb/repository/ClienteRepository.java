package br.unipar.programacaointernet.pdvweb.repository;

import br.unipar.programacaointernet.pdvweb.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
        List<Cliente> findAll(Cliente cliente);
        Cliente findClienteById(Integer id);
        void saveCliente(Cliente cliente);
        void deleteCliente(Cliente cliente);
}
