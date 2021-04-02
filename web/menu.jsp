<%-- 
    Document   : menu
    Created on : 26 nov. 2020, 12:44:24
    Author     : sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Bienvenue!</h1>
        
        <p>Rechercher les médecins :</p>
            <ul>
                <li>
                    <a href="Control?action=listeMedecinsDep" title="Rechercher par département">Par département</a>
                </li>
                <li>
                    <a href="Control?action=listeMedecinsNom" title="Rechercher par nom">Par nom</a>
                </li>
                <li>
                    <a href="Control?action=listeMedecinsSpe" title="Rechercher par spécialité">Par Spécialité</a>
                </li>
        </ul>
    </body>
</html>
