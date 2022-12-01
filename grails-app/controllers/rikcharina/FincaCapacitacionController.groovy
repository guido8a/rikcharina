package rikcharina

class FincaCapacitacionController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def capacitacionInstance

        if(params.id){
            capacitacionInstance = FincaCapacitacion.get(params.id)
        }else{
            capacitacionInstance = new FincaCapacitacion()
        }

        return[capacitacionInstance: capacitacionInstance]
    }

    def saveFincaCapacitacion_ajax(){

        def capacitacion

        if(params.id){
            capacitacion = FincaCapacitacion.get(params.id)
        }else{
            capacitacion = new FincaCapacitacion()
        }

        capacitacion.properties = params

        if(!capacitacion.save(flush:true)){
            println("error save capacitación" + capacitacion.errors)
            render("no_Error al guardar el curso de capacitación")
        }else {
            render("ok_Curso de capacitación guardado correctamente")
        }

    }

    def tablaCapacitacion_ajax() {
        def finca = Finca.get(params.finca)
        def capacitaciones = FincaCapacitacion.findAllByFinca(finca)
        return[capacitaciones: capacitaciones]
    }

    def borrarFincaCapacitacion_ajax(){
        def capacitacion = FincaCapacitacion.get(params.id)

        try {
            capacitacion.delete(flush:true)
            render "ok_Curso de capacitación borrado correctamente"
        }catch(e){
            println("error al borrar  capacitación: " + e)
            render "no_Error al borrar el curso de capacitacióno"
        }
    }

}
