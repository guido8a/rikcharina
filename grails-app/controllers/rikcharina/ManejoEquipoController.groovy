package rikcharina



class ManejoEquipoController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def equipoInstance

        if(params.id){
            equipoInstance = ManejoEquipo.get(params.id)
        }else{
            equipoInstance = new ManejoEquipo()
        }

        return[equipoInstance: equipoInstance]
    }

    def saveManejoEquipo_ajax(){

        def equipo

        if(params.id){
            equipo = ManejoEquipo.get(params.id)
        }else{
            equipo = new ManejoEquipo()
        }

        equipo.properties = params

        if(!equipo.save(flush:true)){
            println("error save equipo" + equipo.errors)
            render("no_Error al guardar el equipo")
        }else {
            render("ok_Equipo guardado correctamente")
        }

    }

    def tablaManejoEquipos_ajax() {
        def finca = Finca.get(params.finca)
        def equipos = ManejoEquipo.findAllByFinca(finca)
        return[equipos: equipos]
    }

    def borrarManejoEquipo_ajax(){
        def equipo = ManejoEquipo.get(params.id)

        try {
            equipo.delete(flush:true)
            render "ok_Equipo borrado correctamente"
        }catch(e){
            println("error al borrar el equipo: " + e)
            render "no_Error al borrar el equipo"
        }
    }

}
