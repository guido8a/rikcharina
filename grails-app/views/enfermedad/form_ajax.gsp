<g:form class="form-horizontal" name="frmEnfermedad" action="saveEnfermedad_ajax">
    <g:hiddenField name="id" value="${enfermedadInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: enfermedadInstance, field: 'descripcion', 'error')} ">
        <span class="grupo">
            <label for="descripcion" class="col-md-2 control-label text-info">
                Descripción
            </label>
            <span class="col-md-8">
                <g:textField name="descripcion" maxlength="50" class="form-control required" value="${enfermedadInstance?.descripcion}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

</g:form>

<script type="text/javascript">
    var validator = $("#frmEnfermedad").validate({
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
            submitFormEnfermedad();
            return false;
        }
        return true;
    });
</script>