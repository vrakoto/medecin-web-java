package modele;

public class Med implements Comparable<Med> {
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String dep;
    private String spe;
    private String id;

    public Med(String nom, String prenom, String adresse, String tel, String dep, String spe, String id) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.dep = dep;
        this.spe = spe;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }
    
    public String getDep() {
        return dep;
    }

    public String getSpe() {
        return spe;
    }

    @Override
    public int compareTo(Med o) {
        if( nom.equals(o.nom)) {
            return id.compareTo(o.id);
        } else {
            return nom.compareTo(o.nom);
        }
    }
    
}
