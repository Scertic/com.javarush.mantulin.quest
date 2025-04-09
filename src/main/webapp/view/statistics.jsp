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
    <style>
        * {
            box-sizing: border-box;
        }

        .menu {
            float: left;
            width: 20%;
        }

        .main {
            float: left;
            width: 60%;
            padding: 0 20px;
        }

        .right {
            float: left;
            width: 20%;
        }

        @media only screen and (max-width: 768px) {
            .menu, .main, .right {
                width: 100%;
            }
        }
        body {
            padding:5px;
        }
        .btn-group-vertical {
            width: 100%;
        }
        img {
            width: 70px;
            display: block;
            float: left;
            padding:5px;
        }
    </style>
</head>
<body>
    <div style="background-color:#f1f1f1;padding:15px;">
            <img src="/img.png"/>
            <h1>Хогвартс выживалити</h1>
            <div>
                <a href="/" class="btn btn-default">На главную</a>
            </div>
    </div>

    <div style="overflow:auto">
        <div class="main">
            <h2>${player.getName()}</h2>
            <c:forEach var="achievement" items="${player.getRewards().keySet()}">
                <h3>${achievement.getDescription()}${player.getRewards().get(achievement)}</h3>
            </c:forEach>
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