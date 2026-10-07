package fr.gsb.gsb_fiche_spring.dto;

import fr.gsb.gsb_fiche_spring.entities.FicheDeFrais;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class FraisServiceDTO
{

    private int id;

    @NotBlank(message = "Le mois est obligatoire")
    @Size(min = 6, max = 6, message = "Le mois doit faire 6 caractères format MMAAAA")
    private String mois;

    @Positive
    private int nbJustificatifs;

    @PositiveOrZero
    private double montantValide;

    public FraisServiceDTO() {}

    public FraisServiceDTO(int id,String mois,int nbJustificatifs,double montantValide) {
        this.id=id;
        this.mois = mois;
        this.nbJustificatifs = nbJustificatifs;
        this.montantValide = montantValide;
    }

    public int getId() {
        return id;
    }
    public String getMois() {
        return mois;
    }
    public int getNbJustificatifs() {
        return nbJustificatifs;
    }

    public double getMontantValide() {
        return montantValide;
    }

    public void setId(int id) { this.id = id; }
    public void setMois(String mois) { this.mois = mois; }
    public void setNbJustificatifs(int nbJustificatifs) { this.nbJustificatifs = nbJustificatifs; }
    public void setMontantValide(double montantValide) { this.montantValide = montantValide; }

}
