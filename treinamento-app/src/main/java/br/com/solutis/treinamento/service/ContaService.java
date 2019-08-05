package br.com.solutis.treinamento.service;

import br.com.solutis.treinamento.model.Conta;
import br.com.solutis.treinamento.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService{

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getContas() {
        return contaRepository.findAll();
    }
}
