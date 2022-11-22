package rikcharina


class EnfermedadController {

    def list (){

    }

    def tablaEnfermedades_ajax () {
        def enfermedades = Enfermedad.list().sort{it.descripcion}
        return [enfermedades: enfermedades]
    }

    def form_ajax () {
        def enfermedad

        if(params.id){
            enfermedad = Enfermedad.get(params.id)
            if (!enfermedad) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la enfermedad"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            enfermedad = new Enfermedad()
        }

        return[enfermedadInstance: enfermedad]
    }

    def saveEnfermedad_ajax () {

        def enfermedad

        if(params.id){
            enfermedad = Enfermedad.get(params.id)
            if (!enfermedad) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la enfermedad"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            enfermedad = new Enfermedad()
        }

        enfermedad.properties = params

        if(!enfermedad.save(flush:true)){
            render("no_Error al guardar la enfermedad")
        }else{
            render("ok_Enfermedad guardada correctamente")
        }
    }

    def borrarEnfermedad_ajax () {

        def enfermedad = Enfermedad.get(params.id)
        if (!enfermedad) {
            flash.clase = "alert-error"
            flash.message = "No se encontró la enfermedad"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                enfermedad.delete(flush:true)
                render "ok_Enfermedad borrada correctamente"
            }catch(e){
                println("error al borrar la enfermedad: " + e)
                render "no_Error al borrar la enfermedad"
            }
        }
    }

}
