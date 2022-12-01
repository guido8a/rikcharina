package rikcharina


class ForestalController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def forestalInstance

        if(params.id){
            forestalInstance = Forestal.get(params.id)
        }else{
            forestalInstance = new Forestal()
        }

        return[forestalInstance: forestalInstance]
    }

    def saveManejoForestal_ajax(){

        def forestal

        if(params.id){
            forestal = Forestal.get(params.id)
        }else{
            forestal = new Forestal()
        }

        forestal.properties = params

        if(!forestal.save(flush:true)){
            println("error save forestal" + forestal.errors)
            render("no_Error al guardar el manejo forestal")
        }else {
            render("ok_Manejo forestal guardado correctamente")
        }

    }

    def tablaForestal_ajax() {
        def finca = Finca.get(params.finca)
        def forestales = Forestal.findAllByFinca(finca)
        return[forestales: forestales]
    }

    def borrarManejoForestal_ajax(){
        def forestal = Forestal.get(params.id)

        try {
            forestal.delete(flush:true)
            render "ok_Manejo forestal borrado correctamente"
        }catch(e){
            println("error al borrar el plaga: " + e)
            render "no_Error al borrar el manejo forestal"
        }
    }
}
