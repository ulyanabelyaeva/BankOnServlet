<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="ru.belyaeva.entity.*" %>
<%@ page import ="ru.belyaeva.model.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
        <link rel="stylesheet" href="style/index.css">
        <link rel="stylesheet" href="style/add.css">
        <title>Your Bank</title>
        <link type="Image/x-icon" href="https://musicnova.ru/wa-data/public/site/bank-3.png" rel="icon">
</head>
<body>
    <div class="wrapper">
        <header>
            <button onclick="location.href='/user'" class="back">Назад</button>
            <div style="text-align: center; width: 90%;">Your Bank</div>
        </header>
        <main style="align-items: center;">
            <div class="title">Редактирование</div>
            <form method="post">
                <label>Имя:
                    <input type="text" name="name" value="<%=ModelUser.getInstance().getUser().getName()%>" ></br>
                </label>
                <label>Фамилия:
                    <input type="text" name="last_name" value="<%=ModelUser.getInstance().getUser().getLastName()%>"></br>
                </label>
                <label>Серия паспорта:
                    <input type="number" min="0" max="999999" name="series" value="<%=ModelUser.getInstance().getUser().getSeries()%>"></br>
                </label>
                <label>Номер паспорта:
                    <input type="number" min="0" max="999999" name="number" value="<%=ModelUser.getInstance().getUser().getNumber()%>"></br>
                </label>
                <label>Пароль:
                    <input type="password" name="pass" value="<%=ModelUser.getInstance().getUser().getPassword()%>"></br>
                </label>
                <div style="text-align: center; margin-top: 20px;"><button type="submit">Готово</button></div>
            </form>
        </main>

        <footer></footer>
    </div>
</body>
</html>