package rikcharina


class FincaController {

    def list() {

    }

    def finca() {

        def finca

        if(params.id){
            finca = Finca.get(params.id)
        }else{
            finca = new Finca()
        }

        return [finca: finca]

    }

    def saveFinca_ajax () {

    }



}
