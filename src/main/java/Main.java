import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Commune commune1 = new Commune("1", "Paris");

        Secteur secteur1 = new Secteur(1, "Paris 1", true, commune1);
        Secteur secteur2 = new Secteur(2, "Paris 2", false, commune1);

        Compteur compteur1 = new Compteur(10, 30);
        Compteur compteur2 = new Compteur(23, 50);
        Compteur compteur3 = new Compteur(22, 49);
        Compteur compteur4 = new Compteur(100, 150);
        Compteur compteur5 = new Compteur(30, 61);

        Usager usager1 = new Usager(compteur1);
        Usager usager2 = new Usager(compteur2);
        Usager usager3 = new Usager(compteur3);

        Vanne vanne1 = new Vanne(compteur4);
        Vanne vanne2 = new Vanne(compteur5);

        secteur1.ajouterBranchement(usager1);
        secteur1.ajouterBranchement(usager2);
        secteur1.ajouterBranchement(vanne1);

        secteur2.ajouterBranchement(usager3);
        secteur2.ajouterBranchement(vanne2);

        commune1.ajouterUnSecteur(secteur1);
        commune1.ajouterUnSecteur(secteur2);

        System.out.println(secteur1);
        System.out.println("La commune connait une anomalie de catégorie : " + commune1.anomalie());
        System.out.println("La commune a une perte de : " + commune1.perte());
        System.out.println("Le volume d'Usagers pour la commune : " + commune1.volumeUsagers());
        System.out.println("Le volume de Vannes pour la commune : " + commune1.volumeVannes());

        //BONUS : on cherche à connaitre le nombre de toutes les Vannes
        // et de tous les Usagers Toutes communes confondues

        //On crée une liste pour séparer les diffèrents branchements
        List<Usager> lesUsagers = new ArrayList<Usager>();
        List<Vanne> lesVannes = new ArrayList<Vanne>();

        List<Commune> lesCommunes = new ArrayList<Commune>();

        lesCommunes.add(commune1);

        for (Commune commune: lesCommunes) {
            for (Secteur secteur: commune.getLesSecteurs()) {
                for (Branchement branchement: secteur.getLesBranchements()) {
                    if (branchement instanceof Usager) {
                        lesUsagers.add((Usager) branchement);
                    }else if (branchement instanceof Vanne)
                        lesVannes.add((Vanne) branchement);
                }
            }
        }

        System.out.println("Toutes les informations de toutes les communes : " + lesCommunes);
        System.out.println("L'ensemble des usagers, toutes communes confondues est de " + lesUsagers);
        System.out.println("L'ensemble des vannes, toutes communes confondues est de " + lesVannes);

    }
}