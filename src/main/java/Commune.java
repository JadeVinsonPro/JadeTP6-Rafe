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
        int consoUsager = 0;
        int consoVanne = 0;

        for (Secteur secteur : this.lesSecteurs) {
            for (Branchement branchement : secteur.getLesBranchements()) {
                if (branchement instanceof Usager) {
                    consoUsager += branchement.getLeCompteur().getConsommation();
                } else if (branchement instanceof Vanne) {
                    consoVanne += branchement.getLeCompteur().getConsommation();
                }
            }
        }

        return consoVanne - consoUsager;
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
