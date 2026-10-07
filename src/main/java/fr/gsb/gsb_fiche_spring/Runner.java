package fr.gsb.gsb_fiche_spring;

import fr.gsb.gsb_fiche_spring.dto.FraisServiceDTO;
import fr.gsb.gsb_fiche_spring.entities.Visiteur;
import fr.gsb.gsb_fiche_spring.service.IFraisService;
import fr.gsb.gsb_fiche_spring.service.VisiteurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private IFraisService fraisService;
    private VisiteurService visiteurService;


    public Runner(IFraisService fraisService, VisiteurService visiteurService){
        this.fraisService=fraisService;
        this.visiteurService=visiteurService;
    }

    @Override
    public void run(String... args) throws Exception {
        //TODO Chercher un visiteur + afficher le visiteur et la liste des fiches de frais
        Visiteur v = visiteurService.trouverParId("V1");
        System.out.println(v);
        List<FraisServiceDTO> fiches = fraisService.getFiches();
        System.out.println(fiches);
    }
}
