package rikcharina

class AreaProduccion {

    static auditable = true

    Finca    finca
    TipoLote tipoLote
    String   referencia
    int      area
    int      usoAgricola
    int      usoPecuario
    int      pendiente

    static mapping = {
        table 'arpr'
        cache usage: 'read-write', include: 'non-lazy'
        version false
        id generator: 'identity'
        control sort: ['ctrlNombre': 'asc']
             columns {
            id          column: 'arpr__id'
            finca       column: 'fnca__id'
            tipoLote    column: 'tplt__id'
            referencia  column: 'arprrefe'
            area        column: 'arprarea'
            usoAgricola column: 'arprusag'
            usoPecuario column: 'arpruspc'
            pendiente   column: 'arprpndt'
        }
    }


    static constraints = {
        finca (blank: false, nullable: false)
        tipoLote (blank: false, nullable: false)
        referencia (blank: false, nullable: false)
        area (blank: false, nullable: false)
        usoAgricola (blank: false, nullable: false)
        usoPecuario (blank: false, nullable: false)
        pendiente (blank: false, nullable: false)
    }

    String toString() {
        "${this.referencia}"
    }
}
