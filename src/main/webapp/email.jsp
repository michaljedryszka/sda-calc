
<% if (request.getAttribute("invalidEmail") != null) { %>
    <b>Niepoprawny email</b>
<% } %>

<form action="" method="POST">
Podaj adres email:
<input name="email"/>
<input type="submit" value="Wyslij"/>
</form>