<util:renderHTML html="${msg}"/>
<asset:stylesheet src="/apli/lzm.context-0.5.css"/>
<asset:javascript src="/apli/lzm.context-0.5.js"/>


<style type="text/css">
table {
    table-layout: fixed;
    overflow-x: scroll;
}
th, td {
    overflow: hidden;
    text-overflow: ellipsis;
    word-wrap: break-word;
}
</style>

<g:set var="clase" value="${'principal'}"/>

<div class=""  style="width: 99.7%;height: ${msg == '' ? 400 : 585}px; overflow-y: auto;float: right; margin-top: -20px">
    <table id="tablaB" class="table-bordered table-condensed table-hover" width="1060px">
        <g:if test="${bases}">
            <g:each in="${bases}" var="dato" status="z">

                <tr id="${dato.id}" data-id="${dato.id}" class="${clase}">
                    <td width="120px">
                        ${dato?.tema}
                    </td>

                    <td width="240px" style="color:#186063">
                        ${dato?.clave}
                    </td>

                    <td width="240px">
                        ${dato.problema}
                    </td>

                    <td width="460px" class="text-info">
                        ${dato.solucion}
                    </td>
                </tr>
            </g:each>
        </g:if>
        <g:else>
            <div class="alert alert-danger" style="text-align: center; font-weight: bold">
                <i class="fa fa-exclamation-circle fa-2x text-danger"></i> No existen resultados para su búsqueda
            </div>
        </g:else>
    </table>
</div>


<script type="text/javascript">
    $(function () {
        $("tr").contextMenu({
            items  : createContextMenu,
            onShow : function ($element) {
                $element.addClass("trHighlight");
            },
            onHide : function ($element) {
                $(".trHighlight").removeClass("trHighlight");
            }
        });
    });
</script>
