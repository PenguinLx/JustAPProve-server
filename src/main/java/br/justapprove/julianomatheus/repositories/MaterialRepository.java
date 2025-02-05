package br.justapprove.julianomatheus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.justapprove.julianomatheus.models.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
	
}
