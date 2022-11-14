package rikcharina

class Enfermedad {

    static auditable = true
    String descripcion

    static mapping = {
        table 'enfr'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id column: 'enfr__id'
            descripcion column: 'enfrdscr'
        }
    }


    static constraints = {
        descripcion(blank: false, size: 0..50)
    }

    String toString() {
        "${this.descripcion}"
    }
}
