package br.unipar.programacaointernet.pdvweb.controller.venda;

import br.unipar.programacaointernet.pdvweb.service.VendaService;
import br.unipar.programacaointernet.pdvweb.model.Venda;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "/api/vendas",
description = "Endpoints das vendas")
@RestController
@RequestMapping("/api/vendas")
public class VendaApiController {
    private final VendaService vendaService;

    public VendaApiController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @Operation(description = "Retorna todas as vendas")
    @GetMapping
    public ResponseEntity<List<Venda>> getVendas() {
        return ResponseEntity.ok(vendaService.getAllVendas());
    }

    @Operation(description = "Retorna a Venda pelo ID")
    @GetMapping(path = "/{idVenda}")
    public ResponseEntity<Venda> getVendaById(@PathVariable("idVenda") Integer idVenda) {
        return ResponseEntity.ok(vendaService.getVendaById(idVenda));
    }

    @Operation(description = "Salva a venda")
    @PostMapping(path = "/save")
    public ResponseEntity<Venda> saveVenda(@RequestBody Venda venda) {

        return ResponseEntity.ok(vendaService.saveVenda(venda));
    }

    @Operation(description = "Atualiza uma venda já existente")
    @PutMapping(path = "/save")
    public ResponseEntity<Venda> updateVenda(@RequestBody Venda venda) {
        return ResponseEntity.ok(vendaService.updateVenda(venda));
    }

    @Operation(description = "Deleta uma venda existente")
    @DeleteMapping(path = "/{idVenda}")
    public ResponseEntity<String> deleteVenda(@PathVariable("idVenda") Integer idVenda) {
        vendaService.deleteVenda(idVenda);
        return ResponseEntity.ok("Venda "+
                idVenda
                +" deletada com sucesso");
    }

}
