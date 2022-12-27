<html>
<head>
    <meta name="layout" content="main">
    <title>Fincas</title>
</head>

<body>

<div class="btn-group">
    <a href="${createLink(controller: 'finca', action: 'finca')}"
       class="btn btn-sm btn-success" title="Crear una nueva finca">
        <i class="fas fa-plus"></i> Nueva Finca
    </a>
</div>

<a href="#" id="btnBuscarFinca"
   class="btn btn-sm btn-info buscarFinca" title="Buscar finca">
    <i class="fas fa-list-alt"></i> Lista de fincas
</a>

<div class="btn-group">
    <a href="#" id="btnGuardar" class="btn btn-sm btn-success" title="Guardar datos">
        <i class="fa fa-save"></i> Guardar
    </a>
    <g:if test="${finca?.id}">
        <a href="#" id="btnEliminarFinca" class="btn btn-sm btn-danger" title="Borrar finca">
            <i class="fa fa-trash"></i> Eliminar
        </a>
    </g:if>
</div>

<h3 style="text-align: center">Finca</h3>

<g:if test="${finca?.id}">
    <div class="panel panel-primary col-md-12" style="height: 85px;">
        <div class="" style="padding: 3px; margin-top: 2px; text-align: left;">
            <a href="#" id="btnAreas" class="btn btn-sm btn-info" title="Áreas de producción">
                <i class="fa fa-table"></i> Áreas de producción
            </a>
            <a href="#" id="btnTrabajo" class="btn btn-sm btn-info" title="Trabajo familiar">
                <i class="fas fa-users-cog"></i> Trabajo familiar
            </a>
            <a href="#" id="btnCultivo" class="btn btn-sm btn-info" title="Manejo de cultivos">
                <i class="fa fa-scroll"></i> Manejo de cultivos
            </a>
            <a href="#" id="btnEnfermedad" class="btn btn-sm btn-info" title="Manejo de enfermedades">
                <i class="fa fa-certificate"></i> Manejo de enfermedades
            </a>
            <a href="#" id="btnPlaga" class="btn btn-sm btn-info" title="Control de plagas">
                <i class="fas fa-asterisk"></i> Control de plagas
            </a>
            <a href="#" id="btnForestal" class="btn btn-sm btn-info" title="Manejo forestal">
                <i class="fas fa-tree"></i> Manejo forestal
            </a>
            <a href="#" id="btnAnimal" class="btn btn-sm btn-info" title="Manejo de animales">
                <i class="fas fa-paw"></i> Manejo de animales
            </a>
            <a href="#" id="btnCargo" class="btn btn-sm btn-info" title="Cargos desempeñados">
                <i class="fas fa-users"></i> Cargos desempeñados
            </a>

        </div>
        <div class="" style="padding: 3px; text-align: left;">
            <a href="#" id="btnObra" class="btn btn-sm btn-info" title=" Obras de conservación de suelos">
                <i class="fas fa-clipboard"></i> Obras de conservación de suelos
            </a>
            <a href="#" id="btnEquipo" class="btn btn-sm btn-info" title="Manejo de equipos e instalaciones">
                <i class="fas fa-wrench"></i> Manejo de equipos e instalaciones
            </a>

            <a href="#" id="btnCapacitacion" class="btn btn-sm btn-info" title="Capacitación">
                <i class="fas fa-calendar"></i> Capacitación
            </a>

            <a href="#" id="btnPuntaje" class="btn btn-sm btn-warning" title="Puntaje">
                <i class="fas fa-check"></i> Puntaje
            </a>
        </div>
    </div>
</g:if>

<div class="panel panel-primary col-md-12" style="height: 700px; overflow-y: auto; scrollbar-3dlight-color: green; margin-top: -10px">

    <g:form class="form-horizontal" name="frmFinca" controller="finca" action="saveFinca_ajax">
        <g:hiddenField name="id" value="${finca?.id}"/>

        <div class="alert-success" style="text-align: center; font-size: 14px; font-weight: bold; margin-top: 3px">
            Datos de la finca
        </div>

        <div class="form-group" style="margin-top: 10px">
            <span class="grupo">
                <label class="col-md-1 control-label text-info">
                    Cantón
                </label>
                <span class="col-md-2">
                    <input aria-label="" name="canton" id="cantonTexto" type='text' class="form-control" readonly="" value="${finca?.parroquia?.canton?.nombre}"/>
                </span>
            </span>
            <span class="grupo">
                <label class="col-md-1 control-label text-info">
                    Parroquia
                </label>
                <span class="col-md-3">
                    <g:hiddenField name="parroquia" id="parroquia" value="${finca?.parroquia?.id}"/>
                    <input aria-label="" name="parroquiaName" id="parroquiaTexto" type='text' class="form-control" readonly="" value="${finca?.parroquia?.nombre}"/>
                </span>
            </span>

            <span class="col-md-1">
                <a href="#" class="btn btn-sm btn-info buscarParroquia" title="Buscar ubicación geográfica">
                    <i class="fa fa-search"></i> Buscar
                </a>
            </span>

            <span class="grupo">
                <label class="col-md-1 control-label text-info">
                    Comunidad
                </label>
                <span class="col-md-3">
                    <g:textField name="comunidad" maxlength="50" class="form-control required valid input-sm" value="${finca?.comunidad}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>
        <div class="form-group ${hasErrors(bean: finca, field: 'nombre', 'error')} ${hasErrors(bean: finca, field: 'organizacion', 'error')}">
            <span class="grupo">
                <label for="nombre" class="col-md-1 control-label text-info">
                    Nombre
                </label>
                <span class="col-md-5">
                    <g:textField name="nombre" maxlength="50" class="form-control required valid input-sm" value="${finca?.nombre}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="organizacion" class="col-md-1 control-label text-info">
                    Organización
                </label>
                <span class="col-md-5">
                    <g:textField name="organizacion" maxlength="50" class="form-control required valid input-sm" value="${finca?.organizacion}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'fecha', 'error')} ${hasErrors(bean: finca, field: 'institucion', 'error')}">
            <span class="grupo">
                <label for="institucion" class="col-md-2 control-label text-info">
                    Institución de apoyo
                </label>
                <span class="col-md-4">
                    <g:select name="institucion" from="${rikcharina.Institucion.list().sort{it.nombre}}" class="form-control" optionKey="id" optionValue="nombre" value="${finca?.institucion?.id}"/>
                </span>
            </span>
            <span class="grupo ">
                <label class="col-md-1 control-label text-info">
                    Fecha
                </label>

                <span class="col-md-2">
                    <input aria-label="" name="fecha" id='datetimepicker1' type='text' class="form-control required"
                           value="${finca?.fecha?.format("dd-MM-yyyy")}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'propietario', 'error')} ${hasErrors(bean: finca, field: 'direccion', 'error')}">
            <span class="grupo">
                <label for="propietario" class="col-md-1 control-label text-info">
                    Propietario
                </label>
                <span class="col-md-3">
                    <g:textField name="propietario" maxlength="50" class="form-control required valid input-sm" value="${finca?.propietario}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="delegado" class="col-md-1 control-label text-info">
                    Delegado
                </label>
                <span class="col-md-3">
                    <g:textField name="delegado" maxlength="50" class="form-control required valid input-sm" value="${finca?.delegado}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="promotor" class="col-md-1 control-label text-info">
                    Promotor
                </label>
                <span class="col-md-3">
                    <g:textField name="promotor" maxlength="50" class="form-control required valid input-sm" value="${finca?.promotor}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'direccion', 'error')}">
            <span class="grupo">
                <label for="direccion" class="col-md-1 control-label text-info">
                    Dirección
                </label>
                <span class="col-md-11">
                    <g:textField name="direccion" maxlength="50" class="form-control required valid input-sm" value="${finca?.direccion}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'longitud', 'error')} ${hasErrors(bean: finca, field: 'latitud', 'error')}">
            <span class="grupo">
                <label for="altura" class="col-md-1 control-label text-info">
                    Altitud
                </label>
                <span class="col-md-2">
                    <g:textField name="altura" class="form-control required number valid input-sm" value="${finca?.altura}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="longitud" class="col-md-1 control-label text-info">
                    Longitud
                </label>
                <span class="col-md-2">
                    <g:textField name="longitud" class="form-control required number valid input-sm" value="${finca?.longitud}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="latitud" class="col-md-1 control-label text-info">
                    Latitud
                </label>
                <span class="col-md-2">
                    <g:textField name="latitud" class="form-control required number valid input-sm" value="${finca?.latitud}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="zona" class="col-md-1 control-label text-info">
                    Zona
                </label>
                <span class="col-md-2">
                    <g:select name="zona" from="${['Alta': 'Alta', 'Media': 'Media', 'Baja' : 'Baja']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.zona}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'actvAgricola', 'error')} ${hasErrors(bean: finca, field: 'actvPecuaria', 'error')}">
            <span class="grupo">
                <label for="plan" class="col-md-1 control-label text-info">
                    Plan de manejo
                </label>
                <span class="col-md-2">
                    <g:select name="plan" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.plan}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="actvAgricola" class="col-md-2 control-label text-info">
                    Actividad agrícola (%)
                </label>
                <span class="col-md-2">
                    <g:textField name="actvAgricola" class="form-control required number valid input-sm" value="${finca?.actvAgricola}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="actvPecuaria" class="col-md-2 control-label text-info">
                    Actividad pecuaria (%)
                </label>
                <span class="col-md-2">
                    <g:textField name="actvPecuaria" class="form-control required number valid input-sm" value="${finca?.actvPecuaria}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'jornalerosPermanentes', 'error')} ${hasErrors(bean: finca, field: 'jornalerosTemporales', 'error')}">
            <span class="grupo">
                <label for="jornalerosPermanentes" class="col-md-2 control-label text-info">
                    Jornaleros permanentes
                </label>
                <span class="col-md-2">
                    <g:textField name="jornalerosPermanentes" class="form-control required digits valid input-sm" value="${finca?.jornalerosPermanentes}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="jornalerosTemporales" class="col-md-2 control-label text-info">
                    Jornaleros temporales
                </label>
                <span class="col-md-2">
                    <g:textField name="jornalerosTemporales" class="form-control required digits valid input-sm" value="${finca?.jornalerosTemporales}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="entrevista" class="col-md-1 control-label text-info">
                    Entrevistador
                </label>
                <span class="col-md-3">
                    <g:textField name="entrevista" class="form-control required valid input-sm" value="${finca?.entrevista}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="alert-success" style="text-align: center; font-size: 14px; font-weight: bold; margin-bottom: 5px">
            Manejo de suelos
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'preparacionSuelo', 'error')} ${hasErrors(bean: finca, field: 'fertilizantes', 'error')}" >
            <span class="grupo">
                <label for="preparacionSuelo" class="col-md-2 control-label text-info">
                    Preparación del suelo
                </label>
                <span class="col-md-3">
                    <g:select name="preparacionSuelo" from="${['Manual (azadón y yunta)': 'Manual (azadón y yunta)', 'Motocultor': 'Motocultor', 'Tractor' : 'Tractor']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.preparacionSuelo}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="fertilizantes" class="col-md-2 control-label text-info">
                    Fertilización del suelo
                </label>
                <span class="col-md-3">
                    <g:select name="fertilizantes" from="${['Materia orgánica': 'Materia orgánica', 'Fertilizantes quimícos': 'Fertilizantes quimícos', 'Ninguna' : 'Ninguna']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.fertilizantes}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'fertilizacionComplementaria', 'error')} ${hasErrors(bean: finca, field: 'manejoRastrojos', 'error')}" >
            <span class="grupo">
                <label for="fertilizacionComplementaria" class="col-md-2 control-label text-info">
                    Fertilización complementaria
                </label>
                <span class="col-md-3">
                    <g:select name="fertilizacionComplementaria" from="${['Lactofermentos': 'Lactofermentos', 'Microorganismos de montaña': 'Microorganismos de montaña', 'Ninguna' : 'Ninguna']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.fertilizacionComplementaria}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="manejoRastrojos" class="col-md-2 control-label text-info">
                    Manejo de rastrojos
                </label>
                <span class="col-md-3">
                    <g:select name="manejoRastrojos" from="${['Para compostaje': 'Para compostaje', 'Incorporación al terreno': 'Incorporación al terreno', 'Se quema o se bota' : 'Se quema o se bota']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.manejoRastrojos}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="alert-success" style="text-align: center; font-size: 14px; font-weight: bold; margin-bottom: 5px">
            Manejo de cultivos
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'asociacionCultivos', 'error')} ${hasErrors(bean: finca, field: 'rotacionCultivos', 'error')}" >
            <span class="grupo">
                <label for="asociacionCultivos" class="col-md-2 control-label text-info">
                    Hace asociación de cultivos
                </label>
                <span class="col-md-1">
                    <g:select name="asociacionCultivos" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.asociacionCultivos}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="rotacionCultivos" class="col-md-2 control-label text-info">
                    Hace rotación de cultivos
                </label>
                <span class="col-md-1">
                    <g:select name="rotacionCultivos" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.rotacionCultivos}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="seleccionSemillas" class="col-md-2 control-label text-info">
                    Hace selección de semillas
                </label>
                <span class="col-md-1">
                    <g:select name="seleccionSemillas" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.seleccionSemillas}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="semillaPropia" class="col-md-2 control-label text-info">
                    Usa semillas propias
                </label>
                <span class="col-md-1">
                    <g:select name="semillaPropia" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.semillaPropia}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'semillaComprada', 'error')} ${hasErrors(bean: finca, field: 'rotacionCultivos', 'error')}" >
            <span class="grupo">
                <label for="semillaComprada" class="col-md-2 control-label text-info">
                    Usa semillas compradas
                </label>
                <span class="col-md-1">
                    <g:select name="semillaComprada" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.semillaComprada}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="semillaIntercambio" class="col-md-2 control-label text-info">
                    Usa semillas de intercambio
                </label>
                <span class="col-md-1">
                    <g:select name="semillaIntercambio" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.semillaIntercambio}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="calendarizacion" class="col-md-2 control-label text-info">
                    Realiza calendarización de cultivos
                </label>
                <span class="col-md-1">
                    <g:select name="calendarizacion" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.calendarizacion}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="invernadero" class="col-md-2 control-label text-info">
                    Área de invernadero (m2)
                </label>
                <span class="col-md-1">
                    <g:textField name="invernadero" class="form-control required number valid input-sm" value="${finca?.invernadero}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="alert-success" style="text-align: center; font-size: 14px; font-weight: bold; margin-bottom: 5px">
            Manejo del agua
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'aguaRiego', 'error')} ${hasErrors(bean: finca, field: 'juntaAgua', 'error')}" >
            <span class="grupo">
                <label for="aguaRiego" class="col-md-2 control-label text-info">
                    Tiene agua de riego
                </label>
                <span class="col-md-1">
                    <g:select name="aguaRiego" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.aguaRiego}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="juntaAgua" class="col-md-2 control-label text-info">
                    Pertenece a una junta de riego
                </label>
                <span class="col-md-1">
                    <g:select name="juntaAgua" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.juntaAgua}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="aguaFuente" class="col-md-1 control-label text-info">
                    Fuente de agua
                </label>
                <span class="col-md-2">
                    <g:select name="aguaFuente" from="${['Vertiente': 'Vertiente', 'Quebrada': 'Quebrada', 'Río' : 'Río', 'Uso doméstico' : 'Uso doméstico', 'Cosecha de agua' : 'Cosecha de agua' , 'Pozo' : 'Pozo'] }" class="form-control" optionKey="key"  optionValue="value" value="${finca?.aguaFuente}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="aguaInfraestructura" class="col-md-1 control-label text-info">
                    Infraestructura de riego
                </label>
                <span class="col-md-2">
                    <g:select name="aguaInfraestructura" from="${['Aspersión': 'Aspersión', 'Goteo': 'Goteo', 'Surcos' : 'Surcos']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.aguaInfraestructura}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="alert-success" style="text-align: center; font-size: 14px; font-weight: bold; margin-bottom: 5px">
            Manejo forestal
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'forestal', 'error')} ${hasErrors(bean: finca, field: 'monte', 'error')}" >
            <span class="grupo">
                <label for="forestal" class="col-md-2 control-label text-info">
                    Tiene especies forestales
                </label>
                <span class="col-md-1">
                    <g:select name="forestal" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.forestal}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="monte" class="col-md-2 control-label text-info">
                    Tiene páramo o monte
                </label>
                <span class="col-md-1">
                    <g:select name="monte" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.monte}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="alert-success" style="text-align: center; font-size: 14px; font-weight: bold; margin-bottom: 5px">
            Manejo de animales
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'pasto', 'error')} ${hasErrors(bean: finca, field: 'pastoAbono', 'error')}" >
            <span class="grupo">
                <label for="pasto" class="col-md-2 control-label text-info">
                    Tiene la finca pasto
                </label>
                <span class="col-md-1">
                    <g:select name="pasto" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.pasto}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="pastoAbono" class="col-md-2 control-label text-info">
                    Abona los pastos y poteros con
                </label>
                <span class="col-md-2">
                    <g:select name="pastoAbono" from="${['Abono orgánico': 'Abono orgánico', 'Abono químico': 'Abono químico']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.pastoAbono}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="manejoPasto" class="col-md-2 control-label text-info">
                    Manejo de pastos
                </label>
                <span class="col-md-2">
                    <g:select name="manejoPasto" from="${['Resiembra de pastos naturales': 'Resiembra de pastos naturales', 'Dispersión de heces': 'Dispersión de heces', 'Enmiendas' : 'Enmiendas', 'Ninguna' : 'Ninguna']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.manejoPasto}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'instalaciones', 'error')} ${hasErrors(bean: finca, field: 'sanitario', 'error')}" >
            <span class="grupo">
                <label for="instalaciones" class="col-md-2 control-label text-info">
                    La finca dispone de adecuaciones
                </label>
                <span class="col-md-1">
                    <g:select name="instalaciones" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.instalaciones}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="sanitario" class="col-md-3 control-label text-info">
                    Realiza desparasitación de sus animales con produtos naturales (manejo sanitario)
                </label>
                <span class="col-md-1">
                    <g:select name="sanitario" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.sanitario}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="ancestrales" class="col-md-3 control-label text-info">
                    Usa prácticas ancestrales para curar, prevenir enfermedades de animales (manejo sanitario)
                </label>
                <span class="col-md-1">
                    <g:select name="ancestrales" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.ancestrales}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="alert-success" style="text-align: center; font-size: 14px; font-weight: bold; margin-bottom: 5px">
            Manejo de ambiente y producción
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'basura', 'error')} ${hasErrors(bean: finca, field: 'autoconsumo', 'error')}" >
            <span class="grupo">
                <label for="basura" class="col-md-2 control-label text-info">
                    Que hace con los plásticos, vidrios, cauchos y latas
                </label>
                <span class="col-md-2">
                    <g:select name="basura" from="${['Recicla': 'Recicla', 'Quema': 'Quema', 'Envia en la basura' : 'Envía en la basura' ]}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.basura}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="autoconsumo" class="col-md-3 control-label text-info">
                    Destino de la producción (Autoconsumo %)
                </label>
                <span class="col-md-1">
                    <g:textField name="autoconsumo" class="form-control required digits valid input-sm" value="${finca?.autoconsumo}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="venta" class="col-md-3 control-label text-info">
                    Destino de la producción (Venta %)
                </label>
                <span class="col-md-1">
                    <g:textField name="venta" class="form-control required digits valid input-sm" value="${finca?.venta}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'lugarVenta', 'error')} ${hasErrors(bean: finca, field: 'fecuencia', 'error')}" >
            <span class="grupo">
                <label for="lugarVenta" class="col-md-2 control-label text-info">
                    Donde vende
                </label>
                <span class="col-md-2">
                    <g:select name="lugarVenta" from="${['Comunidad': 'Comunidad', 'Mercado parroquial': 'Mercado parroquial', 'Mercado cantonal': 'Mercado cantonal', 'Otros lugares' : 'Otros lugares' ]}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.lugarVenta}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="fecuencia" class="col-md-2 control-label text-info">
                    Cada que tiempo vende
                </label>
                <span class="col-md-2">
                    <g:select name="fecuencia" from="${['Semanal': 'Semanal', 'Quincenal': 'Quincenal', 'Mensual': 'Mensual', 'Temporal' : 'Temporal', 'Diario' :  'Diario' ]}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.fecuencia}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
        </div>

        <div class="alert-success" style="text-align: center; font-size: 14px; font-weight: bold; margin-bottom: 5px">
            Participación / Criterio del promotor
        </div>

        <div class="form-group ${hasErrors(bean: finca, field: 'estaoOrganizacion', 'error')} ${hasErrors(bean: finca, field: 'calificacion', 'error')}" >
            <span class="grupo">
                <label for="estaoOrganizacion" class="col-md-2 control-label text-info">
                    Es miembro activo de una organización
                </label>
                <span class="col-md-1">
                    <g:select name="estaoOrganizacion" from="${['S': 'Si', 'N': 'No']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.estaoOrganizacion}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>
            <span class="grupo">
                <label for="calificacion" class="col-md-2 control-label text-info">
                    La finca se considera
                </label>
                <span class="col-md-2">
                    <g:select name="calificacion" from="${['A' : 'Agroecológica', 'P': 'En Proceso', 'I': 'Inicio' , 'T' : 'En transición']}" class="form-control" optionKey="key"  optionValue="value" value="${finca?.calificacion}"/>
                    <p class="help-block ui-helper-hidden"></p>
                </span>
            </span>

        </div>

    </g:form>

</div>

<script type="text/javascript">


    $("#btnPuntaje").click(function () {
        location.href="${createLink(controller: 'finca', action: 'puntaje')}?id=${finca?.id}"
    });

    var bp;


    $("#btnAreas").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'areaProduccion', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormArea",
                    title: "Área de producción",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnAreas").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });

    $("#btnTrabajo").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'trabajoFamiliar', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormTrabajo",
                    title: "Trabajo familiar",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnTrabajo").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });

    $("#btnCultivo").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'cultivos', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormCultivo",
                    title: "Cultivos",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnCultivo").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });

    $("#btnEnfermedad").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'manejoEnfermedades', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormEnfermedades",
                    title: "Manejo enfermedades",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnEnfermedad").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });

    $("#btnPlaga").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'manejoPlagas', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormPlagas",
                    title: "Manejo de Plagas",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnPlaga").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });

    $("#btnForestal").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'forestal', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormForestal",
                    title: "Manejo de Siembras",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnForestal").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });

    $("#btnAnimal").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'manejoAnimal', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormAnimal",
                    title: "Manejo de Animales",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnAnimal").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });

    $("#btnCargo").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'fincaCargo', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormCargo",
                    title: "Cargos desempeñados",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnCargo").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });


    $("#btnObra").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'obrasFinca', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormObra",
                    title: "Obras de la Finca",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnObra").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });

    $("#btnEquipo").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'manejoEquipo', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormEquipo",
                    title: "Infraestructura",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnEquipo").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });

    $("#btnCapacitacion").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'fincaCapacitacion', action: 'list')}',
            data: { finca: '${finca.id}'},
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgFormCapacitacion",
                    title: "Cursos de capacitación",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $("#btnCapacitacion").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });








    /////////////////

    $('#datetimepicker1').datetimepicker({
        locale: 'es',
        format: 'DD-MM-YYYY',
        daysOfWeekDisabled: [0, 6],
        sideBySide: true,
        icons: {
        }
    });

    $("#btnEliminarFinca").click(function () {
        bootbox.confirm("<i class='fa fa-exclamation-triangle fa-3x pull-left text-danger text-shadow'></i> ¿Está seguro de querer eliminar esta finca?", function (res) {
            if(res){
                $.ajax({
                    type: 'POST',
                    url: '${createLink(controller: 'finca', action: 'borrarFinca_ajax')}',
                    data:{
                        id: '${finca?.id}'
                    },
                    success: function (msg) {
                        var parts = msg.split("_");
                        if(parts[0] === 'ok'){
                            log(parts[1],"success");
                            setTimeout(function () {
                                location.href="${createLink(controller: 'finca', action: 'finca')}"
                            }, 1000);
                        }else{
                            bootbox.alert("<i class='fa fa-exclamation-triangle fa-3x pull-left text-warning text-shadow'></i>" + parts[1])
                        }
                    }
                });
            }
        });
    });

    $("#btnGuardar").click(function () {
        submitFormFinca();
    });

    function submitFormFinca() {
        var $form = $("#frmFinca");
        var $btn = $("#dlgCreateEdit").find("#btnSave");
        if ($form.valid()) {
            var data = $form.serialize();
            $btn.replaceWith(spinner);
            var dialog = cargarLoader("Guardando...");
            $.ajax({
                type    : "POST",
                url     : $form.attr("action"),
                data    : data,
                success : function (msg) {
                    dialog.modal('hide');
                    var parts = msg.split("_");
                    if(parts[0] === 'ok'){
                        log(parts[1], "success");
                        setTimeout(function () {
                            location.href="${createLink(controller: 'finca', action: 'finca')}/" + parts[2]
                        }, 1000);
                    }else{
                        bootbox.alert('<i class="fa fa-exclamation-triangle text-danger fa-3x"></i> ' + '<strong style="font-size: 14px">' + parts[1] + '</strong>');
                        return false;
                    }
                }
            });
        } else {
            return false;
        } //else
        return false;
    }

    $(".buscarFinca").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'finca', action: 'buscarFinca_ajax')}',
            data: {  },
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgBuscarFinca",
                    title: "Buscar Finca",
                    class: "modal-lg",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $(".buscarFinca").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });



    $(".buscarParroquia").click(function () {
        var dialog = cargarLoader("Cargando...");
        $(this).attr('disabled', 'disabled');
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'parroquia', action: 'buscarParroquia_ajax')}',
            data: {
                tipo: 3
            },
            success: function (msg) {
                dialog.modal('hide');
                bp = bootbox.dialog({
                    id: "dlgBuscarComunidad",
                    title: "Buscar Parroquia",
                    class: "modal-lg",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-primary",
                            callback: function () {
                                $(".buscarParroquia").removeAttr('disabled');
                            }
                        }
                    }
                }); //dialog
            }
        });
    });

    function cerrarDialogoParroquia() {
        bp.dialog().dialog('open');
        bp.modal("hide");
    }

    var validator = $("#frmFinca").validate({
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

</script>
</body>
</html>