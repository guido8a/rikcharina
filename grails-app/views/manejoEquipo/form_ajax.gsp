<%@ page import="rikcharina.Equipo" %>

<g:form class="form-horizontal" name="frmEquipo" action="saveManejoEquipo_ajax">
    <g:hiddenField name="id" value="${equipoInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: equipoInstance, field: 'equipo', 'error')} ">
        <span class="grupo">
            <label for="equipo" class="col-md-3 control-label text-info">
                Infraestructura de postcosecha
            </label>
            <span class="col-md-6">
                <g:select name="equipo" from="${Equipo.list().sort{it.descripcion}}" class="form-control" optionKey="id" optionValue="descripcion" value="${equipoInstance?.equipo?.id}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>
</g:form>

<script type="text/javascript">
    var validator = $("#frmEquipo").validate({
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
            submitFormEquipo();
            return false;
        }
        return true;
    });
</script>