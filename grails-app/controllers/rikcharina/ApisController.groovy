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
        println "fctrServicio params: $params --hd: ${request.getHeader('token')}"
        println "data --> ${request.JSON}"
        def token = request.getHeader('token')
        def data = request.JSON
        println "....Inicia copia, token: $token"
        def sql = "insert into fnca_t values "
        println "....Fin"

        def retorna =  [Token: token, ok: true, data: data]
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