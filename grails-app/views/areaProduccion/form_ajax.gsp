<g:form class="form-horizontal" name="frmArea" action="saveArea_ajax">
    <g:hiddenField name="id" value="${areaInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: areaInstance, field: 'referencia', 'error')} ">
        <span class="grupo">
            <label for="referencia" class="col-md-3 control-label text-info">
                Referencia del lote
            </label>
            <span class="col-md-6">
                <g:textField name="referencia" maxlength="50" class="form-control required" value="${areaInstance?.referencia}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: areaInstance, field: 'tipoLote', 'error')} ">
        <span class="grupo">
            <label for="tipoLote" class="col-md-3 control-label text-info">
               Tipo de Lote
            </label>
            <span class="col-md-3">
                <g:select name="tipoLote" from="${rikcharina.TipoLote.list().sort{it.descripcion}}" class="form-control" optionKey="id"  optionValue="descripcion" value="${areaInstance?.tipoLote}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: areaInstance, field: 'area', 'error')} ">
        <span class="grupo">
            <label for="area" class="col-md-3 control-label text-info">
                Área del lote en m2
            </label>
            <span class="col-md-3">
                <g:textField name="area" maxlength="10" class="form-control number required" value="${areaInstance?.area}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: areaInstance, field: 'usoAgricola', 'error')} ">
        <span class="grupo">
            <label for="usoAgricola" class="col-md-3 control-label text-info">
                Uso agrícola (%)
            </label>
            <span class="col-md-3">
                <g:textField name="usoAgricola" maxlength="5" class="form-control number required" value="${areaInstance?.usoAgricola}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: areaInstance, field: 'usoPecuario', 'error')} ">
        <span class="grupo">
            <label for="usoPecuario" class="col-md-3 control-label text-info">
                Uso pecuario (%)
            </label>
            <span class="col-md-3">
                <g:textField name="usoPecuario" maxlength="5" class="form-control number required" value="${areaInstance?.usoPecuario}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: areaInstance, field: 'pendiente', 'error')} ">
        <span class="grupo">
            <label for="pendiente" class="col-md-3 control-label text-info">
                Pendiente del terreno (%)
            </label>
            <span class="col-md-3">
                <g:textField name="pendiente" maxlength="10" class="form-control number required" value="${areaInstance?.pendiente}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>
</g:form>

<script type="text/javascript">
    var validator = $("#frmArea").validate({
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
            submitFormAreas();
            return false;
        }
        return true;
    });
</script>