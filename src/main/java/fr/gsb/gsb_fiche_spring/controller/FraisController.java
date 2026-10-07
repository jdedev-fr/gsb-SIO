package fr.gsb.gsb_fiche_spring.controller;

import fr.gsb.gsb_fiche_spring.dto.FraisServiceDTO;
import fr.gsb.gsb_fiche_spring.entities.FicheDeFrais;
import fr.gsb.gsb_fiche_spring.service.FraisService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FraisController {
    private FraisService service;

    FraisController(FraisService service) {
        this.service=service;
    }

    @GetMapping(value="/api/fiches-frais")
    public List<FraisServiceDTO> getToutesLesFiches(){
        return service.getFiches();
    }

    @GetMapping(value="/api/fiches-frais/{id}")
    public FraisServiceDTO getFicheParId(@PathVariable String id){
        return service.getById(id);
    }

    @PostMapping(value="/api/fiches-frais")
    public  String ajoutFiche(@Valid @RequestBody FraisServiceDTO fiche){
        service.addFiche(fiche);
        return "requete OK";
    }
}
