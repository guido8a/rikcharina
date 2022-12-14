package rikcharina

import grails.converters.JSON

class ApisController {
    def mail
    def dbConnectionService

    def index() {
        redirect(controller: 'apis', action: 'saludo')
    }

    def saludo() {
        def mensaje = [saludo: "Hola", ok: true]
        render mensaje as JSON
    }

    /** nuevo 2022 servicio factura */
    def finca() {
        def cn = dbConnectionService.getConnection()
        println "fctrServicio params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def data = request.JSON
        println "....Inicia copia, token: $token"
        def inst = data.fncainst == 'Rikcharina' ? 1 : data.fncainst == 'GADPC' ? 2 : 3
        def sql = ""
        sql = "select count(*) cnta from fnca where fncaidds = ${data.fnca__id} and fncadspt = '${data.fncadspt}'"
        println "sql: $sql"
        def existe = cn.rows(sql.toString())[0]?.cnta
        println "existe: $existe"
        def id = 0
        if (existe) {
            sql = "select fnca__id from fnca where fncaidds = ${data.fnca__id} and " +
                    "fncadspt = '${data.fncadspt}'"
            id = cn.rows(sql.toString())[0]?.fnca__id
        } else {
            id = 0
        }

        println "borrando las fincas del dispositivo: ${data.fncadspt}"

        cn.execute("delete from fnca_t where fncadspt = '${data.fncadspt}'")

        if (id > 0) {
            sql = """update fnca set
            parr__id = '${data.parr__id}',
            inst__id = '${inst}',
            fncacmnd = '${data.fncacmnd}',
            fncafcha = '${data.fncafcha}',
            fncanmbr = '${data.fncanmbr}',
            fncadire = '${data.fncadire}',
            fncaprop = '${data.fncaprop}',
            fncadlgd = '${data.fncadlgd}',
            fncaaltt = '${data.fncaaltt}',
            fncaprmt = '${data.fncaprmt}',
            fncanbpe = '${data.fncanbpe}',
            fncalong = '${data.fncalong}',
            fncalatt = '${data.fncalatt}',
            fncazona = '${data.fncazona}',
            fncaftrp = '${data.fncaftrp}',
            fncaacag = '${data.fncaacag}',
            fncaacpe = '${data.fncaacpe}',
            fncajrpe = '${data.fncajrpe}',
            fncajrtm = '${data.fncajrtm}',
            fncaorga = '${data.fncaorga}',
            fncadspt = '${data.fncadspt}',
            fncaascl = '${data.fncaascl}',
            fncartcl = '${data.fncartcl}',
            fncasesm = '${data.fncasesm}',
            fncasmpr = '${data.fncasmpr}',
            fncasmcm = '${data.fncasmcm}',
            fncasmin = '${data.fncasmin}',
            fncacald = '${data.fncacald}',
            fncainvr = '${data.fncainvr}',
            fncaprsl = '${data.fncaprsl}',
            fncafrtl = '${data.fncafrtl}',
            fncafrcm = '${data.fncafrcm}',
            fncamjrs = '${data.fncamjrs}',
            fncaagrg = '${data.fncaagrg}',
            fncajnag = '${data.fncajnag}',
            fncaagfn = '${data.fncaagfn}',
            fncaagif = '${data.fncaagif}',
            fncafrst = '${data.fncafrst}',
            fncamnte = '${data.fncamnte}',
            fncapsto = '${data.fncapsto}',
            fncapsab = '${data.fncapsab}',
            fncamjps = '${data.fncamjps}',
            fncainfr = '${data.fncainfr}',
            fncasant = '${data.fncasant}',
            fncaancs = '${data.fncaancs}',
            fncabsra = '${data.fncabsra}',
            fncaauto = '${data.fncaauto}',
            fncavnta = '${data.fncavnta}',
            fncalgvn = '${data.fncalgvn}',
            fncafrec = '${data.fncafrec}',
            fncaoged = '${data.fncaoged}',
            fncacalf = '${data.fncacalf}',
            fncaplan = '${data.fncaplan}'
            where fnca__id = ${id}
            """
            println "Actualizando datos en fnca_t id: ${id} -->${data.fncadspt}"
            cn.execute(sql.toString())
        } else {
            sql = "insert into fnca_t(fnca__id, parr__id, inst__id, fncacmnd, fncafcha," +
                    "fncanmbr, fncadire, fncaprop, fncadlgd, fncaaltt," +
                    "fncaprmt, fncanbpe, fncalong, fncalatt, fncazona," +
                    "fncaftrp, fncaacag, fncaacpe, fncajrpe, fncajrtm," +
                    "fncaorga, fncadspt, fncaascl," +
                    "fncartcl, fncasesm, fncasmpr, fncasmcm, fncasmin," +
                    "fncacald, fncainvr, fncaprsl, fncafrtl, fncafrcm," +
                    "fncamjrs, fncaagrg, fncajnag, fncaagfn, fncaagif," +
                    "fncafrst, fncamnte, fncapsto, fncapsab, fncamjps," +
                    "fncainfr, fncasant, fncaancs, fncabsra, fncaauto," +
                    "fncavnta, fncalgvn, fncafrec, fncaoged, fncacalf," +
                    "fncaplan) values (" +
                    "'${data.fnca__id}', '${data.parr__id}', '${inst}', '${data.fncacmnd}', '${data.fncafcha}'," +
                    "'${data.fncanmbr}', '${data.fncadire}', '${data.fncaprop}', '${data.fncadlgd}', '${data.fncaaltt}'," +
                    "'${data.fncaprmt}', '${data.fncanbpe}', '${data.fncalong}', '${data.fncalatt}', '${data.fncazona}'," +
                    "'${data.fncaftrp}', '${data.fncaacag}', '${data.fncaacpe}', '${data.fncajrpe}', '${data.fncajrtm}'," +
                    "'${data.fncaorga}', '${data.fncadspt}', '${data.fncaascl}'," +
                    "'${data.fncartcl}', '${data.fncasesm}', '${data.fncasmpr}', '${data.fncasmcm}', '${data.fncasmin}'," +
                    "'${data.fncacald}', '${data.fncainvr}', '${data.fncaprsl}', '${data.fncafrtl}', '${data.fncafrcm}'," +
                    "'${data.fncamjrs}', '${data.fncaagrg}', '${data.fncajnag}', '${data.fncaagfn}', '${data.fncaagif}'," +
                    "'${data.fncafrst}', '${data.fncamnte}', '${data.fncapsto}', '${data.fncapsab}', '${data.fncamjps}'," +
                    "'${data.fncainfr}', '${data.fncasant}', '${data.fncaancs}', '${data.fncabsra}', '${data.fncaauto}'," +
                    "'${data.fncavnta}', '${data.fncalgvn}', '${data.fncafrec}', '${data.fncaoged}', '${data.fncacalf}'," +
                    "'${data.fncaplan}' ) returning fnca__id"

            println "Insertando datos en fnca_t: ${data.fncadspt}"
            id = cn.rows(sql.toString())[0]?.fnca__id

            sql = "insert into fnca (fncaidds, parr__id, inst__id, fncacmnd, fncafcha," +
                    "fncanmbr, fncadire, fncaprop, fncadlgd, fncaaltt," +
                    "fncaprmt, fncanbpe, fncalong, fncalatt, fncazona," +
                    "fncaftrp, fncaacag, fncaacpe, fncajrpe, fncajrtm," +
                    "fncaorga, fncadspt, fncaascl," +
                    "fncartcl, fncasesm, fncasmpr, fncasmcm, fncasmin," +
                    "fncacald, fncainvr, fncaprsl, fncafrtl, fncafrcm," +
                    "fncamjrs, fncaagrg, fncajnag, fncaagfn, fncaagif," +
                    "fncafrst, fncamnte, fncapsto, fncapsab, fncamjps," +
                    "fncainfr, fncasant, fncaancs, fncabsra, fncaauto," +
                    "fncavnta, fncalgvn, fncafrec, fncaoged, fncacalf," +
                    "fncaplan) select fnca__id, parr__id, inst__id, fncacmnd, fncafcha," +
                    "fncanmbr, fncadire, fncaprop, fncadlgd, fncaaltt," +
                    "fncaprmt, fncanbpe, fncalong, fncalatt, fncazona," +
                    "fncaftrp, fncaacag, fncaacpe, fncajrpe, fncajrtm," +
                    "fncaorga, fncadspt, fncaascl," +
                    "fncartcl, fncasesm, fncasmpr, fncasmcm, fncasmin," +
                    "fncacald, fncainvr, fncaprsl, fncafrtl, fncafrcm," +
                    "fncamjrs, fncaagrg, fncajnag, fncaagfn, fncaagif," +
                    "fncafrst, fncamnte, fncapsto, fncapsab, fncamjps," +
                    "fncainfr, fncasant, fncaancs, fncabsra, fncaauto," +
                    "fncavnta, fncalgvn, fncafrec, fncaoged, fncacalf," +
                    "fncaplan from fnca_t where fnca__id = ${data.fnca__id} returning fnca__id"
            println "Insertando datos en fnca: ${data.fnca__id}"
            id = cn.rows(sql.toString())[0]?.fnca__id
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON

//        def nombre = 'factura.xml'
//        def path = "/var/tienda/empresas/empr_${empresa.id}/xml/ffc_${clave}.xml"
//        def file = new File(path)
//        def b = file.getBytes()
//        response.setContentType('text/html; charset=utf-8')
//        response.setHeader("Content-disposition", "attachment; filename=" + nombre)
//        response.setContentLength(b.length)
//        response.getOutputStream().write(b)
    }
    

    def arpr() {
        def cn = dbConnectionService.getConnection()
        println "++arpr params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id

                    sql = "select count(*) cnta from arpr where arpridds = ${dd.arpr__id} and arprdspt = '${dspt}' and " +
                            "fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    sql = "select tplt__id from tplt where tpltdscr ilike '${dd.arprtplt}'"
                    id_tipo = cn.rows(sql.toString())[0]?.tplt__id

                    println "borrando arpr del dispositivo: ${dspt}"
                    //*********** incluir dispositivo en tabla_t y borrar solo los del dispositivo a cargar.
                    cn.execute("delete from arpr_t where fnca__id in (select fnca__id from fnca " +
                            "where fncadspt = '${dspt}') and arprdspt = '${dspt}'")

                    println "existe finca: $existe_fnca, Existe arpr: ${existe}"
                    if (!existe) {
                        sql = """insert into arpr_t(arpr__id, fnca__id, tplt__id, arprrefe,
                            arprarea, arprusag, arpruspc, arprpndt, arprdspt)
                            values (${dd.arpr__id}, ${dd.fnca__id}, ${id_tipo}, '${dd.arprrefe}',
                            ${dd.arprarea}, ${dd.arprusag}, ${dd.arpruspc}, ${dd.arprpndt}, '${dspt}')"""

                        println "inserta registro en arpr_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into arpr(arpridds, fnca__id, tplt__id, arprrefe,
                            arprarea, arprusag, arpruspc, arprpndt, arprdspt) select arpr__id, ${id_fnca}, tplt__id, arprrefe,
                            arprarea, arprusag, arpruspc, arprpndt, arprdspt from arpr_t where arpr__id = ${dd.arpr__id}"""
                        println "inserta registro en arpr: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada arpridds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select arpr__id from arpr where fnca__id = ${id_fnca} and arpridds = ${dd.arpr__id} and " +
                                "arprdspt = '${dspt}'"
                        id = cn.rows(sql.toString())[0]?.arpr__id
                        println "id de arpr: $id"
                        if (id > 0) {
                            sql = """update arpr set tplt__id = ${id_tipo},
                                arprrefe = '${dd.arprrefe}',
                                arprarea = '${dd.arprarea}',
                                arprusag = '${dd.arprusag}',
                                arpruspc = '${dd.arpruspc}',
                                arprpndt = '${dd.arprpndt}'
                                where arpr__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }

    def trfm() {
        def cn = dbConnectionService.getConnection()
        println "++trfm params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    println "borrando trfm del dispositivo: ${dspt}"
                    cn.execute("delete from trfm_t where fnca__id in (select fnca__id from fnca where fncadspt = '${dspt}')")

                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id


                    sql = "select faml__id from faml where famldscr ilike '${dd.trfmfaml}'"
                    id_tipo = cn.rows(sql.toString())[0]?.faml__id

                    sql = "select count(*) cnta from trfm where trfmidds = ${dd.trfm__id} and fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    println "existe finca: $existe_fnca, Existe trfm: ${existe}"
                    
                    if (!existe) {
                        sql = """insert into trfm_t(trfm__id, fnca__id, faml__id, trfmactv,
                            trfmnmro, trfmtipo)
                            values (${dd.trfm__id}, ${dd.fnca__id}, ${id_tipo}, '${dd.trfmactv}',
                            ${dd.trfmnmro}, '${dd.trfmtipo}')"""

                        println "inserta registro en trfm_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into trfm(trfmidds, fnca__id, faml__id, trfmactv,
                            trfmnmro, trfmtipo) select trfm__id, ${id_fnca}, faml__id, trfmactv,
                            trfmnmro, trfmtipo from trfm_t where trfm__id = ${dd.trfm__id}"""
                        println "inserta registro en trfm: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada trfmidds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select trfm__id from trfm where fnca__id = ${id_fnca} and trfmidds = ${dd.trfm__id}"
                        id = cn.rows(sql.toString())[0]?.trfm__id
                        println "id de trfm: $id"
                        if (id > 0) {
                            sql = """update trfm set faml__id = ${id_tipo},
                                trfmactv = '${dd.trfmactv}',
                                trfmnmro = '${dd.trfmnmro}',
                                trfmtipo = '${dd.trfmtipo}'
                                where trfm__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }

    def obfn() {
        def cn = dbConnectionService.getConnection()
        println "++obfn params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    println "borrando obfn del dispositivo: ${dspt}"
                    cn.execute("delete from obfn_t where fnca__id in (select fnca__id from fnca where fncadspt = '${dspt}')")

                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id


                    sql = "select tpob__id from tpob where tpobdscr ilike '${dd.obfntipo}'"
                    id_tipo = cn.rows(sql.toString())[0]?.tpob__id

                    sql = "select count(*) cnta from obfn where obfnidds = ${dd.obfn__id} and fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    println "existe finca: $existe_fnca, Existe obfn: ${existe}"

                    if (!existe) {
                        sql = """insert into obfn_t(obfn__id, fnca__id, tpob__id, obfnetdo)
                            values (${dd.obfn__id}, ${dd.fnca__id}, ${id_tipo}, '${dd.obfnetdo}')"""

                        println "inserta registro en obfn_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into obfn(obfnidds, fnca__id, tpob__id, obfnetdo) 
                            select obfn__id, ${id_fnca}, tpob__id, obfnetdo
                            from obfn_t where obfn__id = ${dd.obfn__id}"""
                        println "inserta registro en obfn: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada obfnidds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select obfn__id from obfn where fnca__id = ${id_fnca} and obfnidds = ${dd.obfn__id}"
                        id = cn.rows(sql.toString())[0]?.obfn__id
                        println "id de obfn: $id"
                        if (id > 0) {
                            sql = """update obfn set tpob__id = ${id_tipo},
                                obfnetdo = '${dd.obfnetdo}'
                                where obfn__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }

    def cltv() {
        def cn = dbConnectionService.getConnection()
        println "++cltv params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    println "borrando cltv del dispositivo: ${dspt}"
                    cn.execute("delete from cltv_t where fnca__id in (select fnca__id from fnca where fncadspt = '${dspt}')")

                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id


                    sql = "select plnt__id from plnt where plntdscr ilike '${dd.cltvplnt}'"
                    id_tipo = cn.rows(sql.toString())[0]?.plnt__id

                    sql = "select count(*) cnta from cltv where cltvidds = ${dd.cltv__id} and fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    println "existe finca: $existe_fnca, Existe cltv: ${existe}"

                    if (!existe) {
                        sql = """insert into cltv_t(cltv__id, fnca__id, plnt__id, cltvarea)
                            values (${dd.cltv__id}, ${dd.fnca__id}, ${id_tipo}, '${dd.cltvarea}')"""

                        println "inserta registro en cltv_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into cltv(cltvidds, fnca__id, plnt__id, cltvarea) 
                            select cltv__id, ${id_fnca}, plnt__id, cltvarea
                            from cltv_t where cltv__id = ${dd.cltv__id}"""
                        println "inserta registro en cltv: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada cltvidds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select cltv__id from cltv where fnca__id = ${id_fnca} and cltvidds = ${dd.cltv__id}"
                        id = cn.rows(sql.toString())[0]?.cltv__id
                        println "id de cltv: $id"
                        if (id > 0) {
                            sql = """update cltv set plnt__id = ${id_tipo},
                                cltvarea = '${dd.cltvarea}'
                                where cltv__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }

    def mjen() {
        def cn = dbConnectionService.getConnection()
        println "++mjen params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    println "borrando mjen del dispositivo: ${dspt}"
                    cn.execute("delete from mjen_t where fnca__id in (select fnca__id from fnca where fncadspt = '${dspt}')")

                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id


                    sql = "select enfr__id from enfr where enfrdscr ilike '${dd.mjentipo}'"
                    id_tipo = cn.rows(sql.toString())[0]?.enfr__id

                    sql = "select count(*) cnta from mjen where mjenidds = ${dd.mjen__id} and fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    println "existe finca: $existe_fnca, Existe mjen: ${existe}"

                    if (!existe) {
                        sql = """insert into mjen_t(mjen__id, fnca__id, enfr__id)
                            values (${dd.mjen__id}, ${dd.fnca__id}, ${id_tipo})"""

                        println "inserta registro en mjen_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into mjen(mjenidds, fnca__id, enfr__id) 
                            select mjen__id, ${id_fnca}, enfr__id
                            from mjen_t where mjen__id = ${dd.mjen__id}"""
                        println "inserta registro en mjen: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada mjenidds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select mjen__id from mjen where fnca__id = ${id_fnca} and mjenidds = ${dd.mjen__id}"
                        id = cn.rows(sql.toString())[0]?.mjen__id
                        println "id de mjen: $id"
                        if (id > 0) {
                            sql = """update mjen set enfr__id = ${id_tipo}
                                where mjen__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }

    def mjpg() {
        def cn = dbConnectionService.getConnection()
        println "++mjpg params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    println "borrando mjpg del dispositivo: ${dspt}"
                    cn.execute("delete from mjpg_t where fnca__id in (select fnca__id from fnca where fncadspt = '${dspt}')")

                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id


                    sql = "select plga__id from plga where plgadscr ilike '${dd.mjpgtipo}'"
                    id_tipo = cn.rows(sql.toString())[0]?.plga__id

                    sql = "select count(*) cnta from mjpg where mjpgidds = ${dd.mjpg__id} and fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    println "existe finca: $existe_fnca, Existe mjpg: ${existe}"

                    if (!existe) {
                        sql = """insert into mjpg_t(mjpg__id, fnca__id, plga__id)
                            values (${dd.mjpg__id}, ${dd.fnca__id}, ${id_tipo})"""

                        println "inserta registro en mjpg_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into mjpg(mjpgidds, fnca__id, plga__id) 
                            select mjpg__id, ${id_fnca}, plga__id
                            from mjpg_t where mjpg__id = ${dd.mjpg__id}"""
                        println "inserta registro en mjpg: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada mjpgidds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select mjpg__id from mjpg where fnca__id = ${id_fnca} and mjpgidds = ${dd.mjpg__id}"
                        id = cn.rows(sql.toString())[0]?.mjpg__id
                        println "id de mjpg: $id"
                        if (id > 0) {
                            sql = """update mjpg set plga__id = ${id_tipo}
                                where mjpg__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }

    def frst() {
        def cn = dbConnectionService.getConnection()
        println "++frst params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    println "borrando frst del dispositivo: ${dspt}"
                    cn.execute("delete from frst_t where fnca__id in (select fnca__id from fnca where fncadspt = '${dspt}')")

                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id


                    sql = "select smbr__id from smbr where smbrdscr ilike '${dd.frsttipo}'"
                    id_tipo = cn.rows(sql.toString())[0]?.smbr__id

                    sql = "select count(*) cnta from frst where frstidds = ${dd.frst__id} and fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    println "existe finca: $existe_fnca, Existe frst: ${existe}"

                    if (!existe) {
                        sql = """insert into frst_t(frst__id, fnca__id, smbr__id)
                            values (${dd.frst__id}, ${dd.fnca__id}, ${id_tipo})"""

                        println "inserta registro en frst_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into frst(frstidds, fnca__id, smbr__id) 
                            select frst__id, ${id_fnca}, smbr__id
                            from frst_t where frst__id = ${dd.frst__id}"""
                        println "inserta registro en frst: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada frstidds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select frst__id from frst where fnca__id = ${id_fnca} and frstidds = ${dd.frst__id}"
                        id = cn.rows(sql.toString())[0]?.frst__id
                        println "id de frst: $id"
                        if (id > 0) {
                            sql = """update frst set smbr__id = ${id_tipo}
                                where frst__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }

    def mjan() {
        def cn = dbConnectionService.getConnection()
        println "++mjan params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    println "borrando mjan del dispositivo: ${dspt}"
                    cn.execute("delete from mjan_t where fnca__id in (select fnca__id from fnca where fncadspt = '${dspt}')")

                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id


                    sql = "select anml__id from anml where anmldscr ilike '${dd.mjantipo}'"
                    id_tipo = cn.rows(sql.toString())[0]?.anml__id

                    sql = "select count(*) cnta from mjan where mjanidds = ${dd.mjan__id} and fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    println "existe finca: $existe_fnca, Existe mjan: ${existe}"

                    if (!existe) {
                        sql = """insert into mjan_t(mjan__id, fnca__id, anml__id, mjannmro)
                            values (${dd.mjan__id}, ${dd.fnca__id}, ${id_tipo}, '${dd.mjannmro}')"""

                        println "inserta registro en mjan_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into mjan(mjanidds, fnca__id, anml__id, mjannmro) 
                            select mjan__id, ${id_fnca}, anml__id, mjannmro
                            from mjan_t where mjan__id = ${dd.mjan__id}"""
                        println "inserta registro en mjan: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada mjanidds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select mjan__id from mjan where fnca__id = ${id_fnca} and mjanidds = ${dd.mjan__id}"
                        id = cn.rows(sql.toString())[0]?.mjan__id
                        println "id de mjan: $id"
                        if (id > 0) {
                            sql = """update mjan set anml__id = ${id_tipo},
                                mjannmro = '${dd.mjannmro}'
                                where mjan__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }

def mjeq() {
        def cn = dbConnectionService.getConnection()
        println "++mjeq params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    println "borrando mjeq del dispositivo: ${dspt}"
                    cn.execute("delete from mjeq_t where fnca__id in (select fnca__id from fnca where fncadspt = '${dspt}')")

                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id


                    sql = "select eqpo__id from eqpo where eqpodscr ilike '${dd.mjeqtipo}'"
                    id_tipo = cn.rows(sql.toString())[0]?.eqpo__id

                    sql = "select count(*) cnta from mjeq where mjeqidds = ${dd.mjeq__id} and fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    println "existe finca: $existe_fnca, Existe mjeq: ${existe}"

                    if (!existe) {
                        sql = """insert into mjeq_t(mjeq__id, fnca__id, eqpo__id)
                            values (${dd.mjeq__id}, ${dd.fnca__id}, ${id_tipo})"""

                        println "inserta registro en mjeq_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into mjeq(mjeqidds, fnca__id, eqpo__id) 
                            select mjeq__id, ${id_fnca}, eqpo__id
                            from mjeq_t where mjeq__id = ${dd.mjeq__id}"""
                        println "inserta registro en mjeq: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada mjeqidds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select mjeq__id from mjeq where fnca__id = ${id_fnca} and mjeqidds = ${dd.mjeq__id}"
                        id = cn.rows(sql.toString())[0]?.mjeq__id
                        println "id de mjeq: $id"
                        if (id > 0) {
                            sql = """update mjeq set eqpo__id = ${id_tipo}
                                where mjeq__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }

def fncp() {
        def cn = dbConnectionService.getConnection()
        println "++fncp params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    println "borrando fncp del dispositivo: ${dspt}"
                    cn.execute("delete from fncp_t where fnca__id in (select fnca__id from fnca where fncadspt = '${dspt}')")

                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id


                    sql = "select capc__id from capc where capcdscr ilike '${dd.fncptipo}'"
                    id_tipo = cn.rows(sql.toString())[0]?.capc__id

                    sql = "select count(*) cnta from fncp where fncpidds = ${dd.fncp__id} and fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    println "existe finca: $existe_fnca, Existe fncp: ${existe}"

                    if (!existe) {
                        sql = """insert into fncp_t(fncp__id, fnca__id, capc__id)
                            values (${dd.fncp__id}, ${dd.fnca__id}, ${id_tipo})"""

                        println "inserta registro en fncp_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into fncp(fncpidds, fnca__id, capc__id) 
                            select fncp__id, ${id_fnca}, capc__id
                            from fncp_t where fncp__id = ${dd.fncp__id}"""
                        println "inserta registro en fncp: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada fncpidds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select fncp__id from fncp where fnca__id = ${id_fnca} and fncpidds = ${dd.fncp__id}"
                        id = cn.rows(sql.toString())[0]?.fncp__id
                        println "id de fncp: $id"
                        if (id > 0) {
                            sql = """update fncp set capc__id = ${id_tipo}
                                where fncp__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }

def fncg() {
        def cn = dbConnectionService.getConnection()
        println "++fncg params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def dspt = request.getHeader('dspt')
        def data = request.JSON
        def sql = ""
        def id_fnca = 0, id = 0, existe = 0, id_tipo = 0

        println "....Inicia copia, dispositivo: $dspt, token: $token"

        if (data.size() > 0) {
            data.each { dd ->
                sql = "select count(*) cnta from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                println "sql: $sql"
                def existe_fnca = cn.rows(sql.toString())[0]?.cnta
                println "existe finca: $existe_fnca"

                if (existe_fnca) {
                    println "borrando fncg del dispositivo: ${dspt}"
                    cn.execute("delete from fncg_t where fnca__id in (select fnca__id from fnca where fncadspt = '${dspt}')")

                    sql = "select fnca__id from fnca where fncaidds = ${dd.fnca__id} and fncadspt = '${dspt}'"
                    id_fnca = cn.rows(sql.toString())[0]?.fnca__id


                    sql = "select crgo__id from crgo where crgodscr ilike '${dd.fncgtipo}'"
                    id_tipo = cn.rows(sql.toString())[0]?.crgo__id

                    sql = "select count(*) cnta from fncg where fncgidds = ${dd.fncg__id} and fnca__id = '${id_fnca}'"
                    existe = cn.rows(sql.toString())[0]?.cnta
                    println "existe finca: $existe_fnca, Existe fncg: ${existe}"

                    if (!existe) {
                        sql = """insert into fncg_t(fncg__id, fnca__id, crgo__id)
                            values (${dd.fncg__id}, ${dd.fnca__id}, ${id_tipo})"""

                        println "inserta registro en fncg_t: $sql"
                        cn.execute(sql.toString())

                        sql = """insert into fncg(fncgidds, fnca__id, crgo__id) 
                            select fncg__id, ${id_fnca}, crgo__id
                            from fncg_t where fncg__id = ${dd.fncg__id}"""
                        println "inserta registro en fncg: $sql"

                        cn.execute(sql.toString())
                    } else {

                        /* para cada fncgidds se lo actualiza en caso de existir o se lo inserta */
                        sql = "select fncg__id from fncg where fnca__id = ${id_fnca} and fncgidds = ${dd.fncg__id}"
                        id = cn.rows(sql.toString())[0]?.fncg__id
                        println "id de fncg: $id"
                        if (id > 0) {
                            sql = """update fncg set crgo__id = ${id_tipo}
                                where fncg__id = ${id}"""
                            cn.execute(sql.toString())
                        }
                    }
                } else {
                    println "Error ********* no hay la finca"
                }
            }
        }

//        def retorna =  [Token: token, ok: true, data: data]
        def retorna = [Token: token, ok: true, id: id]
        render retorna as JSON
    }


}