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
        if(existe) {
            sql = "select fnca__id from fnca where fncaidds = ${data.fnca__id} and " +
                "fncadspt = '${data.fncadspt}'"
            id = cn.rows(sql.toString())[0]?.fnca__id
        } else {
            id = 0
        }

        println "borrando las fincas del dispositivo: ${data.fncadspt}"

        cn.execute("delete from fnca_t where fncadspt = '${data.fncadspt}'")

        if(id > 0) {
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
            fncatrpl = '${data.fncatrpl}',
            fncatrin = '${data.fncatrin}',
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
                "fncaorga, fncadspt, fncatrpl, fncatrin, fncaascl," +
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
                "'${data.fncaorga}', '${data.fncadspt}', '${data.fncatrpl}', '${data.fncatrin}', '${data.fncaascl}'," +
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
                    "fncaorga, fncadspt, fncatrpl, fncatrin, fncaascl," +
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
                    "fncaorga, fncadspt, fncatrpl, fncatrin, fncaascl," +
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
        def retorna =  [Token: token, ok: true, id: id]
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


}