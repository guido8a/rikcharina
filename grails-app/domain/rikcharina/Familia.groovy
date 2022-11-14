package rikcharina

class Familia {

    static auditable = true
    String descripcion

    static mapping = {
        table 'faml'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id column: 'faml__id'
            descripcion column: 'famldscr'
        }
    }


    static constraints = {
        descripcion(blank: false, size: 0..50)
    }

    String toString() {
        "${this.descripcion}"
    }
}
