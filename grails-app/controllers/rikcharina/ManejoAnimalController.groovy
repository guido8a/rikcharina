package rikcharina


class ManejoAnimalController {

    def list(){
        return[finca: params.finca]
    }

    def form_ajax(){

        def animalInstance

        if(params.id){
            animalInstance = ManejoAnimal.get(params.id)
        }else{
            animalInstance = new ManejoAnimal()
        }

        return[animalInstance: animalInstance]
    }

    def saveManejoAnimal_ajax(){

        def animal

        if(params.id){
            animal = ManejoAnimal.get(params.id)
        }else{
            animal = new ManejoAnimal()
        }

        animal.properties = params

        if(!animal.save(flush:true)){
            println("error save animal" + animal.errors)
            render("no_Error al guardar el manejo animal")
        }else {
            render("ok_Manejo animal guardado correctamente")
        }

    }

    def tablaManejoAnimal_ajax() {
        def finca = Finca.get(params.finca)
        def animales = ManejoAnimal.findAllByFinca(finca)
        return[animales: animales]
    }

    def borrarManejoAnimal_ajax(){
        def animal = ManejoAnimal.get(params.id)

        try {
            animal.delete(flush:true)
            render "ok_Manejo animal borrado correctamente"
        }catch(e){
            println("error al borrar el animal: " + e)
            render "no_Error al borrar el manejo animal"
        }
    }

}
