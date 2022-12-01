<table class="table table-condensed table-hover table-striped table-bordered">
    <thead>
    <tr style="width: 100%">
        <th style="width: 80%">Infraestructura</th>
    </tr>
    </thead>
</table>

<div style="width: 99.7%; min-height: 150px; overflow-y: auto;float: right; margin-top: -20px">
    <table id="tablaManejoE" class="table-bordered table-condensed table-hover" style="width: 100%;">
        <tbody>
        <g:each status="i" in="${equipos}" var="equipo" >
            <tr style="text-align: left" data-id="${equipo?.id}">
                <td style="width: 80%">${equipo?.equipo?.descripcion}</td>
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