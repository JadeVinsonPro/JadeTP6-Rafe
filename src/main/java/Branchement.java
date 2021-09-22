public abstract class Branchement {
    private Compteur leCompteur;

    public Branchement(Compteur leCompteur) {
        this.leCompteur = leCompteur;
    }

    public int conso() {
        return this.leCompteur.releve();
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
