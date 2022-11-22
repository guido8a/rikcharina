<table class="table table-condensed table-hover table-striped table-bordered">
    <thead>
    <tr>
        <th style="width: 30%">Descripción</th>
    </tr>
    </thead>
</table>

<div style="width: 99.7%;height: 350px; overflow-y: auto;float: right; margin-top: -20px">
    <table id="tablaPlanta" class="table-bordered table-condensed table-hover" style="width: 100%;">
        <tbody>
        <g:each status="i" in="${plantas}" var="planta" >
            <tr style="text-align: left" data-id="${planta?.id}">
                <td style="width: 30%">${planta?.descripcion}</td>
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