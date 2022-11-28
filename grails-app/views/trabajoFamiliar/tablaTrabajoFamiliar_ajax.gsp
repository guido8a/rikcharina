<table class="table table-condensed table-hover table-striped table-bordered">
    <thead>
    <tr style="width: 100%">
        <th style="width: 25%">Familiar</th>
        <th style="width: 25%">Número</th>
        <th style="width: 25%">Áctividad</th>
        <th style="width: 25%">Tipo</th>
    </tr>
    </thead>
</table>

<div style="width: 99.7%; min-height: 150px; overflow-y: auto;float: right; margin-top: -20px">
    <table id="tablaAnimal" class="table-bordered table-condensed table-hover" style="width: 100%;">
        <tbody>
        <g:each status="i" in="${trabajos}" var="trabajo" >
            <tr style="text-align: left" data-id="${trabajo?.id}">
                <td style="width: 25%">${trabajo?.familia?.descripcion}</td>
                <td style="width: 25%">${trabajo?.numero}</td>
                <td style="width: 25%">${trabajo?.actividad}</td>
                <td style="width: 25%">${trabajo?.tipo}</td>
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