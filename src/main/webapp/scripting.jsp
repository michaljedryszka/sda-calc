<%@ page language="java" %>

<%-- Komentarz--%>

Deklaruje zmienna i<br/>

<%! int i = 0; %>

Inkrementuje i wypisuje <%= ++i %><br/>

Inkrementuje ponownie<br/>

<% i++; %>

Wypisuje z uzyciem out <% out.print(i); %><br/>

Wypisujemy w petli<br/>

<% for(int k = 0; k <= i; k++){ %>
  Wartosc k=<%=k%><br/>
<% } %>

<% if (i < 5) { %>
i jest mniejsze od 5
<% } else {%>
i jest wieksze od 5
<% } %>