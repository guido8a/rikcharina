<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="seguridad.Persona" %>

<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>De la Mata a la Olla</title>
    <meta name="layout" content="main"/>
    <style type="text/css">
    @page {
        size: 8.5in 11in;  /* width height */
        margin: 0.25in;
    }

    .item {
        width: 260px;
        height: 225px;
        float: left;
        margin: 4px;
        font-family: 'open sans condensed';
        background-color: #e7f5f1;
        border: 1px;
        border-color: #5c6e80;
        border-style: solid;
    }
    .item2 {
        width: 660px;
        height: 160px;
        float: left;
        margin: 4px;
        font-family: 'open sans condensed';
        background-color: #eceeff;
        border: 1px;
        border-color: #5c6e80;
        border-style: solid;
    }

    .imagen {
        width: 200px;
        height: 140px;
        margin: auto;
        margin-top: 10px;
    }
    .imagen2 {
        width: 200px;
        height: 140px;
        margin: auto;
        margin-top: 10px;
        margin-right: 40px;
        float: right;
    }

    .texto {
        width: 90%;
        /*height: 50px;*/
        padding-top: 0px;
        margin: auto;
        margin: 8px;
        font-size: 16px;
        font-style: normal;
    }

    .fuera {
        margin-left: 15px;
        margin-top: 20px;
        /*background-color: #317fbf; */
        background-color: rgba(114, 131, 147, 0.9);
        border: none;
    }

    .titl {
        font-family: 'open sans condensed';
        font-weight: bold;
        text-shadow: -2px 2px 1px rgba(0, 0, 0, 0.25);
        color: #0070B0;
        margin-top: 20px;
    }

    body {
        background : #e5e4e7;
    }

    .color1 {
        background : #e7f5f1;
    }

    .color2 {
        background : #FFF;
    }


    section {
        padding-top: 4rem;
        padding-bottom: 5rem;
        background-color: #f1f4fa;
    }
    .wrap {
        display: flex;
        background: white;
        padding: 1rem 1rem 1rem 1rem;
        border-radius: 0.5rem;
        box-shadow: 7px 7px 30px -5px rgba(0,0,0,0.1);
        margin-bottom: 1rem;
        width: 553px; height: 130px
    }

    .wrap:hover {
        /*background: linear-gradient(135deg,#6394ff 0%,#0a193b 100%);*/
        background: linear-gradient(135deg, #e0fff8 0%,#e6f0f8 100%);
        /*color: white;*/
    }

    .ico-wrap {
        margin: auto;
    }

    .mbr-iconfont {
        font-size: 4.5rem !important;
        color: #313131;
        margin: 1rem;
        padding-right: 1rem;
    }
    .vcenter {
        margin: auto;
    }

    .mbr-section-title3 {
        text-align: left;
    }
    h2 {
        margin-top: 0.5rem;
        margin-bottom: 0.5rem;
    }
    .display-5 {
        font-family: 'Source Sans Pro',sans-serif;
        font-size: 1.4rem;
    }
    .mbr-bold {
        font-weight: 700;
    }

    p {
        padding-top: 0.5rem;
        padding-bottom: 0.5rem;
        line-height: 25px;
    }
    .display-6 {
        font-family: 'Source Sans Pro',sans-serif;
        font-size: 1re
    }


    </style>
</head>

<body>
<div class="dialog">
    <g:set var="inst" value="${utilitarios.Parametros.get(1)}"/>

    <div style="text-align: center;margin-bottom: 50px"><h2 class="titl">
        %{--            <p class="text-warning">${inst.institucion}</p>--}%
        <p class="text-warning">Sistema de la Mata a la Olla</p>
    </h2>
    </div>

    <div class="row mbr-justify-content-center">

    <a href= "${createLink(controller:'finca', action: 'finca')}" style="text-decoration: none">
        <div class="col-lg-6 mbr-col-md-10">
            <div class="wrap">
                <div style="width: 200px; height: 140px">
                    <asset:image src="apli/proyecto.jpeg" title="Datos de fincas"  width="80%" height="80%"/>
                </div>
                <div style="width: 450px; height: 220px">
                    <h2 class="mbr-fonts-style mbr-bold mbr-section-title3 display-5"><span>Fincas</span></h2>
                    <p class="mbr-fonts-style text1 mbr-text display-6">Datos de las fincas registradas en el sistema</p>
                </div>
            </div>
        </div>
    </a>

    <a href= "${createLink(controller:'reportes', action: 'reportes')}" style="text-decoration: none">
        <div class="col-lg-6 mbr-col-md-10">
            <div class="wrap">
                <div style="width: 200px; height: 140px">
                    <asset:image src="apli/proyecto.jpeg" title="Reportes"  width="80%" height="80%"/>
                </div>
                <div style="width: 450px; height: 120px">
                    <h2 class="mbr-fonts-style mbr-bold mbr-section-title3 display-5"><span>Reportes</span></h2>
                    <p class="mbr-fonts-style text1 mbr-text display-6">Reportes de datos de las fincas registradas en el
                        sistema, migración de datos a una hoja de cálculo.<br>
                    Datos por fincas de toda la ficha</p>
                </div>
            </div>
        </div>
    </a>

    <a href= "${createLink(controller:'inicio', action: 'parametros')}" style="text-decoration: none">
        <div class="col-lg-6 mbr-col-md-10">
            <div class="wrap">
                <div style="width: 200px; height: 140px">
                    <asset:image src="apli/proyecto.jpeg" title="Administración de fincas"  width="80%" height="80%"/>
                </div>
                <div style="width: 450px; height: 120px">
                    <h2 class="mbr-fonts-style mbr-bold mbr-section-title3 display-5"><span>Parámetros del Sistema</span></h2>
                    <p class="mbr-fonts-style text1 mbr-text display-6">Parámetros del sistema</p>
                </div>
            </div>
        </div>
    </a>

    <a href= "${createLink(controller:'canton', action: 'arbol')}" style="text-decoration: none">
        <div class="col-lg-6 mbr-col-md-10">
            <div class="wrap">
                <div style="width: 200px; height: 140px">
                    <asset:image src="apli/proyecto.jpeg" title="Cantones"  width="80%" height="80%"/>
                </div>
                <div style="width: 450px; height: 120px">
                    <h2 class="mbr-fonts-style mbr-bold mbr-section-title3 display-5"><span>Cantones de la provincia Cotopaxi</span></h2>
                    <p class="mbr-fonts-style text1 mbr-text display-6">Datos de cantones y parroquias de al provincia</p>
                </div>
            </div>
        </div>
    </a>

    <a href= "${createLink(controller:'descargas', action: 'aplicacion')}" style="text-decoration: none">
        <div class="col-lg-6 mbr-col-md-10">
            <div class="wrap">
                <div style="width: 200px; height: 140px">
                    <asset:image src="apli/portada.png" title="Aplicación móvil"  width="80%" height="80%"/>
                </div>
                <div style="width: 450px; height: 120px">
                    <h2 class="mbr-fonts-style mbr-bold mbr-section-title3 display-5"><span>Aplicación móvil</span></h2>
                    <p class="mbr-fonts-style text1 mbr-text display-6">Apliación móvil para Android, funciona en
                    tabletas y celulares.</p>
                </div>
            </div>
        </div>
    </a>



</div>
<script type="text/javascript">
    $(".fuera").hover(function () {
        var d = $(this).find(".imagen,.imagen2")
        d.width(d.width() + 10)
        d.height(d.height() + 10)

    }, function () {
        var d = $(this).find(".imagen, .imagen2")
        d.width(d.width() - 10)
        d.height(d.height() - 10)
    })


    $(function () {
        $(".openImagenDir").click(function () {
            openLoader();
        });

        $(".openImagen").click(function () {
            openLoader();
        });
    });



</script>
</body>
</html>
