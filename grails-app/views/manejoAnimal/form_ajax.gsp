<%@ page import="rikcharina.Animal" %>

<g:form class="form-horizontal" name="frmAnimal" action="saveManejoAnimal_ajax">
    <g:hiddenField name="id" value="${animalInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: animalInstance, field: 'animal', 'error')} ">
        <span class="grupo">
            <label for="animal" class="col-md-5 control-label text-info">
                Animales de la finca
            </label>
            <span class="col-md-4">
                <g:select name="animal" from="${Animal.list().sort{it.descripcion}}" class="form-control" optionKey="id" optionValue="descripcion" value="${animalInstance?.animal?.id}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: animalInstance, field: 'numero', 'error')} ">
        <span class="grupo">
            <label for="numero" class="col-md-5 control-label text-info">
                Número de animales o colmenas
            </label>
            <span class="col-md-3">
                <g:textField name="numero" maxlength="6" class="form-control number required" value="${animalInstance?.numero}"/>
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