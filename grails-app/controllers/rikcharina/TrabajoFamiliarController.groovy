package rikcharina


class TrabajoFamiliarController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def trabajoInstance

        if(params.id){
            trabajoInstance = TrabajoFamiliar.get(params.id)
        }else{
            trabajoInstance = new TrabajoFamiliar()
        }

        return[trabajoInstance: trabajoInstance]
    }

    def saveTrabajo_ajax(){

        def trabajo

        if(params.id){
            trabajo = TrabajoFamiliar.get(params.id)
        }else{
            trabajo = new TrabajoFamiliar()
        }

        trabajo.properties = params

        if(!trabajo.save(flush:true)){
            println("error save area" + trabajo.errors)
            render("no_Error al guardar el trabajo")
        }else {
            render("ok_Trabajo guardada correctamente")
        }

    }

    def tablaTrabajoFamiliar_ajax() {
        def finca = Finca.get(params.finca)
        def trabajos = TrabajoFamiliar.findAllByFinca(finca)
        return[trabajos: trabajos]
    }

    def borrarTrabajo_ajax(){
        def trabajo = TrabajoFamiliar.get(params.id)

        try {
            trabajo.delete(flush:true)
            render "ok_Trabajo borrado correctamente"
        }catch(e){
            println("error al borrar el trabajo: " + e)
            render "no_Error al borrar el trabajo"
        }
    }



}
