package br.com.solutis.treinamento.service;

import br.com.solutis.treinamento.model.entity.Conta;
import br.com.solutis.treinamento.model.enums.ContaCicloEnum;
import br.com.solutis.treinamento.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContaService{

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getContas() {
        return contaRepository.findAll();
    }

    public List<Conta> getContasMes(Integer mes) {
        return contaRepository.findAllByMes(mes);
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
}
