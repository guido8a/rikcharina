package rikcharina


class TipoLoteController {

    def list (){

    }

    def tablaTipoLotes_ajax () {
        def tipoLotes = TipoLote.list().sort{it.descripcion}
        return [tipoLotes: tipoLotes]
    }

    def form_ajax () {
        def tipoLote

        if(params.id){
            tipoLote = TipoLote.get(params.id)
            if (!tipoLote) {
                flash.clase = "alert-error"
                flash.message = "No se encontró el tipo de lote"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            tipoLote = new TipoLote()
        }

        return[tipoLoteInstance: tipoLote]
    }

    def saveTipoLote_ajax () {

        def tipoLote

        if(params.id){
            tipoLote = TipoLote.get(params.id)
            if (!tipoLote) {
                flash.clase = "alert-error"
                flash.message = "No se encontró el tipo de lote"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            tipoLote = new TipoLote()
        }

        tipoLote.properties = params

        if(!tipoLote.save(flush:true)){
            render("no_Error al guardar el tipo de lote")
        }else{
            render("ok_Tipo de Lote guardado correctamente")
        }
    }

    def borrarTipoLote_ajax () {

        def tipoLote = TipoLote.get(params.id)
        if (!tipoLote) {
            flash.clase = "alert-error"
            flash.message = "No se encontró el tipo de lote"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                tipoLote.delete(flush:true)
                render "ok_Tipo de lote borrado correctamente"
            }catch(e){
                println("error al borrar el tipo de lote: " + e)
                render "no_Error al borrar el tipo de lote"
            }
        }
    }

}
