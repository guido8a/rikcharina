<%@ page import="rikcharina.Plaga" %>

<g:form class="form-horizontal" name="frmPlaga" action="saveManejoPlaga_ajax">
    <g:hiddenField name="id" value="${plagaInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: plagaInstance, field: 'plaga', 'error')} ">
        <span class="grupo">
            <label for="plaga" class="col-md-5 control-label text-info">
                Qué utiliza para el control de plagas
            </label>
            <span class="col-md-4">
                <g:select name="plaga" from="${rikcharina.Plaga.list().sort{it.descripcion}}" class="form-control" optionKey="id" optionValue="descripcion" value="${plagaInstance?.plaga?.id}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>
</g:form>

<script type="text/javascript">
    var validator = $("#frmPlaga").validate({
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
            submitFormPlaga();
            return false;
        }
        return true;
    });
</script>