public class Branchement {
    private Compteur leCompteur;

    public Branchement(Compteur leCompteur) {
        this.leCompteur = leCompteur;
    }

    public Compteur getLeCompteur() {
        return leCompteur;
    }

    public void setLeCompteur(Compteur leCompteur) {
        this.leCompteur = leCompteur;
    }

    @Override
    public String toString() {
        return "Branchement{" +
                "leCompteur=" + leCompteur +
                '}';
    }
}
