package br.justapprove.julianomatheus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.justapprove.julianomatheus.models.Materia;
import br.justapprove.julianomatheus.models.Material;
import br.justapprove.julianomatheus.models.TipoMateria;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
	
	List<Material> findByTipo(TipoMateria tipo);
}
