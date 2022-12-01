<%@ page import="rikcharina.Siembra" %>

<g:form class="form-horizontal" name="frmForestal" action="saveManejoForestal_ajax">
    <g:hiddenField name="id" value="${forestalInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: forestalInstance, field: 'siembra', 'error')} ">
        <span class="grupo">
            <label for="siembra" class="col-md-5 control-label text-info">
                Cómo están sembrados
            </label>
            <span class="col-md-4">
                <g:select name="siembra" from="${Siembra.list().sort{it.descripcion}}" class="form-control" optionKey="id" optionValue="descripcion" value="${forestalInstance?.siembra?.id}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>
</g:form>

<script type="text/javascript">
    var validator = $("#frmForestal").validate({
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
            submitFormForestal();
            return false;
        }
        return true;
    });
</script>