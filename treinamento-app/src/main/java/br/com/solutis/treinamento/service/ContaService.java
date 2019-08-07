package br.com.solutis.treinamento.service;

import br.com.solutis.treinamento.model.entity.Conta;
import br.com.solutis.treinamento.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        conta.setDataCriacao(new Date());
        return contaRepository.save(conta).getId();
    }
}
