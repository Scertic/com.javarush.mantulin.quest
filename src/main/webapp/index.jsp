<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Адаптивный сайт</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Google Font: Source Sans Pro -->
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
      <!-- Font Awesome -->
      <link rel="stylesheet" href="http://lte.omsdb.ru/plugins/fontawesome-free/css/all.min.css">
      <!-- Theme style -->
      <link rel="stylesheet" href="https://lte.omsdb.ru/dist/css/adminlte.min.css">
      <link rel="icon" href="${pageContext.request.contextPath}/img.png">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/quest.css">

</head>
<body>
    <div style="background-color:#f1f1f1;padding:15px;">
        <img src="img.png"/>
        <h1>Хогвартс выживалити</h1>
        <c:if test="${player != null}">
            <div>
                <a href="/view/statistics.jsp" class="btn btn-default">Статистика</a>
            </div>
        </c:if>
    </div>

    <div style="overflow:auto">
        <div class="menu">
            <!-- Меню будет адаптироваться -->
            <h1>Квесты:</h1>
            <div class="btn-group-vertical">
                <c:forEach var="quest" items="${quests}">
                    <a href="/quest?questId=${quest.getId()}" class="btn btn-default">${quest.getName()}</a>
                </c:forEach>
            </div>
        </div>

        <div class="main">
            <c:if test="${questSimple != null && questSimple.getName() != null}">
                <h1>${questSimple.getName()}</h1>
                <p>${questSimple.getIntro()}</p>
                <c:if test="${questSimple.getId() == 1}">
                    <form method="POST" action="/game">
                    <c:if test="${player == null}">
                        <input type="text" id="playerName" name="playerName" required>
                    </c:if>
                    <c:if test="${player == null}">
                        <input type="hidden" name="playerName" value="${playerName}">
                    </c:if>
                        <input type="hidden" name="questId" value="${questSimple.getId()}">
                        <button type="submit" class="btn btn-primary">Начать</button>
                    </form>
                </c:if>
            </c:if>
            <c:if test="${questSimple == null}">
                <h1>Основной текст</h1>
                <p>Текст, который адаптируется под экран</p>
            </c:if>

        </div>
    </div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>