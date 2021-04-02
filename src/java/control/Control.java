package control;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Dep;
import modele.Med;
import modele.Pays;
import java.util.TreeSet;
import modele.Spe;

public class Control extends HttpServlet {
    private Pays p;
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        p = new Pays();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String page;
        String action = request.getParameter("action");
        
        Collection<Dep> d = p.getLesDeps();
        request.setAttribute("listDeps", d);

        if ("listeMedecinsDep".equals(action)) {
            String choixDep = request.getParameter("choixDep");
            if (choixDep == null || choixDep.equals("-1")) {
                page = "selectDep.jsp";
            } else {
                Collection<Med> m = p.getLeDep(choixDep).getLesMeds();
                request.setAttribute("leDep", p.getLeDep(choixDep));
                request.setAttribute("listMeds", m);
                page = "ListMedDep.jsp";
            }
        
        } else if ("listeMedecinsNom".equals(action)) {
            String choixNom = request.getParameter("choixNom");
            if (choixNom == null) {
                page = "rechercherMed.jsp";
            } else {
                Collection <Med> m = new TreeSet<Med>();
                for (Dep unDep : p.getLesDeps()) {
                    Collection med = unDep.getLesMedsParNom(choixNom);
                    m.addAll(med);
                }
                request.setAttribute("nomR", choixNom);
                request.setAttribute("listMeds", m);
                page = "ListMedNom.jsp";
            }
        } else if ("listeMedecinsSpe".equals(action)) {
            String choixSpe = request.getParameter("choixSpe");
            if (choixSpe == null || choixSpe.equals("-1")) {
                Collection<Spe> s = p.getLesSpes();
                request.setAttribute("listSpes", s);
                page = "selectSpe.jsp";
            } else {
                Collection<Med> m = p.getLaSpe(choixSpe).getLesMeds();
                request.setAttribute("laSpe", p.getLaSpe(choixSpe));
                request.setAttribute("listMeds", m);
                page = "listMedSpe.jsp";
            }
        } else {
            page = "menu.jsp";
        }

        request.getRequestDispatcher(page).forward(request, response);
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
