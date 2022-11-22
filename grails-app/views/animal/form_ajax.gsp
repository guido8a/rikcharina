<g:form class="form-horizontal" name="frmAnimal" action="saveAnimal_ajax">
    <g:hiddenField name="id" value="${animalInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: animalInstance, field: 'descripcion', 'error')} ">
        <span class="grupo">
            <label for="descripcion" class="col-md-2 control-label text-info">
                Descripción
            </label>
            <span class="col-md-8">
                <g:textField name="descripcion" maxlength="50" class="form-control required" value="${animalInstance?.descripcion}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

</g:form>

<script type="text/javascript">
    var validator = $("#frmAnimal").validate({
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
            submitFormAnimal();
            return false;
        }
        return true;
    });
</script>