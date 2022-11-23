package rikcharina

class TrabajoFamiliar {

    static auditable = true

    Finca    finca
    Familia  familia
    int      numero
    String   actividad
    String   tipo

    static mapping = {
        table 'trfm'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id        column: 'trfm__id'
            finca     column: 'fnca__id'
            familia   column: 'faml__id'
            numero    column: 'trfmnmro'
            actividad column: 'trfmactv'
            tipo      column: 'trfmtipo'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        numero (blank: false, nullable: false)
        actividad (blank: false, nullable: false)
        tipo (blank: false, nullable: false)
    }

    String toString() {
        "${this.actividad}"
    }
}
