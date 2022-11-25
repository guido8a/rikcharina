package rikcharina


class FincaController {

    def dbConnectionService

    def list() {

    }

    def finca() {

        def finca

        if(params.id){
            finca = Finca.get(params.id)
            if (!finca) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la Finca"
                redirect(action: "finca")
            } //no existe el objeto
        }else{
            finca = new Finca()
        }

        return [finca: finca]

    }

    def saveFinca_ajax () {

        def formateada = new Date().parse("dd-MM-yyyy", params.fecha)

        def finca

        if(params.id){
            finca = Finca.get(params.id)
            if (!finca) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la Finca"
                redirect(action: "finca")
            } //no existe el objeto
        }else{
            finca = new Finca()
        }

        params.fecha = formateada
        params.dispositivo = 'PC'

        finca.properties = params

        if(!finca.save(flush: true)){
            println("error" +  finca.errors)
            render("no_Error al guardar la finca")
        }else{
            render("ok_Finca guardada correctamente_${finca?.id}")
        }
    }

    def borrarFinca_ajax () {
        def finca = Finca.get(params.id)
        if (!finca) {
            flash.clase = "alert-error"
            flash.message = "No se encontró la finca"
            redirect(action: "finca")
            //no existe el objeto
        }else{
            try {
                finca.delete(flush:true)
                render "ok_Finca borrada correctamente"
            }catch(e){
                println("error al borrar la finca: " + e)
                render "no_Error al borrar la finca"
            }
        }
    }

    def buscarFinca_ajax(){

    }

    def tablaFincas_ajax () {

        def sql = ''
        def operador = ''

        switch (params.operador) {
            case "0" :
                operador = 'fncanmbr'
                break;
            case "1" :
                operador = 'fncacmnd'
                break;
            case "2" :
                operador = 'fncaorga'
                break;
        }

        def cn = dbConnectionService.getConnection()
        sql = "select * from fnca where ${operador} ilike '%${params.texto}%' order by fncacmnd asc"
        def res = cn.rows(sql.toString())

        return [fincas: res]
    }

}
