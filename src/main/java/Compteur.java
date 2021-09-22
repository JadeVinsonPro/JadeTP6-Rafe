public class Compteur {
    private int indexAncien;
    private int indexNouveau;

    public Compteur(int indexAncien, int indexNouveau) {
        this.indexAncien = indexAncien;
        this.indexNouveau = indexNouveau;
    }

    public int releve() {
        return this.indexNouveau - this.indexAncien;
    }

    public int getIndexAncien() {
        return indexAncien;
    }

    public void setIndexAncien(int indexAncien) {
        this.indexAncien = indexAncien;
    }

    public int getIndexNouveau() {
        return indexNouveau;
    }

    public void setIndexNouveau(int indexNouveau) {
        this.indexNouveau = indexNouveau;
    }

    @Override
    public String toString() {
        return "Compteur{" +
                "indexAncien=" + indexAncien +
                ", indexNouveau=" + indexNouveau +
                '}';
    }
}
