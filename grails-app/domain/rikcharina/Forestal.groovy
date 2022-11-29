package rikcharina

class Forestal {

    static auditable = true

    Finca    finca
    Siembra  siembra

    static mapping = {
        table 'frst'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id        column: 'frst__id'
            finca     column: 'fnca__id'
            siembra     column: 'smbr__id'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        siembra (blank: false, nullable: false)
    }

    String toString() {
        "${this.siembra}"
    }
}
