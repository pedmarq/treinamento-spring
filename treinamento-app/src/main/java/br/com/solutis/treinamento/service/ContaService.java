package br.com.solutis.treinamento.service;

import br.com.solutis.treinamento.model.dto.ContaUpdateDTO;
import br.com.solutis.treinamento.model.entity.Conta;
import br.com.solutis.treinamento.model.enums.ContaCicloEnum;
import br.com.solutis.treinamento.model.enums.ContaTipoEnum;
import br.com.solutis.treinamento.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ContaService{

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getContas() {
        return contaRepository.findAll();
    }

    public ResponseEntity<Object[]> getContasMes(Integer mes) {
        List<Conta> contas = contaRepository.findAllByMes(mes);
        BigDecimal saldo = new BigDecimal(0);
        for (Conta conta : contas) {
            saldo = conta.getTipo().equals(ContaTipoEnum.RECEBER) ? saldo.add(conta.getValor()) : saldo.subtract(conta.getValor());
        }
        return ResponseEntity.ok(new Object[]{saldo, contas});
    }

    public Long insertConta(Conta conta) {
        LocalDate today = LocalDate.now();
        conta.setDataCriacao(today);
        Long idPirmeiraParcela = contaRepository.save(conta).getId();
        if(conta.getCiclo().equals(ContaCicloEnum.PARCELADA)) {
            for (int i = 1; i < conta.getParcelas(); i++) {
                conta = new Conta(null,
                        conta.getNome(),
                        conta.getTipo(),
                        conta.getCiclo(),
                        conta.getParcelas(),
                        conta.getValor(),
                        today.plusMonths(i),
                        idPirmeiraParcela);
                contaRepository.save(conta);
            }
        }
        return idPirmeiraParcela;
    }

    public ResponseEntity<String> updateConta(Long id, ContaUpdateDTO conta) {
        Conta contaBanco = contaRepository.findById(id).orElse(new Conta());
        if(contaBanco.getId() == null) {
            return new ResponseEntity<>("Conta not found", HttpStatus.NOT_FOUND);
        }

        if(!contaBanco.getCiclo().equals(ContaCicloEnum.PERMANENTE)) {
            return new ResponseEntity<>("Conta not PERMANENTE", HttpStatus.BAD_REQUEST);
        }
        contaBanco.setNome(conta.getNome() != null ? conta.getNome() : contaBanco.getNome());
        contaBanco.setValor(conta.getValor() != null ? conta.getValor() : contaBanco.getValor());
        contaBanco.setDataCriacao(conta.getDataCriacao() != null ? conta.getDataCriacao() : contaBanco.getDataCriacao());
        contaRepository.saveAndFlush(contaBanco);

        return ResponseEntity.ok("Updated");
    }
}
