package br.com.solutis.treinamento.repository;

import br.com.solutis.treinamento.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query("select c from Conta c where month(c.dataCriacao) = :mes")
    List<Conta> findAllByMes(@Param("mes") Integer mes);

}
