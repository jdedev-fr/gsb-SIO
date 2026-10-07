package fr.gsb.gsb_fiche_spring.model;

import fr.gsb.gsb_fiche_spring.entities.FicheDeFrais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface FraisRepository extends JpaRepository<FicheDeFrais,String> {
}
