public class Main {
    public static void main(String[] args) {
        Commune commune1 = new Commune("1", "Paris");

        Secteur secteur1 = new Secteur(1, "Paris 1", true, commune1);
        Secteur secteur2 = new Secteur(2, "Paris 2", false, commune1);

        Compteur compteur1 = new Compteur(10, 30);
        Compteur compteur2 = new Compteur(23, 50);
        Compteur compteur3 = new Compteur(22, 49);
        Compteur compteur4 = new Compteur(100, 200);
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

        System.out.println(commune1);
    }
}