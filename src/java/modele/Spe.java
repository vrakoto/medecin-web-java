package modele;

import java.util.Collection;
import java.util.TreeSet;

public class Spe implements Comparable<Spe> {
    private String libelle;
    private Collection<Med> lesMeds = new TreeSet<Med>();

    public Spe(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
    
    public void ajouterUnMed(Med unMed) {
        lesMeds.add(unMed);
    }

    public Collection<Med> getLesMeds() {
        return lesMeds;
    }

    @Override
    public int compareTo(Spe s) {
        return libelle.compareTo(s.libelle);
    }
}