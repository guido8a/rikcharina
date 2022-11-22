package rikcharina


class TipoObraController {


    def list (){

    }

    def tablaTipoObra_ajax () {
        def tipoObra = TipoObra.list().sort{it.descripcion}
        return [tipoObra: tipoObra]
    }

    def form_ajax () {
        def tipoObra

        if(params.id){
            tipoObra = TipoObra.get(params.id)
            if (!tipoObra) {
                flash.clase = "alert-error"
                flash.message = "No se encontró el tipo de obra"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            tipoObra = new TipoObra()
        }

        return[tipoObraInstance: tipoObra]
    }

    def saveTipoObra_ajax () {

        def tipoObra

        if(params.id){
            tipoObra = TipoObra.get(params.id)
            if (!tipoObra) {
                flash.clase = "alert-error"
                flash.message = "No se encontró el tipo de obra"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            tipoObra = new TipoObra()
        }

        tipoObra.properties = params

        if(!tipoObra.save(flush:true)){
            render("no_Error al guardar el tipo de obra")
        }else{
            render("ok_Tipo de Obra guardado correctamente")
        }
    }

    def borrarTipoObra_ajax () {

        def tipoObra = TipoObra.get(params.id)
        if (!tipoObra) {
            flash.clase = "alert-error"
            flash.message = "No se encontró el tipo de obra"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                tipoObra.delete(flush:true)
                render "ok_Tipo de obra borrado correctamente"
            }catch(e){
                println("error al borrar el tipo de obra: " + e)
                render "no_Error al borrar el tipo de obra"
            }
        }
    }
}
