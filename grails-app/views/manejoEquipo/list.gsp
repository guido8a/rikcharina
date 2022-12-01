<div class="container" style="width: 100%">
    <div class="panel-info" style="padding: 3px; margin-top: 2px">
        <div class="btn-toolbar toolbar">
            <div class="btn-group">
                <a href="#" class="btn btn-sm btn-success" id="btnAgregarObra">
                    <i class="fa fa-plus"></i> Agregar equipo
                </a>
            </div>
        </div>
    </div>
    <div class="alert-info" style="text-align: center; font-size: 14px; font-weight: bold">
        * Haga clic derecho sobre un registro para desplegar su menú de opciones
    </div>
    <div id="tablaEquipo"></div>
</div>

<script type="text/javascript">
    cargarTablaEquipo();

    $("#btnAgregarObra").click(function () {
        createEditEquipo();
    });

    function cargarTablaEquipo(){
        $.ajax({
            type: 'POST',
            url:'${createLink(controller: 'manejoEquipo', action: 'tablaManejoEquipos_ajax')}',
            data:{finca: '${finca}'},
            success: function(msg){
                $("#tablaEquipo").html(msg)
            }
        });
    }

    function createEditEquipo(id) {
        var title = id ? "Editar" : "Crear";
        var data = id ? {id : id} : {};
        $.ajax({
            type    : "POST",
            url     : "${createLink(controller:'manejoEquipo', action:'form_ajax')}",
            data    : data,
            success : function (msg) {
                var b = bootbox.dialog({
                    id      : "dlgCreateEdit",
                    title   : title + " Infraestructura",
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
                                return submitFormEquipo();
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

    function submitFormEquipo() {
        var $form = $("#frmEquipo");
        var $btn = $("#dlgCreateEdit").find("#btnSave");
        if ($form.valid()) {
            var data = $form.serialize();
            $btn.replaceWith(spinner);
            var dialog = cargarLoader("Guardando...");
            $.ajax({
                type    : "POST",
                url     : $form.attr("action"),
                data    : data + "&finca=${finca}",
                success : function (msg) {
                    dialog.modal('hide');
                    var parts = msg.split("_");
                    if(parts[0] === 'ok'){
                        log(parts[1], "success");
                        cargarTablaEquipo();
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

    function borrarEquipo(id){
        bootbox.confirm({
            message: "<i class='fa fa-3x fa-exclamation-triangle text-danger'></i> <strong style='font-size: 14px'>  Está seguro de eliminar esta infraestructura? </strong>",
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
                        url:'${createLink(controller: 'manejoEquipo', action: 'borrarManejoEquipo_ajax')}',
                        data:{
                            id: id
                        },
                        success:function(msg){
                            var parts = msg.split("_");
                            if(parts[0] === 'ok'){
                                log(parts[1],"success");
                                cargarTablaEquipo();
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
                createEditEquipo(id)
            }
        };

        items.borrar = {
            label: '<span class="text-danger"> Borrar </span>',
            icon: "fa fa-trash text-danger",
            action: function () {
                borrarEquipo(id)
            }
        };

        return items
    }

</script>
