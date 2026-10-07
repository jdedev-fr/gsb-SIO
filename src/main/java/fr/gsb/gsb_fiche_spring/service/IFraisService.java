package fr.gsb.gsb_fiche_spring.service;

import fr.gsb.gsb_fiche_spring.dto.FraisServiceDTO;

import java.util.List;

public interface IFraisService {
    List<FraisServiceDTO> getFiches();
    FraisServiceDTO getById(Integer id);
    void addFiche(FraisServiceDTO fiche);
}
