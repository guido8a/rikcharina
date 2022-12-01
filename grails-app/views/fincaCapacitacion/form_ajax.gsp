<%@ page import="rikcharina.Capacitacion" %>

<g:form class="form-horizontal" name="frmCapacitacion" action="saveFincaCapacitacion_ajax">
    <g:hiddenField name="id" value="${capacitacionInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: capacitacionInstance, field: 'capacitacion', 'error')} ">
        <span class="grupo">
            <label for="capacitacion" class="col-md-3 control-label text-info">
               Cursos de capacitación
            </label>
            <span class="col-md-6">
                <g:select name="capacitacion" from="${Capacitacion.list().sort{it.descripcion}}" class="form-control" optionKey="id" optionValue="descripcion" value="${capacitacionInstance?.capacitacion?.id}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>
</g:form>

<script type="text/javascript">
    var validator = $("#frmCapacitacion").validate({
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
            submitFormCapacitacion();
            return false;
        }
        return true;
    });
</script>