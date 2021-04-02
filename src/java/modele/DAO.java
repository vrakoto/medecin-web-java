package modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    public static Collection<Dep> getLesDeps() {
        try {
            Collection<Dep> resultat = new TreeSet<Dep>();
            Connection con = Connect.get();
            Statement reqlesDep;
            reqlesDep = con.createStatement();
            ResultSet rslesDep = reqlesDep.executeQuery("select DISTINCT departement from medecin");
            
            
            while(rslesDep.next()) {
                Collection<Med> lesMeds = getLesMeds(rslesDep.getString("departement"));
                Dep d = new Dep(rslesDep.getString("departement"), lesMeds);
                resultat.add(d);
            }
            return resultat;
            
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e);
        }
        return null;
    }
    
    public static Collection<Med> getLesMeds(String num) {
        Collection<Med> m = new TreeSet<Med>();
        try {
            Connection con = Connect.get();
            Statement reqM = con.createStatement();
            ResultSet rsLesMeds = reqM.executeQuery("select * from medecin where departement = '" + num + "'");
            while (rsLesMeds.next()) {
                String nom = rsLesMeds.getString("nom");
                String prenom = rsLesMeds.getString("prenom");
                String adresse = rsLesMeds.getString("adresse");
                String tel = rsLesMeds.getString("tel");
                String dep = rsLesMeds.getString("departement");
                String spe = rsLesMeds.getString("specialitecomplementaire");
                String id = rsLesMeds.getString("id");
                m.add(new Med(nom, prenom, adresse, tel, dep, spe, id));
            }
            rsLesMeds.close();
            reqM.close();
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e);
        }
        return m;
    }
    
    public static Collection<Med> getLesMedsS() {
        Collection<Med> m = new TreeSet<Med>();
        try {
            Connection con = Connect.get();
            Statement reqM = con.createStatement();
            ResultSet rsLesMeds = reqM.executeQuery("select * from medecin");
            while (rsLesMeds.next()) {
                String nom = rsLesMeds.getString("nom");
                String prenom = rsLesMeds.getString("prenom");
                String adresse = rsLesMeds.getString("adresse");
                String tel = rsLesMeds.getString("tel");
                String dep = rsLesMeds.getString("departement");
                String spe = rsLesMeds.getString("specialitecomplementaire");
                String id = rsLesMeds.getString("id");
                m.add(new Med(nom, prenom, adresse, tel, dep, spe, id));
            }
            rsLesMeds.close();
            reqM.close();
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e);
        }
        return m;
    }
    
    public static Collection<Spe> getLesSpes() {
        Collection<Spe> sp = new TreeSet<Spe>();
        try {
            Connection con = Connect.get();
            Statement reqS = con.createStatement();
            ResultSet rsS = reqS.executeQuery("Select DISTINCT specialitecomplementaire from medecin where specialitecomplementaire is not null");
            while (rsS.next()) {
                String spe = rsS.getString("specialitecomplementaire");
                //Collection<Med> lesMeds = getLesMedSpe(spe);
                sp.add(new Spe(spe));
            }
            rsS.close();
            reqS.close();
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e);
        }
        return sp;
    }

//    private static Collection<Med> getLesMedSpe(String spe) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}