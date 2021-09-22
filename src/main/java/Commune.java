import java.util.ArrayList;
import java.util.List;

public class Commune {
    private String numCom;
    private String nomCom;
    private List<Secteur> lesSecteurs = new ArrayList<Secteur>();

    public Commune(String numCom, String nomCom) {
        this.numCom = numCom;
        this.nomCom = nomCom;
    }

    public void ajouterUnSecteur(Secteur secteur) {
        this.lesSecteurs.add(secteur);
    }

    public int perte() {
        return this.volumeVannes() - this.volumeUsagers();
    }

    public int volumeVannes() {
        int totalVanne = 0;

        for (Secteur secteur : this.lesSecteurs) {
            for (Branchement branchement : secteur.getLesBranchements()) {
                if (branchement instanceof Vanne) {
                    totalVanne += branchement.conso();
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

    public int anomalie() {
        int pourcentage = (perte() * 100) / volumeVannes();
        if (pourcentage < 10) {
            return 1;
        } else if (pourcentage < 15) {
            return 2;
        } else {
            return 3;
        }
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
        return "Commune{" +
                "numCom='" + numCom + '\'' +
                ", nomCom='" + nomCom + '\'' +
                ", lesSecteurs=" + lesSecteurs +
                '}';
    }
}
