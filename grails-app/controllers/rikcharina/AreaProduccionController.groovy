package rikcharina


class AreaProduccionController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def areaInstance

        if(params.id){
            areaInstance = AreaProduccion.get(params.id)
        }else{
            areaInstance = new AreaProduccion()
        }

        return[areaInstance: areaInstance]
    }

    def saveArea_ajax(){

        def area

        if(params.id){
            area = AreaProduccion.get(params.id)
        }else{
            area = new AreaProduccion()
        }

        area.properties = params

        if(!area.save(flush:true)){
            println("error save area" + area.errors)
            render("no_Error al guardar el área de producción")
        }else{
            render("ok_Área de producción guardada correctamente")
        }
    }

    def tablaAreas_ajax() {
        def finca = Finca.get(params.finca)
        def areas = AreaProduccion.findAllByFinca(finca)
        return[areas: areas]
    }

    def borrarArea_ajax(){
        def area = AreaProduccion.get(params.id)

            try {
                area.delete(flush:true)
                render "ok_Área borrada correctamente"
            }catch(e){
                println("error al borrar el área: " + e)
                render "no_Error al borrar el área"
            }
    }


}
