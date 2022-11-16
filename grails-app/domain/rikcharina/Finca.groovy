package rikcharina

import audita.Auditable

class Finca implements Auditable{

    String  dispositivo                   
    int     parroquia                     
    String  comunidad                     
//    String  institucion
    Institucion  institucion
    Date    fecha
    String  nombre                        
    String  direccion                     
    String  propietario                   
    String  delegado                      
    int     altura                        
    String  promotor                      
    String  entrevista                    
    double  longitud                      
    double  latitud                       
    String  zona                          
    String  foto                          
    int     actvAgricola                  
    int     actvPecuaria                  
    int     jornalerosPermanentes         
    int     jornalerosTemporales          
    String  organizacion                  
    String  plan                          
    int     terrenoPlano                  
    int     terrenoInclinado              
    String  asociacionCultivos            
    String  rotacionCultivos              
    String  seleccionSemillas             
    String  semillaPropia                 
    String  semillaComprada               
    String  semillaIntercambio            
    String  calendarizacion               
    int     invernadero                   
    String  preparacionSuelo              
    String  fertilizantes                 
    String  fertilizacionComplementaria   
    String  manejoRastrojos               
    String  aguaRiego                     
    String  juntaAgua                     
    String  aguaFuente                    
    String  aguaInfraestructura           
    String  forestal                      
    String  monte                         
    String  pasto                         
    String  pastoAbono                    
    String  manejoPasto                   
    String  instalaciones                 
    String  sanitario                     
    String  ancestrales                   
    String  basura                        
    int     autoconsumo                   
    int     venta                         
    String  lugarVenta                    
    String  fecuencia                     
    String  estaoOrganizacion             
    String  calificacion                  


    static auditable = true

    def permisos = []

    static mapping = {
        table 'fnca'
        cache usage: 'read-write', include: 'non-lazy'
        id generator: 'identity'
        version false

        columns {
            id                          column: 'fnca__id'
            dispositivo                 columm: 'fncadspt'
            parroquia                   columm: 'parr__id'
            comunidad                   columm: 'fncacmnd'
            institucion                 columm: 'inst__id'
            fecha                       columm: 'fncafcha'
            nombre                      columm: 'fncanmbr'
            direccion                   columm: 'fncadire'
            propietario                 columm: 'fncaprop'
            delegado                    columm: 'fncadlgd'
            altura                      columm: 'fncaaltt'
            promotor                    columm: 'fncaprmt'
            entrevista                  columm: 'fncanbpe'
            longitud                    columm: 'fncalong'
            latitud                     columm: 'fncalatt'
            zona                        columm: 'fncazona'
            foto                        columm: 'fncaftrp'
            actvAgricola                columm: 'fncaacag'
            actvPecuaria                columm: 'fncaacpe'
            jornalerosPermanentes       columm: 'fncajrpe'
            jornalerosTemporales        columm: 'fncajrtm'
            organizacion                columm: 'fncaorga'
            plan                        columm: 'fncaplan'
            terrenoPlano                columm: 'fncatrpl'
            terrenoInclinado            columm: 'fncatrin'
            asociacionCultivos          columm: 'fncaascl'
            rotacionCultivos            columm: 'fncartcl'
            seleccionSemillas           columm: 'fncasesm'
            semillaPropia               columm: 'fncasmpr'
            semillaComprada             columm: 'fncasmcm'
            semillaIntercambio          columm: 'fncasmin'
            calendarizacion             columm: 'fncacald'
            invernadero                 columm: 'fncainvr'
            preparacionSuelo            columm: 'fncaprsl'
            fertilizantes               columm: 'fncafrtl'
            fertilizacionComplementaria columm: 'fncafrcm'
            manejoRastrojos             columm: 'fncamjrs'
            aguaRiego                   columm: 'fncaagrg'
            juntaAgua                   columm: 'fncajnag'
            aguaFuente                  columm: 'fncaagfn'
            aguaInfraestructura         columm: 'fncaagif'
            forestal                    columm: 'fncafrst'
            monte                       columm: 'fncamnte'
            pasto                       columm: 'fncapsto'
            pastoAbono                  columm: 'fncapsab'
            manejoPasto                 columm: 'fncamjps'
            instalaciones               columm: 'fncainfr'
            sanitario                   columm: 'fncasant'
            ancestrales                 columm: 'fncaancs'
            basura                      columm: 'fncabsra'
            autoconsumo                 columm: 'fncaauto'
            venta                       columm: 'fncavnta'
            lugarVenta                  columm: 'fncalgvn'
            fecuencia                   columm: 'fncafrec'
            estaoOrganizacion           columm: 'fncaoged'
            calificacion                columm: 'fncacalf'
        }
    }
    static constraints = {
        dispositivo(blank:false, nullable: false)
        parroquia(blank:false, nullable: false)
        comunidad              (blank:false, nullable: false)
        institucion            (blank:false, nullable: false)
        fecha                  (blank:false, nullable: false)
        nombre                 (blank:false, nullable: false)
        direccion              (blank:false, nullable: false)
        propietario            (blank:false, nullable: false)
        delegado               (blank:false, nullable: false)
        altura                 (blank:false, nullable: false)
        promotor               (blank:false, nullable: false)
        entrevista             (blank:false, nullable: false)
        longitud               (blank:false, nullable: false)
        latitud                (blank:false, nullable: false)
        zona                   (blank:false, nullable: false)
        foto                   (blank:false, nullable: false)
        actvAgricola           (blank:false, nullable: false)
        actvPecuaria           (blank:false, nullable: false)
        jornalerosPermanentes  (blank:false, nullable: false)
        jornalerosTemporales   (blank:false, nullable: false)
        organizacion           (blank:false, nullable: false)
        plan(blank:false, nullable: false)
        terrenoPlano                (blank:false, nullable: false)
        terrenoInclinado            (blank:false, nullable: false)
        asociacionCultivos          (blank:false, nullable: false)
        rotacionCultivos            (blank:false, nullable: false)
        seleccionSemillas           (blank:false, nullable: false)
        semillaPropia               (blank:false, nullable: false)
        semillaComprada             (blank:false, nullable: false)
        semillaIntercambio          (blank:false, nullable: false)
        calendarizacion             (blank:false, nullable: false)
        invernadero                 (blank:false, nullable: false)
        preparacionSuelo            (blank:false, nullable: false)
        fertilizantes               (blank:false, nullable: false)
        fertilizacionComplementaria (blank:false, nullable: false)
        manejoRastrojos             (blank:false, nullable: false)
        aguaRiego                   (blank:false, nullable: false)
        juntaAgua                   (blank:false, nullable: false)
        aguaFuente                  (blank:false, nullable: false)
        aguaInfraestructura      (blank:false, nullable: false)
        forestal                 (blank:false, nullable: false)
        monte                    (blank:false, nullable: false)
        pasto                    (blank:false, nullable: false)
        pastoAbono               (blank:false, nullable: false)
        manejoPasto              (blank:false, nullable: false)
        instalaciones            (blank:false, nullable: false)
        sanitario                (blank:false, nullable: false)
        ancestrales              (blank:false, nullable: false)
        basura                   (blank:false, nullable: false)
        autoconsumo              (blank:false, nullable: false)
        venta                    (blank:false, nullable: false)
        lugarVenta               (blank:false, nullable: false)
        fecuencia                (blank:false, nullable: false)
        estaoOrganizacion        (blank:false, nullable: false)
        calificacion             (blank:false, nullable: false)
    }

    String toString() {
        "${this.id}: ${this.nombre} ${this.comunidad}"
    }

}
