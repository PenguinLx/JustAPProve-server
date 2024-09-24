package br.justapprove.julianomatheus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.justapprove.julianomatheus.models.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

}
