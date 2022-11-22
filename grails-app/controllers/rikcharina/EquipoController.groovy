package rikcharina


class EquipoController {

    def list (){

    }

    def tablaEquipos_ajax () {
        def equipos = Equipo.list().sort{it.descripcion}
        return [equipos: equipos]
    }

    def form_ajax () {
        def equipo

        if(params.id){
            equipo = Equipo.get(params.id)
            if (!equipo) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la instalación"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            equipo = new Equipo()
        }

        return[equipoInstance: equipo]
    }

    def saveEquipo_ajax () {

        def equipo

        if(params.id){
            equipo = Equipo.get(params.id)
            if (!equipo) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la instalación"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            equipo = new Equipo()
        }

        equipo.properties = params

        if(!equipo.save(flush:true)){
            render("no_Error al guardar la instalación")
        }else{
            render("ok_Instalación guardada correctamente")
        }
    }

    def borrarEquipo_ajax () {

        def equipo = Equipo.get(params.id)
        if (!equipo) {
            flash.clase = "alert-error"
            flash.message = "No se encontró la instalación"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                equipo.delete(flush:true)
                render "ok_Instalación borrada correctamente"
            }catch(e){
                println("error al borrar el equipo: " + e)
                render "no_Error al borrar la instalación"
            }
        }
    }

}
