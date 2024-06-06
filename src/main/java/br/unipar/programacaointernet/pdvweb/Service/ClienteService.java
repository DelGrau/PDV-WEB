package br.unipar.programacaointernet.pdvweb.Service;

import br.unipar.programacaointernet.pdvweb.model.Cliente;
import br.unipar.programacaointernet.pdvweb.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listar() {return clienteRepository.findAll();}

    public Cliente buscarPorId(Integer id) {return clienteRepository.findClienteById(id);}
    public void salvar(Cliente cliente) {clienteRepository.save(cliente);}
    public void excluir(Cliente cliente) {clienteRepository.delete(cliente);}
    public List<Cliente> Todos() {return clienteRepository.findAll();}
}
