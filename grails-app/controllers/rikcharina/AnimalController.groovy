package rikcharina

class AnimalController {

    def list (){

    }

    def tablaAnimales_ajax () {
        def animales = Animal.list().sort{it.descripcion}
        return [animales: animales]
    }

    def form_ajax () {
        def animal

        if(params.id){
            animal = Animal.get(params.id)
            if (!animal) {
                flash.clase = "alert-error"
                flash.message = "No se encontró el animal"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            animal = new Animal()
        }

        return[animalInstance: animal]
    }

    def saveAnimal_ajax () {

        def animal

        if(params.id){
            animal = Animal.get(params.id)
            if (!animal) {
                flash.clase = "alert-error"
                flash.message = "No se encontró el animal"
                redirect(action: "list")
            } //no existe el objeto
        }else{
            animal = new Animal()
        }

        animal.properties = params

        if(!animal.save(flush:true)){
            render("no_Error al guardar el animal")
        }else{
            render("ok_Animal guardado correctamente")
        }
    }

    def borrarAnimal_ajax () {

        def animal = Animal.get(params.id)
        if (!animal) {
            flash.clase = "alert-error"
            flash.message = "No se encontró el animal"
            redirect(action: "list")
            //no existe el objeto
        }else{
            try {
                animal.delete(flush:true)
                render "ok_Animal borrado correctamente"
            }catch(e){
                println("error al borrar animal: " + e)
                render "no_Error al borrar el animal"
            }
        }
    }

}
