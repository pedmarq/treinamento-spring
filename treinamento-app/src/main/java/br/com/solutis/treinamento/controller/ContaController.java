package br.com.solutis.treinamento.controller;

import br.com.solutis.treinamento.model.dto.ContaUpdateDTO;
import br.com.solutis.treinamento.model.entity.Conta;
import br.com.solutis.treinamento.service.ContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@Api(value = "Conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @ApiOperation("Gets list of Contas")
    @GetMapping(value = "/contas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Conta> getContas() {
        return contaService.getContas();
    }

    @ApiOperation("Gets list of Contas of month \"mes\"")
    @GetMapping(value = "/contas/{mes}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object[]> getContasMes(@PathVariable("mes") Integer mes) { return contaService.getContasMes(mes); }

    @ApiOperation("Inserts new Conta")
    @PostMapping("/conta")
    public Long insertConta(@RequestBody Conta conta) { return contaService.insertConta(conta); }

    @ApiOperation("Updates Contas permanentes")
    @PutMapping("/conta/{id}")
    public ResponseEntity<String> updateConta(@PathVariable("id") Long id, @RequestBody ContaUpdateDTO contaUpdateDTO) { return contaService.updateConta(id, contaUpdateDTO); }
}
