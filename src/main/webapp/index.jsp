<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Bank</title>
    <link rel="stylesheet" href="style/index.css">
    <link type="Image/x-icon" href="https://musicnova.ru/wa-data/public/site/bank-3.png" rel="icon">
</head>
<body>
    <div class="wrapper">
        <header>
            Your Bank
        </header>
        <main style="align-items: center; padding-top: 50px;">
            <div class="title">Вход</div>
            <div style="color: rgb(238, 49, 49); font-size: 20px;">
                <%
                    if (request.getAttribute("wrongname") != null) {
                        out.println("Пользователя " + request.getAttribute("wrongname") + " " + request.getAttribute("wronglastname") +
                            " не существует");
                        }
                %>
            </div>
            <form method="post">
                <label>Имя:
                    <input type="text" name="name" >
                </label></br>
                <label>Фамилия:
                    <input type="text" name="last_name" >
                </label></br>
                <label>Пароль:
                    <input type="password" name="pass">
                </label></br>
                <div style="text-align: center; margin-top: 20px;"><button type="submit">Войти</button></div>
            </form>
            <div style="margin-top: 10px;"><button onclick="location.href='/add'">Зарегистрироваться</button></div>
        </main>
        <footer></footer>
    </div>
</body>
</html>