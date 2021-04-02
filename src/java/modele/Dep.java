package modele;

import java.util.Collection;
import java.util.HashSet;

public class Dep implements Comparable<Dep> {
    private String num;
    private Collection<Med> lesMeds;

    public Dep(String num, Collection<Med> lesMeds) {
        this.num = num;
        this.lesMeds = lesMeds;
    }

    public String getNum() {
        return num;
    }

    public Collection<Med> getLesMeds() {
        return lesMeds;
    }
    
    public void ajouterUnMed(Med unMed) {
        lesMeds.add(unMed);
    }
    
    public Collection<Med> getLesMedsParNom(String med) {
        Collection<Med> medNom = new HashSet<Med>();
        for (Med unMed : lesMeds) {
            if (unMed.getNom().startsWith(med)){
                medNom.add(unMed);
            }
        }
        return medNom;
    }

    @Override
    public int compareTo(Dep o) {
        return num.compareTo(o.num);
    }
}
