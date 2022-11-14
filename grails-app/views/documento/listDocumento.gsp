<%@ page import="monitor.Fuente" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Documentos</title>
</head>

<div class="panel panel-primary col-md-12">
    <h3>Documentos del cantón: ${canton?.nombre}</h3>
    <div class="panel-info" style="padding: 3px; margin-top: 2px">
        <div class="btn-toolbar toolbar">
            <div class="btn-group">
                <g:if test="${sesion}">
                    <g:link controller="semaforo" action="arbol" class="btn btn-sm btn-default">
                        <i class="fa fa-arrow-left"></i> Regresar a Documentos
                    </g:link>
                </g:if>
                <g:link controller="provincia" action="mapa" class="btn btn-sm btn-default">
                    <i class="fa fa-arrow-left"></i> Regresar al Mapa
                </g:link>
            </div>
            <g:if test="${sesion}">
                <div class="btn-group">
                    <a href="#" class="btn btn-sm btn-success" id="btnAddDoc">
                        <i class="fa fa-plus"></i> Agregar documento
                    </a>
                </div>
            </g:if>
            <div class="btn-group col-md-3 pull-right">
                <div class="input-group input-group-sm">
                    <input type="text" class="form-control input-sm " id="searchDoc" placeholder="Buscar"/>
                    <span class="input-group-btn">
                        <a href="#" class="btn btn-default" id="btnSearchDoc"><i class="fa fa-search"></i></a>
                    </span>
                </div><!-- /input-group -->
            </div>
        </div>
    </div>

    <div class="alert-warning" style="text-align: center; font-size: 14px; font-weight: bold">
        * Haga clic derecho sobre un registro para desplegar su menú de opciones
    </div>


    <div id="tablaDocumentos"></div>
</div>



<script type="text/javascript">
    cargarTablaDocumento();

    $("#btnAddDoc").click(function () {
        createEditDocumento();
    });

    function cargarTablaDocumento(search){
        var data = {
            id: '${canton?.id}'
        };
        if (search) {
            data.search = search;
        }
        $.ajax({
            type: 'POST',
            url:'${createLink(controller: 'documento', action: 'tablaDocumentos_ajax')}',
            data:data,
            success: function(msg){
                $("#tablaDocumentos").html(msg)
            }
        });
    }

    function submitFormDocumento() {
        var $form = $("#frmDocumento");
        var $btn = $("#dlgCreateEdit").find("#btnSave");
        if ($form.valid()) {
            $btn.replaceWith(spinner);
            openLoader("Guardando Documento");
            var formData = new FormData($form[0]);
            $.ajax({
                url         : $form.attr("action"),
                type        : 'POST',
                data        : formData,
                async       : false,
                cache       : false,
                contentType : false,
                processData : false,
                success     : function (msg) {
                    var parts = msg.split("*");
                    log(parts[1], parts[0] == "SUCCESS" ? "success" : "error"); // log(msg, type, title, hide)
                    closeLoader();
                    if (parts[0] == "SUCCESS") {
                        cargarTablaDocumento();
                        $("#dlgCreateEdit").modal("hide");
                    } else {
                        spinner.replaceWith($btn);
                        return false;
                    }
                },
                error       : function () {
                }
            });
        } else {
            return false;
        } //else
    }

    function deleteDocumento(itemId) {
        bootbox.dialog({
            title   : "Alerta",
            message : "<i class='fa fa-trash fa-3x pull-left text-danger text-shadow'></i><p>" +
                "¿Está seguro que desea eliminar el Documento seleccionado? Esta acción no se puede deshacer.</p>",
            buttons : {
                cancelar : {
                    label     : "Cancelar",
                    className : "btn-primary",
                    callback  : function () {
                    }
                },
                eliminar : {
                    label     : "<i class='fa fa-trash'></i> Eliminar",
                    className : "btn-danger",
                    callback  : function () {
                        openLoader("Eliminando Documento");
                        $.ajax({
                            type    : "POST",
                            url     : '${createLink(controller:'documento', action:'delete_ajax')}',
                            data    : {
                                id : itemId
                            },
                            success : function (msg) {
                                var parts = msg.split("*");
                                log(parts[1], parts[0] == "SUCCESS" ? "success" : "error"); // log(msg, type, title, hide)
                                closeLoader();
                                if (parts[0] == "SUCCESS") {
                                    cargarTablaDocumento();
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    function createEditDocumento(id) {
        var title = id ? "Editar" : "Crear";
        var data = id ? {id : id} : {};
        data.canton = "${canton.id}";
        $.ajax({
            type    : "POST",
            url     : "${createLink(controller:'documento', action:'formDocumento_ajax')}",
            data    : data,
            success : function (msg) {
                var b = bootbox.dialog({
                    id      : "dlgCreateEdit",
                    title   : title + " Documento",
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
                                return submitFormDocumento();
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

    function downloadDocumento(id) {
        $.ajax({
            type    : "POST",
            url     : "${createLink(controller:'documento', action:'existeDoc_ajax')}",
            data    : {
                id : id
            },
            success : function (msg) {
                if (msg == "OK") {
                    location.href = "${createLink(controller: 'documento', action: 'downloadDoc')}/" + id;
                } else {
                    log("El documento solicitado no se encontró en el servidor", "error"); // log(msg, type, title, hide)
                }
            }
        });
    }


    function createContextMenu(node) {
        var $tr = $(node);

        var items = {
            header: {
                label: "Acciones",
                header: true
            }
        };

        var id = $tr.data("id");

        var editar = {
            label: 'Editar',
            icon: "fa fa-edit",
            action: function (e) {
                createEditDocumento(id)
            }
        };
        var descargar = {
            label: 'Descargar',
            icon: "fa fa-download",
            action: function (e) {
                downloadDocumento(id)
            }
        };
        var borrar = {
            label: 'Borrar',
            icon: "fa fa-trash",
            action: function (e) {
                deleteDocumento(id)
            }
        };

        items.descargar = descargar;

        if('${sesion}') {
            items.editar = editar;
            items.borrar = borrar;
        }

        return items
    }




    $(function () {
        $("#btnSearchDoc").click(function () {
            cargarTablaDocumento($.trim($("#searchDoc").val()));
        });
        $("#searchDoc").keyup(function (ev) {
            if (ev.keyCode == 13) {
                cargarTablaDocumento($.trim($("#searchDoc").val()));
            }
        });
    });
</script>
</html>