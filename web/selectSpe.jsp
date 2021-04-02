<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selectionner une spécialité</title>
    </head>
    <body>
            <h2>Recherche des médecins par spécialité</h2>
            <h3>Spécialité à sélectionner : </h3>
            
            <form action="Control?action=listeMedecinsSpe" method="post">
                <label for="listSpes">Spécialité : </label>
                
                <select id="listSpes" name="choixSpe">
                    <option value="-1">Choisir une spécialité</option>
                    <c:forEach var="spe" items="${listSpes}">
                         <option value="${spe.libelle}">${spe.libelle}</option>
                    </c:forEach>
                </select>
                <br/>
                
                <input id="ok" type="submit" value="Valider" size="20" />
                <input id="annuler" type="reset" value="Effacer" size="20" />
                
                </form>
    </body>
</html>
