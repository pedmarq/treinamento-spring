package br.com.solutis.treinamento.controller;

import br.com.solutis.treinamento.model.Conta;
import br.com.solutis.treinamento.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
