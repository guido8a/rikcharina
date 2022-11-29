package rikcharina


class ManejoEnfermedadesController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def enfermedadInstance

        if(params.id){
            enfermedadInstance = ManejoEnfermedades.get(params.id)
        }else{
            enfermedadInstance = new ManejoEnfermedades()
        }

        return[enfermedadInstance: enfermedadInstance]
    }

    def saveManejoEnfermedad_ajax(){

        def enfermedad

        if(params.id){
            enfermedad = ManejoEnfermedades.get(params.id)
        }else{
            enfermedad = new ManejoEnfermedades()
        }

        enfermedad.properties = params

        if(!enfermedad.save(flush:true)){
            println("error save enfermedad" + enfermedad.errors)
            render("no_Error al guardar la enfermedad")
        }else {
            render("ok_Enfermedad guardada correctamente")
        }

    }

    def tablaManejoEnfermedades_ajax() {
        def finca = Finca.get(params.finca)
        def enfermedades = ManejoEnfermedades.findAllByFinca(finca)
        return[enfermedades: enfermedades]
    }

    def borrarManejoEnfermedad_ajax(){
        def enfermedad = ManejoEnfermedades.get(params.id)

        try {
            enfermedad.delete(flush:true)
            render "ok_enfermedad borrado correctamente"
        }catch(e){
            println("error al borrar el enfermedad: " + e)
            render "no_Error al borrar la enfermedad"
        }
    }

}
