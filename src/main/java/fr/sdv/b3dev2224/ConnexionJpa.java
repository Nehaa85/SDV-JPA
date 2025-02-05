package fr.sdv.b3dev2224;

import fr.sdv.b3dev2224.entites.Emprunt;
import fr.sdv.b3dev2224.entites.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("comptaPU");
        EntityManager em = emf.createEntityManager();

        Emprunt emprunt = em.find(Emprunt.class, 2);
        if (emprunt != null) {
            System.out.println("Emprunt trouvé : " + emprunt);
            System.out.println("Livres associés : ");
            for (Livre livre : emprunt.getLivres()) {
                System.out.println("- " + livre.getTitre() + " - " + livre.getAuteur());
            }
        } else {
            System.out.println("L'emprunt est impossible avec cet ID :(");
        }

//        Livre livre = em.find(Livre.class, 1);
//        if (livre != null) {
//            System.out.println(livre.getTitre());
//        } else {
//            System.out.println("Le livre n'existe pas :(");
//        }
//
//        System.out.println("Connexion réussie");
        em.close();
        emf.close();
    }
}
