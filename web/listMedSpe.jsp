<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des medecins par Spécialité</title>
    </head>
    <body>
            <a href="Control?action=listeMedecinsSpe">Retour à la sélection</a>
            
            <table>
            <p>Médecins pour la spécialité "<i>${laSpe.libelle}</i>"</p>
        
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Adresse</th>
            <th>Spécialité</th>
            <th>Téléphone</th>
        </tr>
            <c:forEach var="med" items="${listMeds}">
            <tr>
                <td>${med.nom}</td>
                <td>${med.prenom}</td>
                <td>${med.adresse}</td>
                <td>${med.spe}</td>
                <td>${med.tel}</td>
            </tr>
            </c:forEach>
            
            </table>
            
        </body>
</html>
