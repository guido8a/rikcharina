package rikcharina

class TipoObra {

    static auditable = true
    String descripcion

    static mapping = {
        table 'tpob'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id column: 'tpob__id'
            descripcion column: 'tpobdscr'
        }
    }


    static constraints = {
        descripcion(blank: false, size: 0..50)
    }

    String toString() {
        "${this.descripcion}"
    }
}
