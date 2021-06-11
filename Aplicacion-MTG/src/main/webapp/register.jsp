<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrate</title>
    <script>
      function onReady(callback) {
        var intervalId = window.setInterval(function () {
          if (document.getElementsByTagName("body")[0] !== undefined) {
            window.clearInterval(intervalId);
            callback.call(this);
          }
        }, 1000);
      }

      function setVisible(selector, visible) {
        document.querySelector(selector).style.display = visible
          ? "block"
          : "none";
      }

      onReady(function () {
        setVisible(".container-login", true);
        setVisible("#container-animation", false);
      });
    </script>
    <style>
        @import "https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css";
        <%@ include file="WEB-INF/css/register.style.main.css" %>
        <%@ include file="WEB-INF/css/spinner-animation.css" %>
    </style>
</head>
<body>

    <!-- CONTAINER DE REGISTRO -->
    <div class="container-login">
        <div class="container-login--header">
            <h1>Registrate</h1>
        </div>
        <div class="container-login--username">
            <i class="fa fa-user" aria-hidden="true"></i>
            <input type="text" placeholder="Correo electrónico">
        </div>
        <div class="container-login--password">
            <i class="fa fa-lock" aria-hidden="true"></i>
            <input type="password" placeholder="Contraseña">
        </div>
        <div class="container-login--password">
            <i class="fa fa-lock" aria-hidden="true"></i>
            <input type="password" placeholder="Confirmar contraseña">
        </div>
        <div class="container-login--submit">
            <button type="submit">Registrarse</button>
        </div>
        <div class="bottom-text">
            Ya tienes una cuenta? <a href="login.jsp">Inicia sesión</a>
        </div>
    </div>

    <!-- ANIMACIÓN DE CARGA HASTA QUE LA PAGINA ESTE LISTA -->
    <div id="container-animation">
      <div class="item">
        <img src="img/black-mana.png" width="40px" height="40px" />
      </div>
      <div class="item">
        <img src="img/blue-mana.png" width="40px" height="40px" />
      </div>
      <div class="item">
        <img src="img/green-mana.png" width="40px" height="40px" />
      </div>
      <div class="item">
        <img src="img/red-mana.png" width="40px" height="40px" />
      </div>
      <div class="item">
        <img src="img/white-mana.png" width="40px" height="40px" />
      </div>
    </div>

    <!-- SPINNER -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script>
      var radius = 100; // adjust to move out items in and out
      var fields = $(".item"),
        container = $("#container-animation"),
        width = container.width(),
        height = container.height();
      var angle = 0,
        step = (2 * Math.PI) / fields.length;
      fields.each(function () {
        var x = Math.round(
          width / 2 + radius * Math.cos(angle) - $(this).width() / 2
        );
        var y = Math.round(
          height / 2 + radius * Math.sin(angle) - $(this).height() / 2
        );
        if (window.console) {
          console.log($(this).text(), x, y);
        }
        $(this).css({
          left: x + "px",
          top: y + "px",
        });
        angle += step;
      });
    </script>
</body>
</html>