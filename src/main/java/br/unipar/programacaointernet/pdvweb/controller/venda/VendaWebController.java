package br.unipar.programacaointernet.pdvweb.controller.venda;

import br.unipar.programacaointernet.pdvweb.Service.VendaService;
import br.unipar.programacaointernet.pdvweb.model.Venda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VendaWebController {
    private final VendaService vendaService;

    public VendaWebController(VendaService service) {
        this.vendaService = service;
    }

    @GetMapping(path = "/vendas")
    public String vendas(Model model) {

        List<Venda> vendas = vendaService.getAllVendas();
        model.addAttribute("vendas", vendas);

        return "telaprincipal";
    }
}
