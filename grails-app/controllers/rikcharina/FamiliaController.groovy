package rikcharina

class FamiliaController {

    def list (){

    }

    def tablaFamilia_ajax () {
        def familias = Familia.list().sort{it.descripcion}
        return [familias: familias]
    }

    def form_ajax () {
        def familia

        if(params.id){
            familia = Familia.get(params.id)
            if (!familia) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la familia"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            familia = new Familia()
        }

        return[familiaInstance: familia]
    }

    def saveFamilia_ajax () {

        def familia

        if(params.id){
            familia = Familia.get(params.id)
            if (!familia) {
                flash.clase = "alert-error"
                flash.message = "No se encontró la familia"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            familia = new Familia()
        }

        familia.properties = params

        if(!familia.save(flush:true)){
            render("no_Error al guardar la familia")
        }else{
            render("ok_Familia guardada correctamente")
        }
    }

    def borrarFamilia_ajax () {

        def familia = Familia.get(params.id)
        if (!familia) {
            flash.clase = "alert-error"
            flash.message = "No se encontró la familia"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                familia.delete(flush:true)
                render "ok_Familia borrada correctamente"
            }catch(e){
                println("error al borrar familia: " + e)
                render "no_Error al borrar la familia"
            }
        }
    }



}
