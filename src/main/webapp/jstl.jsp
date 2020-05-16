<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%-- Komentarz--%>
Deklaruje zmienna i<br/>

<c:set var = "i" scope = "request" value = "0"/>

Inkrementuje i wypisuje

<c:set var = "i" value = "${i + 1}" />

<c:out value = "${i}"/>
<br/>
Inkrementuje ponownie<br/>
<c:set var = "i" value = "${i + 1}" />
Wypisuje z uzyciem out <c:out value = "${i}"/><br/>

Wypisujemy w petli<br/>
<c:forEach var = "k" begin = "0" end = "${i}">
  Wartosc k=<c:out value = "${k}"/><br/>
</c:forEach>

<c:choose>
  <c:when test = "${i < 5}">
    i jest mniejsze od 5
  </c:when>
  <c:otherwise>
    i jest wieksze od 5
  </c:otherwise>
</c:choose>