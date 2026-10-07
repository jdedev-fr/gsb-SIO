package fr.gsb.gsb_fiche_spring.entities;

import fr.gsb.gsb_fiche_spring.dto.FraisServiceDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "fiche_de_frais")
public class FicheDeFrais {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mois",length = 6)
    private String mois;

    @Column(name = "nb_justificatifs")
    private int nbJustificatifs;

    @Column(name = "montant_valide")
    private  double montantValide;

    public FicheDeFrais() {}

    public FicheDeFrais(String mois, int nbJustificatifs, double montantValide){
        this.mois = mois;
        this.nbJustificatifs = nbJustificatifs;
        this.montantValide = montantValide;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public int getNbJustificatifs() {
        return nbJustificatifs;
    }

    public void setNbJustificatifs(int nbJustificatifs) {
        if(nbJustificatifs<0){
            System.err.println("Nombre de justificatifs négatifs");
        }
        else {
            this.nbJustificatifs = nbJustificatifs;
        }

    }

    public double getMontantValide() {
        return montantValide;
    }

    public void setMontantValide(double montantValide) {
        this.montantValide = montantValide;
    }


    @Override
    public String toString(){
        return "FicheDeFrais [id= "+this.id+", mois="+this.mois+", nbJustificatifs="+this.nbJustificatifs+"]";
    }

}
