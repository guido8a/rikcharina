package rikcharina


class FincaCargoController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def cargoInstance

        if(params.id){
            cargoInstance = FincaCargo.get(params.id)
        }else{
            cargoInstance = new FincaCargo()
        }

        return[cargoInstance: cargoInstance]
    }

    def saveFincaCargo_ajax(){

        def cargo

        if(params.id){
            cargo = FincaCargo.get(params.id)
        }else{
            cargo = new FincaCargo()
        }

        cargo.properties = params

        if(!cargo.save(flush:true)){
            println("error save cargo" + cargo.errors)
            render("no_Error al guardar el cargo")
        }else {
            render("ok_Cargo guardado correctamente")
        }

    }

    def tablaFincaCargo_ajax() {
        def finca = Finca.get(params.finca)
        def cargos = FincaCargo.findAllByFinca(finca)
        return[cargos: cargos]
    }

    def borrarFincaCargo_ajax(){
        def cargo = FincaCargo.get(params.id)

        try {
            cargo.delete(flush:true)
            render "ok_Cargo borrado correctamente"
        }catch(e){
            println("error al borrar el cargo: " + e)
            render "no_Error al borrar el cargo"
        }
    }

}
