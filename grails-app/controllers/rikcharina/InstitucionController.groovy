package rikcharina

class InstitucionController {

    def list (){

    }

    def tablaInstituciones_ajax () {
        def instituciones = Institucion.list()
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

    }

}
