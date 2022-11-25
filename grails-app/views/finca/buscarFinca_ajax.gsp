
<g:form class="form-horizontal" name="frmBuscarFinca" style="overflow-y: auto">
    <div class="col-md-12" style="margin-bottom: 10px">

        <div class="col-md-1">
            <label>Buscar:</label>
        </div>
        <div class="col-md-3">
            <g:select name="buscarP" from="${[0: 'Nombre', 1: 'Comunidad', 2 : 'Organización']}" class="form-control" optionValue="value" optionKey="key"/>
        </div>
        <div class="col-md-4">
            <g:textField name="txtBuscar" value="${''}" class="form-control" />
        </div>

        <div class="col-md-4 btn-group">
            <a href="#" class="btn btn-success" id="btnBusquedaFinca">
                <i class="fa fa-search"></i> Buscar
            </a>
            <a href="#" class="btn btn-warning" id="btnLimpiarBusqueda">
                <i class="fa fa-eraser"></i> Limpiar
            </a>
        </div>
    </div>

    <table class="table table-condensed table-bordered table-striped table-hover" style="width:100%;margin-top: 20px !important;">
        <thead style="width: 100%">
        <tr>
            <th style="width: 10%"><i class="fa fa-check"></i> </th>
            <th style="width: 30%">Nombre</th>
            <th style="width: 30%">Organización</th>
            <th style="width: 30%">Comunidad</th>
        </tr>
        </thead>
    </table>

    <div id="divTablaFinca">

    </div>
</g:form>

<script type="text/javascript">

    $(".form-control").keydown(function (ev) {
        if (ev.keyCode === 13) {
            $("#btnBusquedaFinca").click();
            return false;
        }
        return true;
    });

    $("#btnLimpiarBusqueda").click(function () {
        $("#txtBuscar").val('');
        cargarTablaFinca($("#buscarP").val(), $("#txtBuscar").val());
    });

    cargarTablaFinca($("#buscarP").val(), $("#txtBuscar").val());

    $("#btnBusquedaFinca").click(function (){
        var operador = $("#buscarP").val();
        var texto = $("#txtBuscar").val();
        cargarTablaFinca(operador, texto);
    });

    function cargarTablaFinca(operador, texto){
        var dialog = cargarLoader("Cargando...");
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'finca', action: 'tablaFincas_ajax')}',
            data:{
                operador: operador,
                texto: texto
            },
            success: function (msg) {
                dialog.modal('hide');
                $("#divTablaFinca").html(msg)
            }
        });
    }

</script>
