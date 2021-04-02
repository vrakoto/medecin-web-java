<%-- 
    Document   : selectDep
    Created on : 26 nov. 2020, 12:35:18
    Author     : sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h2>Recherche des médecins par département</h2>
    <form action="Control?action=listeMedecinsDep" method="post">
            <p>
                <label for="lstDeps">Département : </label>
                
                <select id="lstDeps" name="choixDep">
                    
                    <option value="-1">Choisir un département...</option>
                    
                    <c:forEach var="dep" items="${listDeps}">
                        <option value="${dep.num}">${dep.num}</option>
                    </c:forEach>
                        
                </select>
            </p>
            <br/>
            <input id="ok" type="submit" value="Valider" size="20" />
    </form>
    </body>
</html>
