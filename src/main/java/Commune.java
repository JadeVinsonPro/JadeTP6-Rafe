import java.util.ArrayList;
import java.util.List;

public class Commune {
    private String numCom;
    private String nomCom;
    private List<Secteur> lesSecteurs = new ArrayList<Secteur>(); //une commune comprend des secteurs

    public Commune(String numCom, String nomCom) {
        this.numCom = numCom;
        this.nomCom = nomCom;
    }

    public void ajouterUnSecteur(Secteur secteur) {
        this.lesSecteurs.add(secteur);
    }


    public List<Secteur> secteurEV() {
        List<Secteur> secteursEV = new ArrayList<Secteur>();
        for (Secteur secteur : this.lesSecteurs) {
            if (secteur.getEspaceVert()) {
                secteursEV.add(secteur);
            }
        }
        return secteursEV;
    }
//peut etre mis en private
    public int volumeVannes() { // on va chercher la valeur en parcourant les tableaux de Secteur, Branchement, Vanne
        int totalVanne = 0;

        for (Secteur secteur : this.lesSecteurs) {
            for (Branchement branchement : secteur.getLesBranchements()) {
                if (branchement instanceof Vanne) { // on prend le fils Vanne
                    totalVanne += branchement.conso();//on ajoute le volume actuel
                }
            }
        }

        return totalVanne;
    }

    public int volumeUsagers() {
        int totalUsager = 0;

        for (Secteur secteur : this.lesSecteurs) {
            for (Branchement branchement : secteur.getLesBranchements()) {
                if (branchement instanceof Usager) {
                    totalUsager += branchement.conso();
                }
            }
        }

        return totalUsager;
    }

    public int perte() {//possible de mettre en private -> uniquement en interne
        return this.volumeVannes() - this.volumeUsagers();
    }

    public int anomalie() { //le pourcentage des pertes par rapport au volume distribué
                            // par les vannes

        int pourcentage = (this.perte() * 100) / this.volumeVannes();// possible d'optimiser en mettant directement perte() sans faire la fonction
        if (pourcentage < 10) {
            return 1;
        } else if (pourcentage < 15) {
            return 2;
        } else {
            return 3;
        }
    }



    public String getNumCom() {
        return numCom;
    }

    public void setNumCom(String numCom) {
        this.numCom = numCom;
    }

    public String getNomCom() {
        return nomCom;
    }

    public void setNomCom(String nomCom) {
        this.nomCom = nomCom;
    }

    public List<Secteur> getLesSecteurs() {
        return lesSecteurs;
    }

    public void setLesSecteurs(List<Secteur> lesSecteurs) {
        this.lesSecteurs = lesSecteurs;
    }

    @Override
    public String toString() {
        return "\u001b[34mCommune{" +
                "\n numCom='" + numCom + '\'' +
                ", \nnomCom='" + nomCom + '\'' +
                ", \nlesSecteurs=" + lesSecteurs +
                '}';
    }
}
