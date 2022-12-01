<%@ page import="rikcharina.TipoObra" %>

<g:form class="form-horizontal" name="frmObra" action="saveObrasFinca_ajax">
    <g:hiddenField name="id" value="${obraInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: obraInstance, field: 'tipoObra', 'error')} ">
        <span class="grupo">
            <label for="tipoObra" class="col-md-2 control-label text-info">
                Tipo de obra
            </label>
            <span class="col-md-8">
                <g:select name="tipoObra" from="${TipoObra.list().sort{it.descripcion}}" class="form-control" optionKey="id" optionValue="descripcion" value="${obraInstance?.tipoObra?.id}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>
    <div class="form-group ${hasErrors(bean: obraInstance, field: 'estado', 'error')} ">
        <span class="grupo">
            <label for="estado" class="col-md-2 control-label text-info">
                Estado
            </label>
            <span class="col-md-4">
                <g:select name="estado" from="${['I' : 'Iniciado', 'A' : 'Avanzado', 'T' : 'Terminado']}" class="form-control" optionKey="key" optionValue="value" value="${obraInstance?.estado}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>
</g:form>

<script type="text/javascript">
    var validator = $("#frmObra").validate({
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
            submitFormObra();
            return false;
        }
        return true;
    });
</script>