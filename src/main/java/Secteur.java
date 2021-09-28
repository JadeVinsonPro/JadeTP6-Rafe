import java.util.ArrayList;
import java.util.List;

public class Secteur {
    private int numSecteur;
    private String nomSecteur;
    private Boolean espaceVert;
    private Commune laCommune;
    private List<Branchement> lesBranchements = new ArrayList<Branchement>();

    public Secteur(int numSecteur, String nomSecteur, Boolean espaceVert, Commune laCommune) {
        this.numSecteur = numSecteur;
        this.nomSecteur = nomSecteur;
        this.espaceVert = espaceVert;
        this.laCommune = laCommune;
    }

    public void ajouterBranchement(Branchement branchement) {
        this.lesBranchements.add(branchement);
    }

    public int getNumSecteur() {
        return numSecteur;
    }

    public void setNumSecteur(int numSecteur) {
        this.numSecteur = numSecteur;
    }

    public String getNomSecteur() {
        return nomSecteur;
    }

    public void setNomSecteur(String nomSecteur) {
        this.nomSecteur = nomSecteur;
    }

    public Boolean getEspaceVert() {
        return espaceVert;
    }

    public void setEspaceVert(Boolean espaceVert) {
        this.espaceVert = espaceVert;
    }

    public Commune getLaCommune() {
        return laCommune;
    }

    public void setLaCommune(Commune laCommune) {
        this.laCommune = laCommune;
    }

    public List<Branchement> getLesBranchements() {
        return lesBranchements;
    }

    public void setLesBranchements(List<Branchement> lesBranchements) {
        this.lesBranchements = lesBranchements;
    }

    @Override
    public String toString() {
        return "\u001b[34mSecteur {" +
                "numSecteur=" + numSecteur +
                ", \nnomSecteur='" + nomSecteur + '\'' +
                ", \nespaceVert=" + espaceVert +
                ", \nlesBranchements="  + lesBranchements +
                "}";
    }
}
