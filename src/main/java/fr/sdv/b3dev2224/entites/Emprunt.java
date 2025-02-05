package fr.sdv.b3dev2224.entites;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Emprunt")
public class Emprunt {
    @Id
    private int id;
    @Column (name = "DATE_DEBUT", nullable = false)
    private LocalDate dateDebut;
    @Column (name = "DATE_FIN")
    private LocalDate dateFin;
    @Column (name ="DELAI")
    private int delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "Compo",
            joinColumns = @JoinColumn(name="ID_Emp"),
            inverseJoinColumns = @JoinColumn(name="ID_Liv", referencedColumnName = "ID")
    )
    private List<Livre> livres;

    public Emprunt() {
    }

    public Emprunt(int id, LocalDate dateDebut, LocalDate dateFin, int delai, Client client) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.client = client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public int getDelai() {
        return delai;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    @Override
    public String toString() {
        return "Emprunt" + " id : " + id + ", Date de Début : " + dateDebut + ", Date de Fin : " + dateFin + ", Delai : " + delai + ", Client : " + client.getNom() + " " + client.getPrenom() + ".";
    }
}
