<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <table>
        <h1>Médecins pour le département n°${leDep.num}</h1>
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
