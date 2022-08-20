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
</head>
<body>
    <div class="wrapper">
        <header>
            Your Bank
        </header>
        <main>
            <div class="in_main">
                <div class="part1">
                    <div class="title">
                        Личный кабинет
                    </div>
                    <div><%
                            User user = ModelUser.getInstance().getUser();
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
                                    out.println("<li>" + user.getScore().getId() + "</br>");
                                    out.println("Баланс: " + user.getScore().getBalance() + "</br>");
                                    out.println("Создан: " + TEXT_FORMATTER.format(user.getScore().getData()) + "</li>");
                                %>
                        </ul>
                    </div>
                    <form method="post">
                        <button type="submit" name="btn" value="put">Редактировать профиль</button>
                    </form>
                </div>
                <div class="part2">
                    <div class="title">
                        Операции
                    </div>
                    <div>
                        <div class="title2">Пополнить счет</div>
                        <form method="post">
                            <label>Введите номер своего счета:
                                <input type="number" name="receiveId"></br>
                            </label>
                            <label>Введите cумму:
                                <input type="number" name="money"></br>
                            </label>
                            <button type="submit" name="btn" value="topUp">Пополнить</button>
                        </form>
                    </div>
                    <div>
                        <div class="title2">Перевести деньги на счет другого клиента</div>
                        <form method="post">
                            <label>Введите счет получателя:
                                <input type="number" name="receiveId"></br>
                            </label>
                            <label>Введите cумму:
                                <input type="number" name="money"></br>
                            </label>
                            <button type="submit" name="btn" value="move">Перевести на счет</button>
                            <div><%
                                if (request.getAttribute("result") != null){
                                    out.println(request.getAttribute("result"));
                                }
                            %></div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="btns">
                <form method="post">
                    <button type="submit" name="btn" value="exit">Выйти из аккаунта</button>
                </form>

                <form method="post">
                    <button type="submit" name="btn" value="delete">Удалить аккаунт</button>
                </form>
            </div>
        </main>

        <footer>
        </footer>
    </div>
</body>
</html>