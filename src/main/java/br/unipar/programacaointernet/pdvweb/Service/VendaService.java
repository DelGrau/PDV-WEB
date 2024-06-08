package br.unipar.programacaointernet.pdvweb.Service;

import br.unipar.programacaointernet.pdvweb.model.Venda;
import br.unipar.programacaointernet.pdvweb.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VendaService {
    private VendaRepository vendaRepository;

    public VendaService (VendaRepository repository) {
        this.vendaRepository = repository;
    }

    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Venda getVendaById(Integer id) {
        return vendaRepository.findVendaById(id);
    }

    public Venda saveVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda updateVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public void deleteVenda(Integer id) {
        Venda venda = vendaRepository.findVendaById(id);
        vendaRepository.delete(venda);

    }
}
