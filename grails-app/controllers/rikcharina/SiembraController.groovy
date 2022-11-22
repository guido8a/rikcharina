package rikcharina


class SiembraController {

    def list (){

    }

    def tablaSiembras_ajax () {
        def siembras = Siembra.list().sort{it.descripcion}
        return [siembras: siembras]
    }

    def form_ajax () {
        def siembra

        if(params.id){
            siembra = Siembra.get(params.id)
            if (!siembra) {
                flash.clase = "alert-error"
                flash.message = "No se encontró el tipo de siembra"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            siembra = new Siembra()
        }

        return[siembraInstance: siembra]
    }

    def saveSiembra_ajax () {

        def siembra

        if(params.id){
            siembra = Siembra.get(params.id)
            if (!siembra) {
                flash.clase = "alert-error"
                flash.message = "No se encontró el tipo de siembra"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            siembra = new Siembra()
        }

        siembra.properties = params

        if(!siembra.save(flush:true)){
            render("no_Error al guardar el tipo de siembra")
        }else{
            render("ok_Tipo de siembra guardada correctamente")
        }
    }

    def borrarSiembra_ajax () {

        def siembra = Siembra.get(params.id)
        if (!siembra) {
            flash.clase = "alert-error"
            flash.message = "No se encontró el tipo de siembra"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                siembra.delete(flush:true)
                render "ok_Tipo de siembra borrada correctamente"
            }catch(e){
                println("error al borrar siembra: " + e)
                render "no_Error al borrar el tipo de siembra"
            }
        }
    }

}
