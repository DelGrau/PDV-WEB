package br.unipar.programacaointernet.pdvweb.controller;

import br.unipar.programacaointernet.pdvweb.Service.ClienteService;
import br.unipar.programacaointernet.pdvweb.model.Cliente;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
@Tag(name = "/clientecontrollerapi")
@Controller
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Cliente>> GetAll(){
        return ResponseEntity.ok(clienteService.Todos());
    }

    @PostMapping(path = "/getbyid")
    public  ResponseEntity<Cliente> GetById(@RequestBody Integer id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity Delete(@RequestBody Cliente cliente)
    {
        clienteService.buscarPorId(cliente.getId());
        return ResponseEntity.ok("Cliente "+cliente.getNome()+" deletado com sucesso!");
    }
    @PostMapping(path = "/save")
    public ResponseEntity Save(@RequestBody Cliente cliente){
        if(clienteService.buscarPorId(cliente.getId()) == null){
            Cliente cli =  new Cliente();
            cli.setNome(cliente.getNome());
            cli.setEmail(cliente.getEmail());
            cli.setTelefone(cliente.getTelefone());
            clienteService.salvar(cli);
            return ResponseEntity.ok("Cliente "+cliente.getNome()+" salvo com sucesso!");
        }else{
            clienteService.salvar(cliente);
            return ResponseEntity.ok("Cliente "+cliente.getNome()+" atualizado com sucesso!");
        }
    }

}
