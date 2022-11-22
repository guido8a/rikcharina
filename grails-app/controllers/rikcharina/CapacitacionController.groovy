package rikcharina


class CapacitacionController {

    def list (){

    }

    def tablaCapacitaciones_ajax () {
        def capacitacion = Capacitacion.list().sort{it.descripcion}
        return [capacitaciones: capacitacion]
    }

    def form_ajax () {
        def capacitacion

        if(params.id){
            capacitacion = Capacitacion.get(params.id)
            if (!capacitacion) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la capacitación"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            capacitacion = new Capacitacion()
        }

        return[capacitacionInstance: capacitacion]
    }

    def saveCapacitacion_ajax () {

        def capacitacion

        if(params.id){
            capacitacion = Capacitacion.get(params.id)
            if (!capacitacion) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la capacitación"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            capacitacion = new Capacitacion()
        }

        capacitacion.properties = params

        if(!capacitacion.save(flush:true)){
            render("no_Error al guardar la capacitación")
        }else{
            render("ok_Capacitación guardada correctamente")
        }
    }

    def borrarCapacitacion_ajax () {

        def capacitacion = Capacitacion.get(params.id)
        if (!capacitacion) {
            flash.clase = "alert-error"
            flash.message = "No se encontró la capacitación"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                capacitacion.delete(flush:true)
                render "ok_Capacitación borrada correctamente"
            }catch(e){
                println("error al borrar la capacitación: " + e)
                render "no_Error al borrar la capacitación"
            }
        }
    }

}
