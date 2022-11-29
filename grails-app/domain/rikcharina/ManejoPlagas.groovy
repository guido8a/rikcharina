package rikcharina

class ManejoPlagas {

    static auditable = true

    Finca    finca
    Plaga  plaga
    int      area

    static mapping = {
        table 'mjpg'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id        column: 'mjpg__id'
            finca     column: 'fnca__id'
            plaga     column: 'plga__id'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        plaga (blank: false, nullable: false)
    }

    String toString() {
        "${this.plaga}"
    }
}
