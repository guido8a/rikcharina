<table class="table table-condensed table-hover table-striped table-bordered">
    <thead>
    <tr style="width: 100%">
        <th style="width: 15%">Tipo de Lote</th>
        <th style="width: 19%">Referencia</th>
        <th style="width: 13%">Área (m2)</th>
        <th style="width: 15%">Uso agrícola (%)</th>
        <th style="width: 15%">Uso pecuario (%)</th>
        <th style="width: 13%">Pendiente (%)</th>
    </tr>
    </thead>
</table>

<div style="width: 99.7%; min-height: 150px; overflow-y: auto;float: right; margin-top: -20px">
    <table id="tablaAnimal" class="table-bordered table-condensed table-hover" style="width: 100%;">
        <tbody>
        <g:each status="i" in="${areas}" var="area" >
            <tr style="text-align: left" data-id="${area?.id}">
                <td style="width: 15%">${area?.tipoLote?.descripcion}</td>
                <td style="width: 19%">${area?.referencia}</td>
                <td style="width: 13%">${area?.area}</td>
                <td style="width: 15%">${area?.usoAgricola}</td>
                <td style="width: 15%">${area?.usoPecuario}</td>
                <td style="width: 13%">${area?.pendiente}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

<script type="text/javascript">

    $(function () {
        $("tr").contextMenu({
            items  : createContextMenu,
            onShow : function ($element) {
                $element.addClass("trHighlight");
            },
            onHide : function () {
                $(".trHighlight").removeClass("trHighlight");
            }
        });
    });

</script>