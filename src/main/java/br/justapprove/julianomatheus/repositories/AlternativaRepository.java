package br.justapprove.julianomatheus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.justapprove.julianomatheus.models.Alternativa;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Integer> {

}
