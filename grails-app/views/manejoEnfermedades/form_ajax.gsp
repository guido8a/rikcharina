<%@ page import="rikcharina.Enfermedad" %>
<g:form class="form-horizontal" name="frmEnfermedad" action="saveManejoEnfermedad_ajax">
    <g:hiddenField name="id" value="${enfermedadInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: enfermedadInstance, field: 'enfermedad', 'error')} ">
        <span class="grupo">
            <label for="enfermedad" class="col-md-5 control-label text-info">
                Qué utiliza para el manejo de enfermedades
            </label>
            <span class="col-md-4">
                <g:select name="enfermedad" from="${rikcharina.Enfermedad.list().sort{it.descripcion}}" class="form-control" optionKey="id" optionValue="descripcion" value="${enfermedadInstance?.enfermedad?.id}"/>
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