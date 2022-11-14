package rikcharina

class TipoLote {

    static auditable = true
    String descripcion

    static mapping = {
        table 'tplt'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id column: 'tplt__id'
            descripcion column: 'tpltdscr'
        }
    }


    static constraints = {
        descripcion(blank: false, size: 0..50)
    }

    String toString() {
        "${this.descripcion}"
    }
}
