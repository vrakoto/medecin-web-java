<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h2>Recherche des médecins par nom</h2>
    <form action="Control?action=listeMedecinsNom" method="post">
                <label for="nomMed">Nom du médecin : </label>
                <input type="text" name="choixNom">
                <input id="ok" type="submit" value="Valider" size="20" />
                <input id="annuler" type="reset" value="Effacer" size="20" />
    </form>
    </body>
</html>
