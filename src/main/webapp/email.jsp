<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<% if (request.getAttribute("invalidEmail") != null) { %>
    <b>Niepoprawny email</b>
<% } %>

<c:if test = "${invalidEmail != null}">
    <b>Niepoprawny email</b>
</c:if>

<form action="" method="POST">
Podaj adres email:
<input name="email"/>
<input type="submit" value="Wyslij"/>
</form>