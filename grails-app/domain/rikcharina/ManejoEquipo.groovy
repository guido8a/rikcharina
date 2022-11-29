package rikcharina

class ManejoEquipos {

    static auditable = true

    Finca    finca
    Equipo   equipo
    int      area

    static mapping = {
        table 'mjeq'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id        column: 'mjeq__id'
            finca     column: 'fnca__id'
            equipo    column: 'eqpo__id'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        equipo (blank: false, nullable: false)
    }

    String toString() {
        "${this.equipo}"
    }
}
