<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<form action = "insert" method= "post">

Nom<input type="text" name = "nom" /><br>
Prenom<input type="text" name = "prenom" /><br>
Age<input type="number" name = "age" /><br>
Email<input type="email" name = "email" /><br>
Password<input type="password" name = "mot_de_pass" /><br>
Idrole 
<select name="idrole">
	<option value="1"> Admin <option>
	<option value="2">Client </option>
</select>

<input type="submit" value = "submit"/>

</form>


</body>
</html>