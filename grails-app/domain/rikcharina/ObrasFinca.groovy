package rikcharina

class ObrasFinca {

    static auditable = true

    Finca    finca
    TipoObra tipoObra
    String   estado

    static mapping = {
        table 'obfn'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
        columns {
            id        column: 'obfn__id'
            finca     column: 'fnca__id'
            tipoObra  column: 'tpob__id'
            estado    column: 'obfnetdo'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        tipoObra (blank: false, nullable: false)
        estado (blank: false, nullable: false)
    }

    String toString() {
        "${this.tipoObra}"
    }
}
