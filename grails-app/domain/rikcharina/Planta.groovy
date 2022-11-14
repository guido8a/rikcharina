package rikcharina

class Planta {

    static auditable = true
    String descripcion

    static mapping = {
        table 'plnt'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id column: 'plnt__id'
            descripcion column: 'plntdscr'
        }
    }


    static constraints = {
        descripcion(blank: false, size: 0..50)
    }

    String toString() {
        "${this.descripcion}"
    }
}
