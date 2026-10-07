package fr.gsb.gsb_fiche_spring.service;

import fr.gsb.gsb_fiche_spring.dto.FraisServiceDTO;
import fr.gsb.gsb_fiche_spring.entities.FicheDeFrais;
import fr.gsb.gsb_fiche_spring.model.FraisRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@Profile("dev")
public class FraisService implements IFraisService {

    private FraisRepository repo;

    public FraisService(FraisRepository repo) {
       this.repo = repo;
    }

    @Override
    public List<FraisServiceDTO> getFiches() {

        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public FraisServiceDTO getById(Integer id){
        FicheDeFrais entity = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fiche de frais introuvable avec l'id : " + id));

        return toDTO(entity);
    }

    @Override
    public void addFiche(FraisServiceDTO fiche){
        repo.save(new FicheDeFrais(fiche.getMois(), fiche.getNbJustificatifs(), fiche.getMontantValide()));
    }

    private FicheDeFrais toEntity(FraisServiceDTO dto) {
        return new FicheDeFrais(
                dto.getMois(),
                dto.getNbJustificatifs(),
                dto.getMontantValide()
        );
    }

    private FraisServiceDTO toDTO(FicheDeFrais entity) {
        return new FraisServiceDTO(
                entity.getId(),
                entity.getMois(),
                entity.getNbJustificatifs(),
                entity.getMontantValide()
        );
    }
}
