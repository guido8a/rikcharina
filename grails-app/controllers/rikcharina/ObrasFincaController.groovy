package rikcharina



class ObrasFincaController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def obraInstance

        if(params.id){
            obraInstance = ObrasFinca.get(params.id)
        }else{
            obraInstance = new ObrasFinca()
        }

        return[obraInstance: obraInstance]
    }

    def saveObrasFinca_ajax(){

        def obra

        if(params.id){
            obra = ObrasFinca.get(params.id)
        }else{
            obra = new ObrasFinca()
        }

        obra.properties = params

        if(!obra.save(flush:true)){
            println("error save obra" + obra.errors)
            render("no_Error al guardar la obra")
        }else {
            render("ok_Obra guardada correctamente")
        }

    }

    def tablaObrasFinca_ajax() {
        def finca = Finca.get(params.finca)
        def obras = ObrasFinca.findAllByFinca(finca)
        return[obras: obras]
    }

    def borrarObraFinca_ajax(){
        def obra = ObrasFinca.get(params.id)

        try {
            obra.delete(flush:true)
            render "ok_Obra borrada correctamente"
        }catch(e){
            println("error al borrar la obra: " + e)
            render "no_Error al borrar la obra"
        }
    }

}
