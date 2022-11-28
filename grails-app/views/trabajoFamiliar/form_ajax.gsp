<g:form class="form-horizontal" name="frmTrabajo" action="saveTrabajo_ajax">
    <g:hiddenField name="id" value="${trabajoInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: trabajoInstance, field: 'familia', 'error')} ">
        <span class="grupo">
            <label for="familia" class="col-md-3 control-label text-info">
                Familiar
            </label>
            <span class="col-md-3">
                <g:select name="familia" from="${rikcharina.Familia.list().sort{it.descripcion}}" class="form-control" optionKey="id"  optionValue="descripcion" value="${trabajoInstance?.familia?.id}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: trabajoInstance, field: 'numero', 'error')} ">
        <span class="grupo">
            <label for="numero" class="col-md-3 control-label text-info">
                Número
            </label>
            <span class="col-md-6">
                <g:textField name="numero" maxlength="3" class="form-control number required" value="${trabajoInstance?.numero}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: trabajoInstance, field: 'actividad', 'error')} ">
        <span class="grupo">
            <label for="numero" class="col-md-3 control-label text-info">
                Actividad
            </label>
            <span class="col-md-6">
                <g:textField name="actividad" maxlength="50" class="form-control  required" value="${trabajoInstance?.actividad}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: trabajoInstance, field: 'tipo', 'error')} ">
        <span class="grupo">
            <label for="tipo" class="col-md-3 control-label text-info">
                Tipo
            </label>
            <span class="col-md-3">
                <g:select name="tipo" from="${['Principal' : 'Principal' , 'Secundaria' : 'Secundaria']}" class="form-control" optionKey="key"  optionValue="value" value="${trabajoInstance?.tipo}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

</g:form>

<script type="text/javascript">
    var validator = $("#frmArea").validate({
        errorClass     : "help-block",
        errorPlacement : function (error, element) {
            if (element.parent().hasClass("input-group")) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
            element.parents(".grupo").addClass('has-error');
        },
        success        : function (label) {
            label.parents(".grupo").removeClass('has-error');
        }
    });
    $(".form-control").keydown(function (ev) {
        if (ev.keyCode === 13) {
            submitFormAreas();
            return false;
        }
        return true;
    });
</script>