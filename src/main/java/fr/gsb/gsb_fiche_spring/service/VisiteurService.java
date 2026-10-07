package fr.gsb.gsb_fiche_spring.service;

import fr.gsb.gsb_fiche_spring.entities.Visiteur;
import fr.gsb.gsb_fiche_spring.exception.VisiteurNonTrouveException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class VisiteurService {
    private Map<String, Visiteur> visiteurs;

    public VisiteurService() {
        visiteurs = new HashMap<>();

        Visiteur v1 = new Visiteur("V1","DEMETTRE","Julien", LocalDate.now());
        Visiteur v2 = new Visiteur("V2","CHARBONNIER","Luka", LocalDate.now());
        Visiteur v3 = new Visiteur("V3","CHAMPEVAL","Teo", LocalDate.now());

        visiteurs.put(v1.getId(),v1);
        visiteurs.put(v2.getId(),v2);
        visiteurs.put(v3.getId(),v3);
    }

    public Visiteur trouverParId(String id) {
        Visiteur v;
        v= visiteurs.get(id);
        if(v==null) {
            throw new VisiteurNonTrouveException();
        }
        else {
            return v;
        }
    }
}
