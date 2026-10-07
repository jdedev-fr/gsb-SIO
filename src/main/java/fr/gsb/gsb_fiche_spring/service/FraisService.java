package fr.gsb.gsb_fiche_spring.service;

import fr.gsb.gsb_fiche_spring.dto.FraisServiceDTO;

import java.util.List;

public interface FraisService {
    List<FraisServiceDTO> getFiches();
    FraisServiceDTO getById(String id);
    void addFiche(FraisServiceDTO fiche);
}
