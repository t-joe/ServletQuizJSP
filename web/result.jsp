<%@ page import="classess.model.Quiz" %><%--
  Created by IntelliJ IDEA.
  User: 610592
  Date: 12/1/2019
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<% Quiz q= (Quiz)session.getAttribute("quiz"); %>
<fieldset style="width: 600px;">
    <h1>The number quiz</h1>
    <br>Your current score:  <%=q.getScore()%>, Your grade: <span style="color: red"> ${grade}</span>
    <br><br>You have completed the Number Quiz, with a score of ${quiz.getScore()} out of <%=(q.getA().length * 10)%>
</fieldset>
</body>
</html>
