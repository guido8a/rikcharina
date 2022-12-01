<%@ page import="rikcharina.Cargo" %>

<g:form class="form-horizontal" name="frmCargo" action="saveFincaCargo_ajax">
    <g:hiddenField name="id" value="${cargoInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: cargoInstance, field: 'cargo', 'error')} ">
        <span class="grupo">
            <label for="cargo" class="col-md-5 control-label text-info">
                Cargos desempeñados
            </label>
            <span class="col-md-4">
                <g:select name="cargo" from="${Cargo.list().sort{it.descripcion}}" class="form-control" optionKey="id" optionValue="descripcion" value="${cargoInstance?.cargo?.id}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>
</g:form>

<script type="text/javascript">
    var validator = $("#frmCargo").validate({
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
            submitFormCargo();
            return false;
        }
        return true;
    });
</script>