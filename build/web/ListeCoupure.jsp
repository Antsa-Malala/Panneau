<%@page import="model.Coupure"%>
<%@page import="model.Resultat"%>
<%@page import="model.Classe"%>
<%@page import="java.util.ArrayList"%>

<%
    ArrayList<Coupure> coupure=(ArrayList<Coupure>)request.getAttribute("Coupure");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prévision de coupure</title>
    <link rel="stylesheet" href="./css/table.css">
    <style>
        @font-face {
            font-family: 'The Smile';
            src: url('css\The Smile.otf') format('opentype');
        }
    </style>
</head>
<body>
    <div id="container">
        <%for(Coupure co : coupure)
        {%>
        <div class="unit-card">
            <h4><%out.print(co.getSource().getNom()+" à "+ co.getHeureCoupure());%></h4>       
            <div class="info-container">
                <div class="info-block">
                    <p>Batterie : <% out.print(co.getSource().getBatterie().getPuissance()); %> <% out.print(co.getSource().getBatterie().getUnite().getNomUnite()); %></p>
                    <p>Panneau : <% out.print(co.getSource().getPanneau().getPuissance()); %> <% out.print(co.getSource().getPanneau().getUnite().getNomUnite()); %></p>
                </div>
                <div class="info-block">
                    <p>Elèves matin : <%out.print(co.getSource().getNbEleveMatin());%></p>
                    <p>Elèves après-midi : <%out.print(co.getSource().getNbEleveAprem());%></p>
                </div>
            </div>
            <% for (Classe c : co.getSource().getClasses()) { %>
                <div class="class-container">
                    <h5><% out.print(c.getNom()); %></h5>
                    <p>Matin : <% out.print(c.getNbEleveMatin()); %></p>
                    <p>Après-midi : <% out.print(c.getNbEleveAprem()); %></p>
                </div>
            <% } %>
        </div>

            <table>
                <tr>
                    <th>Heure</th>
                    <th>Consommation(W)</th>
                    <th>Consommation Unitaire(W)</th>
                    <th>Luminosite</th>
                    <th>Panneau(W)</th>
                    <th>Batterie(W)</th>
                </tr>
                <%for(Resultat r : co.getCoupure()){%>
                <tr>
                    <td><%out.print(r.getHeureCoupure());%></td>
                    <td><%out.print(r.getConsommation());%></td>
                    <td><%out.print(r.getConsommationUnit());%></td>
                    <td><%out.print(r.getLuminosite());%></td>
                    <td><%out.print(r.getPanneau());%></td>
                    <td><%out.print(r.getBatterie());%></td>
                </tr>
                <% } %>
            </table>
        <% } %>
    </div>
</body>
</html>
