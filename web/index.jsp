<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="Quiz.do" method="post">
    <h1>Start Number Quiz?</h1>
    <label>Integer your age: <input type="text" name="age" size="6" maxlength="3" placeholder="age" pattern="[4-100]{1}"> </label>
    <br><span style="color: red"><%
        if(request.getAttribute("errorMsg") != null)
            out.print(request.getAttribute("errorMsg"));
    %></span>
    <br>
    <input type="submit" name="submit" value="Start">
</form>
</body>
</html>