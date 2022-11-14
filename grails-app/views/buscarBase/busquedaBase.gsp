<%@ page import="seguridad.Persona" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Base de Conocimiento</title>

    <style type="text/css">

    .alinear {
        text-align: center !important;
    }

    #buscar {
        width: 400px;
        border-color: #0c6cc2;
    }

    #limpiaBuscar {
        position: absolute;
        right: 5px;
        top: 0;
        bottom: 0;
        height: 14px;
        margin: auto;
        font-size: 14px;
        cursor: pointer;
        color: #ccc;
    }
    </style>

</head>

<body>
<h3 style="text-align: center; margin-top: 0px">Base de Conocimiento</h3>
<div style="margin-top: 0px; min-height: 60px" class="vertical-container">
    <p class="css-vertical-text">Buscar</p>

    <div class="linea"></div>

    <div>
        <div class="col-md-12">
            <div class="btn-group">
                <g:link controller="proyecto" action="proy" id="1" class="btn btn-sm btn-default">
                    <i class="fa fa-arrow-left"></i> Regresar a proyectos
                </g:link>
            </div>
            <span style="margin-left: 30px">Buscar en la base de conocimiento por:</span>
            <div class="btn-group">
                <input id="buscar" type="search" class="form-control" style="width: 200px">
            </div>
            <a href="#" name="busqueda" id="btnBuscar" class="btn btn-info btnBusqueda btn-ajax"><i
                    class="fas fa-search"></i> Buscar</a>
            <a href="#" id="actualizarPlbr" class="btn btn-success btnActualizar"><i
                    class="fa fa-redo"></i> Actualiza Buscador</a>
            <a href="#" id="btnBase" class="btn btn-warning sobrepuesto"
               title="Crear nuevo registro">
                <i class="fa fa-check"></i> Crear Nuevo
            </a>
        </div>
    </div>
</div>

<div style="margin-top: 30px; min-height: 450px" class="vertical-container">
    <p class="css-vertical-text">Resultado - Buscar en la Base de Conocimiento</p>

    <div class="linea"></div>
    <table class="table table-bordered table-hover table-condensed" style="width: 1070px;background-color: #a39e9e">
        <thead>
        <tr>
            <th class="alinear" style="width: 120px">Tema</th>
            <th class="alinear" style="width: 240px">Palabras clave</th>
            <th class="alinear" style="width: 240px">Problema</th>
            <th class="alinear" style="width: 460px">Solución</th>
        </tr>
        </thead>
    </table>

    <div id="bandeja">
    </div>
</div>

<div style="width: 100%"><strong>Nota</strong>: Si existen muchos registros que coinciden con el criterio de búsqueda, se retorna como máximo 20 <span
        class="text-info" style="margin-left: 40px">Se ordena por grado de relevancia</span>
</div>

<div class="modal fade " id="dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                %{--<h4 class="modal-title">Problema y Solución</h4>--}%
                Problema y Solución..
            </div>

            <div class="modal-body" id="dialog-body" style="padding: 15px">

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<div id="cargando" class="text-center hidden">
    <asset:image src="apli/spinner32.gif" style="padding: 40px;"/>
    <div class="loading-footer">Espere por favor</div>
</div>

<script>
    $(function () {
        $("#limpiaBuscar").click(function () {
            $("#buscar").val('');
        });
    });
</script>

<script type="text/javascript">


    $("#btnBase").click(function () {
        location.href="${createLink(controller: 'base', action: 'base')}"
    });

    $("#btnBuscar").click(function () {

        $("#bandeja").append($("#cargando").removeClass('hidden'));
        var buscar = $("#buscar").val();
        var datos = "buscar=" + buscar;

        $.ajax({
            type: "POST",
            url: "${g.createLink(controller: 'buscarBase', action: 'tablaBusquedaBase')}",
            data: datos,
            success: function (msg) {
                $("#bandeja").html(msg);
            },
            error: function (msg) {
                $("#bandeja").html("Ha ocurrido un error");
            }
        });

    });

    $("input").keyup(function (ev) {
        if (ev.keyCode == 13) {
            $(".btnBusqueda").click();
        }
    });

    function createContextMenu(node) {
        var $tr = $(node);

        var items = {
            header: {
                label: "Acciones",
                header: true
            }
        };

        var id = $tr.data("id");

        var ver = {
            label: 'Ver',
            id: 'ver',
            icon: "fa fa-search",
            action: function (e) {
                $("#dialog-body").html(spinner);
                $.ajax({
                    type: 'POST',
                    url: '${createLink(controller: 'base', action: 'show_ajax')}',
                    data: {
                        id: id
                    },
                    success: function (msg) {
                        $("#dialog-body").html(msg)
                    }
                });
                $("#dialog").modal("show");
            }
        };

        var aprobar = {
            label: "Aprobar artículo",
            icon: "fa fa-cogs",
            action: function () {
                location.href = '${createLink(controller: "base", action: "aprobar")}?id=' + id;
            }
        };

        var anexos = {
            label: 'Anexos: Imágenes y videos',
            icon: "fa fa-paperclip",
            action: function (e) {
                location.href = '${createLink(controller: 'imagen', action: 'verAnexos')}/' + id
            }
        };

        var editar = {
            label: 'Editar',
            icon: "fa fa-pen",
            action: function (e) {
                location.href = '${createLink(controller: 'base', action: 'base')}/' + id
            }
        };

        items.ver = ver;
        items.editar = editar;

        return items
    }

    $(".btnBorrar").click(function () {
        $("#memorando").val("");
        $("#asunto").val("");
        $("#fechaRecepcion_input").val('');
        $("#fechaBusqueda_input").val('')
    });

    $("#actualizarPlbr").click(function () {
        location.href = '${createLink(controller: 'buscarBase', action: 'actualizarPlbr')}'
    });

</script>

</body>
</html>