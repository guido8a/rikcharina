package rikcharina

class Cultivos {

    static auditable = true

    Finca    finca
    Planta  planta
    int      area

    static mapping = {
        table 'cltv'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id        column: 'cltv__id'
            finca     column: 'fnca__id'
            planta   columm: 'plnt__id'
            area    column: 'cltvarea'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        planta (blank: false, nullable: false)
        area (blank: false, nullable: false)
    }

    String toString() {
        "${this.planta}"
    }
}
