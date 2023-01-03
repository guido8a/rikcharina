<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Configuración</title>
</head>

<body>

%{--//password--}%

<div class="panel panel-info">
    <div class="panel-heading" role="tab" id="headerPass">
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                Cambiar clave de ingreso al sistema
            </a>
        </h4>
    </div>

    <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headerPass">
        <div class="panel-body">
            <g:form class="form-inline" name="frmPass" action="savePass_ajax">
                <g:hiddenField name="id" value="${usuario?.id}"/>

                <div class="form-group" style="margin-left: 10px;">
                    <label for="nuevoPass">Nueva clave</label>

                    <div class="input-group">
                        <g:passwordField name="nuevoPass" autocomplete="new-password" class="form-control required"/>
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    </div>
                </div>

                <div class="form-group" style="margin-left: 40px;">
                    <label for="passConfirm">Confirme la clave nueva</label>

                    <div class="input-group">
                        <g:passwordField name="passConfirm" class="form-control required"/>
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    </div>
                </div>
                <a href="#" id="btnSavePass" class="btn btn-primary" style="margin-left: 40px;">
                    <i class="fa fa-save"></i> Guardar
                </a>
            </g:form>
        </div>
    </div>
</div>



<script type="text/javascript">
    $(function () {
        var $frmPass = $("#frmPass");

        $("#btnSavePass").click(function () {

            if ($frmPass.valid()) {
                $.ajax({
                    type    : "POST",
                    url     : $frmPass.attr("action"),
                    data    : $frmPass.serialize(),
                    success : function (msg) {
                        closeLoader();
                        var parts = msg.split("_");
                        if(parts[0] === 'ok'){
                            var b = bootbox.dialog({
                                id      : "dlgCreateEdit",
                                title   : "Password modificado",
                                message : '<i class="fa fa-check text-success fa-3x"></i> ' + '<strong style="font-size: 14px">' + parts[1] + '</strong>',
                                closeButton: false,
                                buttons : {
                                    cancelar : {
                                        label     : "Aceptar",
                                        className : "btn-primary",
                                        callback  : function () {
                                            location.href = "${createLink(controller: "login", action: "logout" )}"
                                        }
                                    }
                                } //buttons
                            }); //dialog
                        }else{
                            bootbox.alert('<i class="fa fa-exclamation-triangle text-danger fa-3x"></i> ' + '<strong style="font-size: 14px">' + parts[1] + '</strong>');
                        }
                    }
                });
            }
            return false;
        });

    });
</script>

</body>
</html>