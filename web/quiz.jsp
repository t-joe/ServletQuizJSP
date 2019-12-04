<%@ page import="classess.model.Quiz" %>
<%@ page import="java.lang.String" %><%--
  Created by IntelliJ IDEA.
  User: 610592
  Date: 12/1/2019
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<fieldset style="width: 300px;">
    <h1>The number quiz</h1>
    Your current score: <%=((Quiz)session.getAttribute("quiz")).getScore()%><br><br>
    Guess the next number in the sequence<br><br>
    <%
        String qAnswer = (String)request.getAttribute("qAnswer");
        if(qAnswer != null) {
            out.print("Previous questions answer: " + qAnswer + "<br><br>`");
        }
        Quiz q = (Quiz)session.getAttribute("quiz");
        int[] qs = q.getQ(q.getQNum());
        for(int ns: qs)
            out.print(ns + " ");
    %>
    <br><br>
    <form name="qform" action="Quiz.do" method="post">
        Your answer: <input type="text" name="answer" size="6" maxlength="2"><br>
        <input type="submit" name="submit" value="Submit">
    </form>
    <%
        String attempt = (String) request.getAttribute("attempt");
        if(attempt != null)
        {
            int iattempt = Integer.parseInt(attempt);
            if(iattempt > 0)
                out.print("Wrong answer you've got <span style='color: red'>"+ (3 - iattempt)+"</span> attempt left");
        }

    %>
</fieldset>
</body>
</html>
