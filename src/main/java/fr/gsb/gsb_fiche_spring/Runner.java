package fr.gsb.gsb_fiche_spring;

import fr.gsb.gsb_fiche_spring.service.FraisService;
//import fr.gsb.gsb_fiche_spring.service.VisiteurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private FraisService fraisService;
   // private VisiteurService visiteurService;

public Runner(){}

    @Override
    public void run(String... args) throws Exception { }
  /* public Runner(FraisService fraisService, VisiteurService visiteurService){
        this.fraisService=fraisService;
        this.visiteurService=visiteurService;
    }

    @Override
    public void run(String... args) throws Exception {
        //TODO Chercher un visiteur + afficher le visiteur et la liste des fiches de frais
        Visiteur v = visiteurService.trouverParId("V1");
        System.out.println(v);
        List<FicheDeFrais> fiches = fraisService.getFiches();
        System.out.println(fiches);
    }*/
}
