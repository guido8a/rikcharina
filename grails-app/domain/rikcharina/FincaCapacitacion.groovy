package rikcharina

class FincaCapacitacion {

    static auditable = true

    Finca    finca
    Capacitacion  capacitacion

    static mapping = {
        table 'fncp'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id           column: 'fncp__id'
            finca        column: 'fnca__id'
            capacitacion column: 'capc__id'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        capacitacion (blank: false, nullable: false)
    }

    String toString() {
        "${this.capacitacion}"
    }
}
