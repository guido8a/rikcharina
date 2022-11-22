package rikcharina

class InstitucionController {

    def list (){

    }

    def tablaInstituciones_ajax () {
        def instituciones = Institucion.list().sort{it.nombre}
        return [instituciones: instituciones]
    }

    def form_ajax () {
        def institucion

        if(params.id){
            institucion = Institucion.get(params.id)
            if (!institucion) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la Institución"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            institucion = new Institucion()
        }

        return[institutoInstance: institucion]
    }

    def saveInstitucion_ajax () {

        def institucion

        if(params.id){
            institucion = Institucion.get(params.id)
            if (!institucion) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la Institución"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            institucion = new Institucion()
        }

        institucion.properties = params

        if(!institucion.save(flush:true)){
            render("no_Error al guardar la institución")
        }else{
            render("ok_Institución guardada correctamente")
        }

    }

    def borrarInstitucion_ajax () {

        def institucion = Institucion.get(params.id)
        if (!institucion) {
            flash.clase = "alert-error"
            flash.message = "No se encontró la Institución"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                institucion.delete(flush:true)
                render "ok_Institución borrada correctamente"
            }catch(e){
                println("error al borrar la institucion: " + e)
                render "no_Error al borrar la Institución"
            }
        }
    }

}
