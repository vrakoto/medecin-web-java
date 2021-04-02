package modele;

import java.util.Collection;

public class Pays {
    private Collection<Dep>lesDeps;
    private Collection<Spe> lesSpes;

    public Pays() {
        lesDeps = DAO.getLesDeps();
        lesSpes = DAO.getLesSpes();
        this.assocMedecins(DAO.getLesMedsS());
    }
    
    public Collection<Dep> getLesDeps() {
        return lesDeps;
    }
    
    public Dep getLeDep(String numdemp) {
        for(Dep dep : lesDeps){
            if (dep.getNum().equals(numdemp)){
                return dep;
            }
        }
        return null;
    }
    
    public Collection<Spe> getLesSpes() {
        return lesSpes;
    }
    
    public Spe getLaSpe(String s) {
        for (Spe uneSpe : lesSpes) {
            if (uneSpe.getLibelle().equals(s)) {
                return uneSpe;
            }
        }
        return null;
    }
    
    private void assocMedecins(Collection<Med> lesMeds) {
        for (Med unMed : lesMeds) {
            getLeDep(unMed.getDep()).ajouterUnMed(unMed);
            Spe uneSpe = getLaSpe(unMed.getSpe());
            if (uneSpe != null) {
                uneSpe.ajouterUnMed(unMed);
            }
        }
    }
}