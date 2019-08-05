package br.com.solutis.treinamento.repository;

import br.com.solutis.treinamento.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
