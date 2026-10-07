package fr.gsb.gsb_fiche_spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "visiteur")
public class Visiteur {

    @Id
    @Column(name = "id",length = 4, nullable = false)
    private String id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom",length=50)
    private String prenom;

    @Column(name = "date_embauche")
    private LocalDate dateEmbauche;

    public Visiteur() {}

    public Visiteur(String id,String nom, String prenom, LocalDate dateEmbauche){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.dateEmbauche = dateEmbauche;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    @Override
    public String toString() {
        return "Visiteur [id="+this.id+", nom="+this.nom+", prenom="+this.prenom+"]";
    }

}
