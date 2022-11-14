<%@ page import="monitor.Documento" %>

<g:if test="${!documentoInstance}">
    <elm:notFound elem="Documento" genero="o"/>
</g:if>
<g:else>

    <div class="modal-contenido">
        <g:uploadForm class="form-horizontal" name="frmDocumento" controller="documento" action="save_ajax" method="POST">
            <g:hiddenField name="id" value="${documentoInstance?.id}"/>
            <g:hiddenField name="canton" value="${documentoInstance?.canton?.id ?: canton?.id}"/>

            <div class="form-group keeptogether ${hasErrors(bean: documentoInstance, field: 'fuente', 'error')} ">
                <span class="grupo">
                    <label for="fuente" class="col-md-3 control-label">
                        Fuente
                    </label>

                    <div class="col-md-6">
                        <g:select name="fuente" from="${monitor.Fuente.list().sort{it.descripcion}}"
                                  optionKey="id" optionValue="descripcion" value="${documentoInstance?.fuente?.id}"
                                  class="many-to-one form-control input-sm" />
                    </div>
                </span>
            </div>

            <div class="form-group keeptogether ${hasErrors(bean: documentoInstance, field: 'descripcion', 'error')} ">
                <span class="grupo">
                    <label for="descripcion" class="col-md-3 control-label">
                        Descripción
                    </label>

                    <div class="col-md-8">
                        <g:textField name="descripcion" maxlength="63" class="form-control input-sm required"
                                     value="${documentoInstance?.descripcion}"/>
                    </div>
                </span>
            </div>

            <div class="form-group keeptogether ${hasErrors(bean: documentoInstance, field: 'clave', 'error')} ">
                <span class="grupo">
                    <label for="clave" class="col-md-3 control-label">
                        Palabras Clave
                    </label>

                    <div class="col-md-8">
                        <g:textField name="clave" maxlength="63" class="form-control input-sm" value="${documentoInstance?.clave}"/>
                    </div>
                </span>
            </div>

            <div class="form-group keeptogether ${hasErrors(bean: documentoInstance, field: 'resumen', 'error')} ">
                <span class="grupo">
                    <label for="resumen" class="col-md-3 control-label">
                        Resumen
                    </label>

                    <div class="col-md-8">
                        <g:textArea name="resumen" cols="40" rows="5" maxlength="1024" class="form-control input-sm"
                                    value="${documentoInstance?.resumen}" style="resize: none"/>
                    </div>
                </span>
            </div>

            <g:if test="${!documentoInstance.id}">
                <div class="form-group keeptogether ${hasErrors(bean: documentoInstance, field: 'ruta', 'error')} ">
                    <span class="grupo">
                        <label for="ruta" class="col-md-3 control-label">
                            Documento
                        </label>

                        <div class="col-md-8">
                            <input type="file" name="ruta" id="ruta" class="form-control input-sm required"/>
                        </div>

                    </span>
                </div>
            </g:if>
        </g:uploadForm>
    </div>

    <script type="text/javascript">
        var okContents = {
            'image/png'  : "png",
            'image/jpeg' : "jpeg",
            'image/jpg'  : "jpg",

            'application/pdf'      : 'pdf',
            'application/download' : 'pdf',
            'application/vnd.ms-pdf' : 'pdf',

            'application/excel'                                                 : 'xls',
            'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' : 'xlsx',

            'application/mspowerpoint'                                                  : 'pps',
            'application/vnd.ms-powerpoint'                                             : 'pps',
            'application/powerpoint'                                                    : 'ppt',
            'application/x-mspowerpoint'                                                : 'ppt',
            'application/vnd.openxmlformats-officedocument.presentationml.slideshow'    : 'ppsx',
            'application/vnd.openxmlformats-officedocument.presentationml.presentation' : 'pptx',

            'application/msword'                                                      : 'doc',
            'application/vnd.openxmlformats-officedocument.wordprocessingml.document' : 'docx',

            'application/vnd.oasis.opendocument.text'         : 'odt',
            'application/vnd.oasis.opendocument.presentation' : 'odp',
            'application/vnd.oasis.opendocument.spreadsheet'  : 'ods'
        };

        var okExt = "", okExt2 = "";
        $.each(okContents, function (mime, ext) {
            if (okExt != "") {
                okExt += "|";
                okExt2 += ", ";
            }
            okExt += ext;
            okExt2 += ext;
        });

        $(".form-control").keydown(function (ev) {
            if (ev.keyCode == 13) {
                submitFormDocumento();
                return false;
            }
            return true;
        });
    </script>

</g:else>