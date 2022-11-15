package rikcharina

class Equipo {

    static auditable = true
    String descripcion

    static mapping = {
        table 'eqpo'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id          column: 'eqpo__id'
            descripcion column: 'eqpodscr'
        }
    }


    static constraints = {
        descripcion(blank: false, size: 0..50)
    }

    String toString() {
        "${this.descripcion}"
    }
}
