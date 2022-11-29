package rikcharina

class ManejoEnfermedades {

    static auditable = true

    Finca      finca
    Enfermedad enfermedad

    static mapping = {
        table 'mjen'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id         column: 'mjen__id'
            finca      column: 'fnca__id'
            enfermedad column: 'enfr__id'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        enfermedad (blank: false, nullable: false)
    }

    String toString() {
        "${this.enfermedad}"
    }
}
