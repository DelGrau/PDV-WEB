package br.unipar.programacaointernet.pdvweb.service;

import br.unipar.programacaointernet.pdvweb.model.Item_Venda;
import br.unipar.programacaointernet.pdvweb.model.Venda;
import br.unipar.programacaointernet.pdvweb.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    public VendaService (VendaRepository repository) {
        this.vendaRepository = repository;
    }

    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Venda getVendaById(Integer id) {
        return vendaRepository.findVendaById(id);
    }

    public List<Venda> getVendaByData(LocalDate dataInicial, LocalDate dataFinal) {
        return vendaRepository.findVendaByData(dataInicial, dataFinal);
    }

    public Venda saveVenda(Venda venda) {
        for (Item_Venda iv : venda.getItem_venda()) {
            iv.setVenda(venda);
        }
        return vendaRepository.save(venda);
    }

    public Venda updateVenda(Venda venda) {
        for (Item_Venda iv : venda.getItem_venda()) {
            iv.setVenda(venda);
        }
        return vendaRepository.save(venda);
    }

    public void deleteVenda(Integer id) {
        Venda venda = vendaRepository.findVendaById(id);
        vendaRepository.delete(venda);

    }
}
