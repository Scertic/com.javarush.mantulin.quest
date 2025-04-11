<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Курс</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
    <link rel="icon" href="${pageContext.request.contextPath}/img.png">
          <link rel="stylesheet" href="${pageContext.request.contextPath}/css/quest.css">
</head>
<body>
    <div style="background-color:#f1f1f1;padding:15px;">
        <h1>${questFull.getName()}</h1>
    </div>

    <div style="overflow:auto">
        <div class="main">
        <c:if test="${win == 1}">
                    <h1>Ты победил!</h1>
                    <a href="/" class="btn btn-outline-primary">На главную</a>
        </c:if>
        <c:if test="${loose == 1}">
            <h1>Ты проиграл!</h1>
            <a href="/" class="btn btn-outline-primary">На главную</a>
        </c:if>
        <c:if test="${loose == null && win == null}">
            <h2>${questFull.getQuestions().get(questionId).getName()}</h2>
            <p>${questFull.getQuestions().get(questionId).getText()}</p>
            <div>
                <c:forEach var="answer" items="${questFull.getQuestions().get(questionId).getAnswers()}">
                    <a href="/game?questionId=${answer.getNextQuestionId()}" class="btn btn-outline-primary">${answer.getText()}</a><br>
                </c:forEach>
            </div>
        </c:if>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.min.js" integrity="sha384-VQqxDN0EQCkWoxt/0vsQvZswzTHUVOImccYmSyhJTp7kGtPed0Qcx8rK9h9YEgx+" crossorigin="anonymous"></script>
</body>
</html>