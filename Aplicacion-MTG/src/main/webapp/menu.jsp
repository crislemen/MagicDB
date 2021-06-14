<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@page import="es.iespuertodelacruz.magic.controlador.MagicController"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>

        <!-- ICONOS -->
        <link rel="icon" href="https://magic.wizards.com/sites/all/themes/wiz_mtg/icons/touch-icon-16.png" sizes="16x16" />
        <link rel="icon" href="https://magic.wizards.com/sites/all/themes/wiz_mtg/icons/touch-icon-32.png" sizes="32x32" />
        <link rel="icon" href="https://magic.wizards.com/sites/all/themes/wiz_mtg/icons/touch-icon-96.png" sizes="96x96" />
        
        <style>
            <%@ include file="WEB-INF/css/style.menu.main.css" %>
            <%@ include file="WEB-INF/css/spinner-animation.css" %>
        </style>
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
                setVisible("body", true);
                setVisible("form", true)
                setVisible("#container-animation", false);
            });
        </script>
    </head>
    <body>       
        
        <form method="post" action="" class="form" onclick="">
            <div class="bannerHeader">
                <div class="head">
                <div class="backgroundTop">
                    <img src="img/topbanner.png" alt="" class="HeaderImage" />
                </div>
                <a href="">
                    <img src="img/magic_logo.png" alt="" class="MagicLogo" />
                </a>
                </div>
            </div>

            <div class="box-container-elements">
                <div class="container-title-menu">
                <header>Gatherer</header>
                </div>

                <div class="container-info-text">
                <p>
                    Bienvenido a Gatherer, el buscador de cartas, aquí podrás realizar busquedas
                    de las cartas de la expansión de Magic Origins
                </p>
                </div>

                <div class="container-search">
                <div class="search-box">
                    <input type="text" class="textboxinput" name="textbuscar"/>
                </div>
                <div class="searchButton-box">
                    <input
                    type="submit"
                    name=""
                    id=""
                    class="searchButton"
                    value="Buscar"
                    />
                </div>
                </div>
                

                <div class="container-filter">
                <b>Filtrar por:</b>
                <p>Formato de la carta</p>
                <div class="container-filter-by--element">
                    <select name="" id="">
                    <option value=""></option>
                    <option value="Brawl">Brawl</option>
                    <option value="Commander">Commander</option>
                    <option value="Legacy">Legacy</option>
                    <option value="Modern">Modern</option>
                    <option value="Pauper">Pauper</option>
                    <option value="Pioneer">Pioneer</option>
                    <option value="Standard">Standard</option>
                    <option value="Vintage">Vintage</option>
                    </select>
                </div>

                <p>Tipo de carta</p>
                <div class="container-filter-by--element">
                    <select name="" id="">
                    <option value=""></option>
                    <option value="Artifact">Artifact</option>
                    <option value="Basic">Basic</option>
                    <option value="Conspiracy">Conspiracy</option>
                    <option value="Creature">Creature</option>
                    <option value="Eaturecray">Eaturecray</option>
                    <option value="Enchantment">Enchantment</option>
                    <option value="Ever">Ever</option>
                    <option value="Host">Host</option>
                    <option value="Instant">Instant</option>
                    <option value="Land">Land</option>
                    <option value="Legendary">Legendary</option>
                    <option value="Ongoing">Ongoing</option>
                    <option value="Phenomenon">Phenomenon</option>
                    <option value="Plane">Plane</option>
                    <option value="Planeswalker">Planeswalker</option>
                    <option value="Scariest">Scariest</option>
                    <option value="Scheme">Scheme</option>
                    <option value="See">See</option>
                    <option value="Snow">Snow</option>
                    <option value="Sorcery">Sorcery</option>
                    <option value="Summon">Summon</option>
                    <option value="Tribal">Tribal</option>
                    <option value="Vanguard">Vanguard</option>
                    <option value="World">World</option>
                    <option value="You'll">You'll</option>
                    </select>
                </div>
                </div>

                <div class="container-filter-colors">
                <b>Buscar por color:</b>
                <div class="container-colors">
                    <span class="search-mana-container">
                    <input class="regular-checkbox big-checkbox" type="checkbox" />
                    <label for=""></label>
                    <img title="W" src="img/white-mana.png" alt="W" />
                    </span>

                    <span class="search-mana-container">
                    <input class="regular-checkbox big-checkbox" type="checkbox" />
                    <label for=""></label>
                    <img title="U" src="img/blue-mana.png" alt="U" />
                    </span>

                    <span class="search-mana-container">
                    <input class="regular-checkbox big-checkbox" type="checkbox" />
                    <label for=""></label>
                    <img title="B" src="img/black-mana.png" alt="B" />
                    </span>

                    <span class="search-mana-container">
                    <input class="regular-checkbox big-checkbox" type="checkbox" />
                    <label for=""></label>
                    <img title="R" src="img/red-mana.png" alt="R" />
                    </span>

                    <span class="search-mana-container">
                    <input class="regular-checkbox big-checkbox" type="checkbox" />
                    <label for=""></label>
                    <img title="G" src="img/green-mana.png" alt="G" />
                    </span>
                </div>
                </div>
            </div>
        </form>

        <%
            MagicController magicController = new MagicController();
            String nombreBuscar = request.getParameter("textbuscar");
            
            if(nombreBuscar != null){
                
                magicController.buscarPorNombre(nombreBuscar);
            }else{
                System.out.println("error");
            }
        %>    
        
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