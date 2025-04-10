<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Адаптивный сайт</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
      <link rel="icon" href="${pageContext.request.contextPath}/img.png">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/quest.css">

</head>
<body>
    <div style="background-color:#f1f1f1;padding:15px;">
        <img src="img.png"/>
        <h1>Хогвартс выживалити</h1>
        <c:if test="${player != null}">
            <div>
                <a href="/view/statistics.jsp" class="btn btn-outline-primary">Статистика</a>
            </div>
        </c:if>
    </div>

    <div style="overflow:auto">
        <div class="menu">
            <!-- Меню будет адаптироваться -->
            <h1>Квесты:</h1>
            <div class="btn-group-vertical">
                <c:forEach var="quest" items="${quests}">
                    <a href="/quest?questId=${quest.getId()}" class="btn btn-outline-primary">${quest.getName()}</a>
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
                        <button type="submit" class="btn btn-outline-primary">Начать</button>
                    </form>
                </c:if>
            </c:if>
            <c:if test="${questSimple == null}">
                <h1>Основной текст</h1>
                <p>Текст, который адаптируется под экран</p>
            </c:if>

        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.min.js" integrity="sha384-VQqxDN0EQCkWoxt/0vsQvZswzTHUVOImccYmSyhJTp7kGtPed0Qcx8rK9h9YEgx+" crossorigin="anonymous"></script>
</body>
</html>