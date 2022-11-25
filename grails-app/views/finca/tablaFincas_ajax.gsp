
<div class="" style="width: 99.7%;height: 320px; overflow-y: auto;float: right; margin-top: -20px">
    <table class="table-bordered table-condensed table-hover" style="width: 100%">
        <g:each in="${fincas}" var="finca">
            <tr style="width: 100%">
                <td style="width: 10%; text-align: center">
                    <a href="#" class="btn btn-xs btn-success btnSeleFinca"
                       title="Seleccionar finca" data-id="${finca.fnca__id}"
                       data-nombre="${finca.fncanmbr}" >
                        <i class="fa fa-check"></i>
                    </a>
                </td>
                <td style="width: 30%">
                    ${finca.fncanmbr}
                </td>
                <td style="width: 30%">
                    ${finca.fncaorga}
                </td>
                <td style="width: 30%">
                    ${finca.fncacmnd}
                </td>
            </tr>
        </g:each>
    </table>
</div>

<script type="text/javascript">

    $(".btnSeleFinca").click(function () {
        var id = $(this).data("id");

        location.href="${createLink(controller: 'finca', action: 'finca')}/" + id
    });

</script>