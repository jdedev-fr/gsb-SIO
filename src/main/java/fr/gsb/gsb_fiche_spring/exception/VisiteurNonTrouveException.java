package fr.gsb.gsb_fiche_spring.exception;

public class VisiteurNonTrouveException extends RuntimeException {
    public VisiteurNonTrouveException() {

        super("Visiteur non trouvé");
    }
}
