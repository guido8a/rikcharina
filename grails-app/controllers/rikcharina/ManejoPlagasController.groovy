package rikcharina


class ManejoPlagasController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def plagaInstance

        if(params.id){
            plagaInstance = ManejoPlagas.get(params.id)
        }else{
            plagaInstance = new ManejoPlagas()
        }

        return[plagaInstance: plagaInstance]
    }

    def saveManejoPlaga_ajax(){

        def plaga

        if(params.id){
            plaga = ManejoPlagas.get(params.id)
        }else{
            plaga = new ManejoPlagas()
        }

        plaga.properties = params

        if(!plaga.save(flush:true)){
            println("error save plaga" + plaga.errors)
            render("no_Error al guardar el manejo de plaga")
        }else {
            render("ok_Manejo de plaga guardada correctamente")
        }

    }

    def tablaManejoPlagas_ajax() {
        def finca = Finca.get(params.finca)
        def plagas = ManejoPlagas.findAllByFinca(finca)
        return[plagas: plagas]
    }

    def borrarManejoPlaga_ajax(){
        def plaga = ManejoPlagas.get(params.id)

        try {
            plaga.delete(flush:true)
            render "ok_Manejo de plaga borrado correctamente"
        }catch(e){
            println("error al borrar el plaga: " + e)
            render "no_Error al borrar el manejo de la plaga"
        }
    }


}
