<div class="container" style="width: 100%">
    <div class="panel-info" style="padding: 3px; margin-top: 2px">
        <div class="btn-toolbar toolbar">
            <div class="btn-group">
                <a href="#" class="btn btn-sm btn-success" id="btnAgregarObra">
                    <i class="fa fa-plus"></i> Agregar obra
                </a>
            </div>
        </div>
    </div>
    <div class="alert-info" style="text-align: center; font-size: 14px; font-weight: bold">
        * Haga clic derecho sobre un registro para desplegar su menú de opciones
    </div>
    <div id="tablaObra"></div>
</div>

<script type="text/javascript">
    cargarTablaObra();

    $("#btnAgregarObra").click(function () {
        createEditObra();
    });

    function cargarTablaObra(){
        $.ajax({
            type: 'POST',
            url:'${createLink(controller: 'obrasFinca', action: 'tablaObrasFinca_ajax')}',
            data:{finca: '${finca}'},
            success: function(msg){
                $("#tablaObra").html(msg)
            }
        });
    }

    function createEditObra(id) {
        var title = id ? "Editar" : "Crear";
        var data = id ? {id : id} : {};
        $.ajax({
            type    : "POST",
            url     : "${createLink(controller:'obrasFinca', action:'form_ajax')}",
            data    : data,
            success : function (msg) {
                var b = bootbox.dialog({
                    id      : "dlgCreateEdit",
                    title   : title + " Obra",
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
                                return submitFormObra();
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

    function submitFormObra() {
        var $form = $("#frmObra");
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
                        cargarTablaObra();
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

    function borrarObra(id){
        bootbox.confirm({
            message: "<i class='fa fa-3x fa-exclamation-triangle text-danger'></i> <strong style='font-size: 14px'>  Está seguro de eliminar esta obra? </strong>",
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
                        url:'${createLink(controller: 'obrasFinca', action: 'borrarObraFinca_ajax')}',
                        data:{
                            id: id
                        },
                        success:function(msg){
                            var parts = msg.split("_");
                            if(parts[0] === 'ok'){
                                log(parts[1],"success");
                                cargarTablaObra();
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
                createEditObra(id)
            }
        };

        items.borrar = {
            label: '<span class="text-danger"> Borrar </span>',
            icon: "fa fa-trash text-danger",
            action: function () {
                borrarObra(id)
            }
        };

        return items
    }

</script>
