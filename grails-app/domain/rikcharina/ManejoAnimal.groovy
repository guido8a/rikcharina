package rikcharina

class ManejoAnimal {

    static auditable = true

    Finca    finca
    Animal   animal
    int      numero

    static mapping = {
        table 'mjan'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'mjan__id'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id        column: 'mjan__id'
            finca     column: 'fnca__id'
            animal    column: 'anml__id'
            numero    column: 'mjannmro'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        numero (blank: false, nullable: false)
    }

    String toString() {
        "${this.animal}"
    }
}
