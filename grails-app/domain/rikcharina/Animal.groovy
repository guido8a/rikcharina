package rikcharina

import audita.Auditable

class Animal implements Auditable{

    static auditable = true
    String descripcion

    static mapping = {
        table 'anml'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id          column: 'anml__id'
            descripcion column: 'anmldscr'
        }
    }


    static constraints = {
        descripcion(blank: false, size: 0..50)
    }

    String toString() {
        "${this.descripcion}"
    }
}
