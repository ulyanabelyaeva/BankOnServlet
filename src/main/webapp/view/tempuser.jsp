<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="ru.belyaeva.entity.*" %>
<%@ page import ="ru.belyaeva.model.*" %>
<%@ page import ="java.text.SimpleDateFormat" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Bank</title>
    <link type="Image/x-icon" href="https://musicnova.ru/wa-data/public/site/bank-3.png" rel="icon">
    <link rel="stylesheet" href="style/index.css">
    <link rel="stylesheet" href="style/add.css">
</head>
<body>
    <div class="wrapper">
        <header>
            <button onclick="location.href='/list'" class="back">Назад</button>
            <div style="text-align: center; width: 90%;">Your Bank</div>
        </header>
        <main>
            <div class="in_main">
                <div class="part1">
                    <div class="title">
                        Данные пользователя
                    </div>
                    <div><%
                            User user = (User) request.getAttribute("user");
                            out.println(user.getName() + " " + user.getLastName());
                          %></div>
                    <div>Паспорт:
                        <%
                            out.println(user.getSeries() + " " + user.getNumber());
                        %></div>
                    <div>
                        Счета:
                        <ul>
                                <%
                                    SimpleDateFormat TEXT_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                                    out.println("<il>" + user.getScore().getId() + "</br>");
                                    out.println("Баланс: " + user.getScore().getBalance() + "</br>");
                                    out.println("Создан: " + TEXT_FORMATTER.format(user.getScore().getData()) + "</il>");
                                %>
                        </ul>
                    </div>
                </div>
            </div>
        </main>

        <footer>
        </footer>
    </div>
</body>
</html>