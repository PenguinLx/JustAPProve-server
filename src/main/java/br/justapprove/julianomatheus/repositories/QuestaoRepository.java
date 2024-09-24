package br.justapprove.julianomatheus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.justapprove.julianomatheus.models.Questao;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

}
