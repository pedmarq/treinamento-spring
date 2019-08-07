package br.com.solutis.treinamento.controller;

import br.com.solutis.treinamento.model.entity.Conta;
import br.com.solutis.treinamento.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping("/contas")
    public List<Conta> getContas() {
        return contaService.getContas();
    }

    @GetMapping("/contas/{mes}")
    public List<Conta> getContasMes(@PathVariable("mes") Integer mes) { return contaService.getContasMes(mes); }

    @PostMapping("/conta")
    public Long insertConta(@RequestBody Conta conta) { return contaService.insertConta(conta); }
}
