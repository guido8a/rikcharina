package rikcharina


class PlagaController {

    def list (){

    }

    def tablaPlagas_ajax () {
        def plagas = Plaga.list().sort{it.descripcion}
        return [plagas: plagas]
    }

    def form_ajax () {
        def plaga

        if(params.id){
            plaga = Plaga.get(params.id)
            if (!plaga) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la plaga"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            plaga = new Plaga()
        }

        return[plagaInstance: plaga]
    }

    def savePlaga_ajax () {

        def plaga

        if(params.id){
            plaga = Plaga.get(params.id)
            if (!plaga) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la plaga"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            plaga = new Plaga()
        }

        plaga.properties = params

        if(!plaga.save(flush:true)){
            render("no_Error al guardar la plaga")
        }else{
            render("ok_Plaga guardada correctamente")
        }
    }

    def borrarPlaga_ajax () {

        def plaga = Plaga.get(params.id)
        if (!plaga) {
            flash.clase = "alert-error"
            flash.message = "No se encontró la plaga"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                plaga.delete(flush:true)
                render "ok_Plaga borrada correctamente"
            }catch(e){
                println("error al borrar la plaga: " + e)
                render "no_Error al borrar la plaga"
            }
        }
    }

}
