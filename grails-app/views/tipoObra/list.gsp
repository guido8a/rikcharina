<html>
<head>
    <meta name="layout" content="main">
    <title>Tipo de Obra</title>
</head>

<div class="panel-info" style="padding: 3px; margin-top: 2px">
    <div class="btn-toolbar toolbar">
        <div class="btn-group">
            <a href="#" class="btn btn-sm btn-info" id="btnRegresar" title="Volver a parámetros">
                <i class="fa fa-arrow-left"></i> Parámetros
            </a>
        </div>
    </div>
</div>

<div class="panel panel-primary col-md-6" style="margin-top: 10px; text-align: center">
    <h3>Tipo de Obra</h3>
    <div class="panel-info" style="padding: 3px; margin-top: 2px">
        <div class="btn-toolbar toolbar">
            <div class="btn-group">
                <a href="#" class="btn btn-sm btn-success" id="btnAgregarTipoObra">
                    <i class="fa fa-plus"></i> Agregar tipo de Obra
                </a>
            </div>
        </div>
    </div>
    <div class="alert-info" style="text-align: center; font-size: 14px; font-weight: bold">
        * Haga clic derecho sobre un registro para desplegar su menú de opciones
    </div>
    <div id="tablaTipoObra"></div>
</div>

<script type="text/javascript">
    cargarTablaTipoObra();

    $("#btnRegresar").click(function () {
        location.href="${createLink(controller: 'inicio', action: 'parametros')}"
    });

    $("#btnAgregarTipoObra").click(function () {
        createEditTipoObra();
    });

    function cargarTablaTipoObra(){
        $.ajax({
            type: 'POST',
            url:'${createLink(controller: 'tipoObra', action: 'tablaTipoObra_ajax')}',
            data:{},
            success: function(msg){
                $("#tablaTipoObra").html(msg)
            }
        });
    }

    function createEditTipoObra(id) {
        var title = id ? "Editar" : "Crear";
        var data = id ? {id : id} : {};
        $.ajax({
            type    : "POST",
            url     : "${createLink(controller:'tipoObra', action:'form_ajax')}",
            data    : data,
            success : function (msg) {
                var b = bootbox.dialog({
                    id      : "dlgCreateEdit",
                    title   : title + " Tipo de Obra",
                    message : msg,
                    buttons : {
                        cancelar : {
                            label     : "Cancelar",
                            className : "btn-primary",
                            callback  : function () {
                            }
                        },
                        guardar  : {
                            id        : "btnSave",
                            label     : "<i class='fa fa-save'></i> Guardar",
                            className : "btn-success",
                            callback  : function () {
                                return submitFormTipoObra();
                            } //callback
                        } //guardar
                    } //buttons
                }); //dialog
                setTimeout(function () {
                    b.find(".form-control").first().focus()
                }, 500);
            } //success
        }); //ajax
    } //createEdit

    function submitFormTipoObra() {
        var $form = $("#frmTipoObra");
        var $btn = $("#dlgCreateEdit").find("#btnSave");
        if ($form.valid()) {
            var data = $form.serialize();
            $btn.replaceWith(spinner);
            var dialog = cargarLoader("Guardando...");
            $.ajax({
                type    : "POST",
                url     : $form.attr("action"),
                data    : data,
                success : function (msg) {
                    dialog.modal('hide');
                    var parts = msg.split("_");
                    if(parts[0] === 'ok'){
                        log(parts[1], "success");
                        cargarTablaTipoObra();
                    }else{
                        bootbox.alert('<i class="fa fa-exclamation-triangle text-danger fa-3x"></i> ' + '<strong style="font-size: 14px">' + parts[1] + '</strong>');
                        return false;
                    }
                }
            });
        } else {
            return false;
        }
    }

    function borrarTipoObra(id){
        bootbox.confirm({
            message: "<i class='fa fa-3x fa-exclamation-triangle text-danger'></i> <strong style='font-size: 14px'>  Está seguro de eliminar este tipo de obra? </strong>",
            buttons: {
                confirm: {
                    label: 'Borrar',
                    className: 'btn-success'
                },
                cancel: {
                    label: 'Cancelar',
                    className: 'btn-info'
                }
            },
            callback: function (result) {
                if(result){
                    $.ajax({
                        type:'POST',
                        url:'${createLink(controller: 'tipoObra', action: 'borrarTipoObra_ajax')}',
                        data:{
                            id: id
                        },
                        success:function(msg){
                            var parts = msg.split("_");
                            if(parts[0] === 'ok'){
                                log(parts[1],"success");
                                cargarTablaTipoObra();
                            }else{
                                log(parts[1],"error")
                            }
                        }
                    })
                }
            }
        });
    }

    function createContextMenu(node) {
        var $tr = $(node);
        var id = $tr.data("id");

        var items = {
            header: {
                label: "Acciones",
                header: true
            }
        };

        items.editar = {
            label: '<span class="text-info">Editar</span>',
            icon: 'fa fa-edit text-info',
            action: function () {
                createEditTipoObra(id)
            }
        };

        items.borrar = {
            label: '<span class="text-danger"> Borrar </span>',
            icon: "fa fa-trash text-danger",
            action: function () {
                borrarTipoObra(id)
            }
        };

        return items
    }

</script>
</html>