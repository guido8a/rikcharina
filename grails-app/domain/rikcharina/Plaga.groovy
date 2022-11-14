package rikcharina

class Plaga {

    static auditable = true
    String descripcion

    static mapping = {
        table 'plga'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id column: 'plga__id'
            descripcion column: 'plgadscr'
        }
    }


    static constraints = {
        descripcion(blank: false, size: 0..50)
    }

    String toString() {
        "${this.descripcion}"
    }
}
