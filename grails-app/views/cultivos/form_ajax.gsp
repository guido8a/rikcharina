<g:form class="form-horizontal" name="frmCultivo" action="saveCultivo_ajax">
    <g:hiddenField name="id" value="${cultivoInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: cultivoInstance, field: 'planta', 'error')} ">
        <span class="grupo">
            <label for="planta" class="col-md-3 control-label text-info">
                Hace asociación de cultivos
            </label>
            <span class="col-md-3">
                <g:select name="planta" from="${rikcharina.Planta.list().sort{it.descripcion}}" class="form-control" optionKey="id"  optionValue="descripcion" value="${cultivoInstance?.planta?.id}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: cultivoInstance, field: 'area', 'error')} ">
        <span class="grupo">
            <label for="area" class="col-md-3 control-label text-info">
                Área de cultivo en m2
            </label>
            <span class="col-md-3">
                <g:textField name="area" maxlength="10" class="form-control number required" value="${cultivoInstance?.area}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

</g:form>

<script type="text/javascript">
    var validator = $("#frmCultivo").validate({
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
            submitFormCultivo();
            return false;
        }
        return true;
    });
</script>