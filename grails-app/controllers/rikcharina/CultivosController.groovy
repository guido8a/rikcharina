package rikcharina



class CultivosController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def cultivoInstance

        if(params.id){
            cultivoInstance = Cultivos.get(params.id)
        }else{
            cultivoInstance = new Cultivos()
        }

        return[cultivoInstance: cultivoInstance]
    }

    def saveCultivo_ajax(){

        def cultivo

        if(params.id){
            cultivo = Cultivos.get(params.id)
        }else{
            cultivo = new Cultivos()
        }

        cultivo.properties = params

        if(!cultivo.save(flush:true)){
            println("error save cultivo" + cultivo.errors)
            render("no_Error al guardar el cultivo")
        }else {
            render("ok_Cultivo guardada correctamente")
        }

    }

    def tablaCultivos_ajax() {
        def finca = Finca.get(params.finca)
        def cultivos = Cultivos.findAllByFinca(finca)
        return[cultivos: cultivos]
    }

    def borrarCultivo_ajax(){
        def cultivo = Cultivos.get(params.id)

        try {
            cultivo.delete(flush:true)
            render "ok_cultivo borrado correctamente"
        }catch(e){
            println("error al borrar el cultivo: " + e)
            render "no_Error al borrar el cultivo"
        }
    }


}
