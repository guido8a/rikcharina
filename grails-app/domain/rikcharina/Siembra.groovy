package rikcharina

class Siembra {

    static auditable = true
    String descripcion

    static mapping = {
        table 'smbr'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id          column: 'smbr__id'
            descripcion column: 'smbrdscr'
        }
    }


    static constraints = {
        descripcion(blank: false, size: 0..50)
    }

    String toString() {
        "${this.descripcion}"
    }
}
