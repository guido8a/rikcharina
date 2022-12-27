<html>
<head>
    <meta name="layout" content="main">
    <title>Puntajes</title>
</head>

<div class="panel-info" style="padding: 3px; margin-top: 2px">
    <div class="btn-toolbar toolbar">
        <div class="btn-group">
            <a href="#" class="btn btn-sm btn-info" id="btnRegresar" title="Volver a parámetros">
                <i class="fa fa-arrow-left"></i> Finca
            </a>
        </div>
    </div>
</div>

<div class="panel panel-primary col-md-12" style="margin-top: 10px; text-align: center">
    <h3>Finca: ${finca?.nombre}</h3>
    <h3>Puntajes</h3>
    <div class="panel-info" style="padding: 3px; margin-top: 2px">
        <div class="btn-toolbar toolbar">
            <div class="btn-group">
                <a href="#" class="btn btn-sm btn-success" id="btnReporte">
                    <i class="fa fa-file-excel"></i> Excel
                </a>
            </div>
        </div>
    </div>
    <div id="tablaPuntajes"></div>
</div>

<script type="text/javascript">
    cargarTablaPuntaje();

    $("#btnRegresar").click(function () {
        location.href="${createLink(controller: 'finca', action: 'finca')}/${finca?.id}"
    });


    function cargarTablaPuntaje(){
        $.ajax({
            type: 'POST',
            url:'${createLink(controller: 'finca', action: 'tablaPuntaje_ajax')}',
            data:{
                id: ${finca?.id}
            },
            success: function(msg){
                $("#tablaPuntajes").html(msg)
            }
        });
    }

    $("#btnReporte").click(function () {
        location.href="${createLink(controller: 'reportes', action: 'reportePuntajesExcel')}?id=${finca?.id}"
    })

</script>
</html>