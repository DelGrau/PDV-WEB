package br.unipar.programacaointernet.pdvweb.controller.venda;

import br.unipar.programacaointernet.pdvweb.service.VendaService;
import br.unipar.programacaointernet.pdvweb.model.Venda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class VendaWebController {
    private final VendaService vendaService;

    public VendaWebController(VendaService service) {
        this.vendaService = service;
    }

    @GetMapping(path = "/vendas")
    public String vendas(Model model,
                               @RequestParam(required = false, value = "data_inicial") String data_inicial,
                               @RequestParam(required = false, value = "data_final") String data_final) {

        System.out.println("Data Ini: " + data_inicial);
        System.out.println("Data Fin: " + data_final);

        if (data_inicial != null) {
            List<Venda> vendas = vendaService.getVendaByData(
                    LocalDate.parse(data_inicial),
                    LocalDate.parse(data_final));

            model.addAttribute("vendas", vendas);

        } else {
            List<Venda> vendas = vendaService.getAllVendas();
            model.addAttribute("vendas", vendas);
        }

        return "telaprincipal";
    }
}
