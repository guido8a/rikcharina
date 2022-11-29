package rikcharina

class FincaCargo {

    static auditable = true

    Finca    finca
    Cargo    cargo

    static mapping = {
        table 'fncg'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id      column: 'fncg__id'
            finca   column: 'fnca__id'
            cargo   column: 'crgo__id'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        cargo (blank: false, nullable: false)
    }

    String toString() {
        "${this.  cargo}"
    }
}
