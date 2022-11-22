package rikcharina

class PlantaController {
    def list (){

    }

    def tablaPlantas_ajax () {
        def plantas = Planta.list().sort{it.descripcion}
        return [plantas: plantas]
    }

    def form_ajax () {
        def planta

        if(params.id){
            planta = Planta.get(params.id)
            if (!planta) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la planta"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            planta = new Planta()
        }

        return[plantaInstance: planta]
    }

    def savePlanta_ajax () {

        def planta

        if(params.id){
            planta = Planta.get(params.id)
            if (!planta) {
                flash.clase = "alert-error"
                flash.message = "No se encontró el la planta"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            planta = new Planta()
        }

        planta.properties = params

        if(!planta.save(flush:true)){
            render("no_Error al guardar la planta")
        }else{
            render("ok_Planta guardada correctamente")
        }
    }

    def borrarPlanta_ajax () {

        def planta = Planta.get(params.id)
        if (!planta) {
            flash.clase = "alert-error"
            flash.message = "No se encontró el tipo de planta"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                planta.delete(flush:true)
                render "ok_Planta borrada correctamente"
            }catch(e){
                println("error al borrar la planta: " + e)
                render "no_Error al borrar la planta"
            }
        }
    }

}
