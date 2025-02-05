package br.justapprove.julianomatheus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.justapprove.julianomatheus.models.Materia;
import br.justapprove.julianomatheus.models.TipoMateria;
import org.springframework.data.domain.Sort;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

	List<Materia> findByTipo(TipoMateria tipo, Sort sort);
}
