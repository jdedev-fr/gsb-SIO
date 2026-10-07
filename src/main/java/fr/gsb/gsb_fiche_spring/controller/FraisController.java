package fr.gsb.gsb_fiche_spring.controller;

import fr.gsb.gsb_fiche_spring.dto.FraisServiceDTO;
import fr.gsb.gsb_fiche_spring.service.IFraisService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FraisController {
    private IFraisService service;

    FraisController(IFraisService service) {
        this.service=service;
    }

    @GetMapping(value="/api/fiches-frais")
    public List<FraisServiceDTO> getToutesLesFiches(){
        return service.getFiches();
    }

    @GetMapping(value="/api/fiches-frais/{id}")
    public FraisServiceDTO getFicheParId(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping(value="/api/fiches-frais")
    public  String ajoutFiche(@Valid @RequestBody FraisServiceDTO fiche){
        service.addFiche(fiche);
        return "requete OK";
    }
}
