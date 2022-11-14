package rikcharina

class Capacitacion {

    static auditable = true
    String descripcion

    static mapping = {
        table 'capc'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id column: 'capc__id'
            descripcion column: 'capcdscr'
        }
    }


    static constraints = {
        descripcion(blank: false, size: 0..50)
    }

    String toString() {
        "${this.descripcion}"
    }
}
