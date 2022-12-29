<table class="table table-condensed table-hover table-striped table-bordered">
    <thead>
    <tr>
        <th style="width: 50%">Concepto</th>
        <th style="width: 35%">Valor</th>
        <th style="width: 15%">Puntaje</th>
    </tr>
    </thead>
</table>

<div style="width: 99.7%;height: 450px; overflow-y: auto;float: right; margin-top: -20px">
    <table id="tablaPlanta" class="table-bordered table-condensed table-hover" style="width: 100%;">
        <tbody>
        <g:each status="i" in="${puntajes}" var="puntaje" >
            <tr style="text-align: left">
                <td style="width: 50%">${puntaje.pntodscr}</td>
                <td style="width: 35%">${puntaje.pntovlor}</td>
                <td style="width: 15%; text-align: center">${puntaje.pntopnto}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

<table class="table table-condensed table-hover table-striped table-bordered">
    <thead>
    <tr>
        <th style="width: 50%"></th>
        <th style="width: 35%">Total</th>
        <th style="width: 15%">${total} puntos</th>
    </tr>
    </thead>
</table>

<table class="table table-condensed table-hover table-striped table-bordered">
    <thead>
    <tr>
        <th style="width: 50%">Porcentaje respecto del máximo: ${Math.round(total/87*100*100)/100} %</th>
        <th style="width: 35%">Puntaje máximo posible</th>
        <th style="width: 15%">87 puntos</th>
    </tr>
    </thead>
</table>

<script type="text/javascript">

//    $(function () {
//        $("tr").contextMenu({
//            items  : createContextMenu,
//            onShow : function ($element) {
//                $element.addClass("trHighlight");
//            },
//            onHide : function () {
//                $(".trHighlight").removeClass("trHighlight");
//            }
//        });
//    });

</script>