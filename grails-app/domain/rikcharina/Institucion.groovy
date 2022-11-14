package rikcharina

class Institucion {

    static auditable = true
    String nombre

    static mapping = {
        table 'inst'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id column: 'inst__id'
            nombre column: 'instnmbr'
        }
    }


    static constraints = {
        nombre(blank: false, size: 0..50)
    }

    String toString() {
        "${this.nombre}"
    }
}
