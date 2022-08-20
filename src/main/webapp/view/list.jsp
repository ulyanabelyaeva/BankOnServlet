<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="ru.belyaeva.entity.*" %>
<%@ page import ="ru.belyaeva.model.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Bank</title>
    <link rel="stylesheet" href="style/index.css">
    <link rel="stylesheet" href="style/list.css">
</head>
<body>
    <div class="wrapper">
        <header>
            Your Bank
        </header>
        <main>
            <div class="title">
                Список пользователей
            </div>
            <ul>
                <%
                    for (User user:
                        ModelAllUsers.getInstance().list()) {
                            out.println("<li><form><button type='submit' name='btn' value='open'><div class='item'><div>"
                            + user.getName() + " " + user.getLastName() + "</div>");
                            out.println("<div>Счета: " + "</br><ul><li>");
                            out.println(user.getScore().getId() + " Баланс: " + user.getScore().getBalance() + "</li></ul>");
                            out.println("</div></div></button>");
                            out.println("<input type='hidden' name='id' value=" + user.getId() +">");
                            System.out.println(user.getId());
                            out.println("</form></li>");
                        }
                %>
            </ul>
        </main>
        <footer></footer>

    </div>
</body>
</html>