<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Bank</title>
        <link rel="stylesheet" href="style/index.css">
        <link rel="stylesheet" href="style/add.css">
        <link type="Image/x-icon" href="https://musicnova.ru/wa-data/public/site/bank-3.png" rel="icon">
</head>
<body>
    <div class="wrapper">
        <header>
            <button onclick="location.href='/'" class="back">Назад</button>
            <div style="text-align: center; width: 90%;">Your Bank</div>
        </header>
        <main style="align-items: center;">
            <div class="title">Регистрация</div>
            <form method="post">
                <label>Имя:
                    <input type="text" name="name" ></br>
                </label>
                <label>Фамилия:
                    <input type="text" name="last_name" ></br>
                </label>
                <label>Серия паспорта:
                    <input type="number" min="0" max="999999" name="series" ></br>
                </label>
                <label>Номер паспорта:
                    <input type="number" min="0" max="999999" name="number" ></br>
                </label>
                <label>Администратор:
                    <input type="checkbox" name="role" ></br>
                </label>
                <label>Пароль:
                    <input type="password" name="pass"></br>
                </label>
                <div style="text-align: center; margin-top: 20px;"><button type="submit">Зарегестрироваться</button></div>
            </form>
        </main>

        <footer></footer>
    </div>
</body>
</html>