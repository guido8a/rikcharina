package rikcharina

import audita.Auditable

class Finca implements Auditable{
    static auditable = true

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
    int     idDispositivo

    static mapping = {
        table 'fnca'
        cache usage: 'read-write', include: 'non-lazy'
        id generator: 'identity'
        version false

        columns {
            id                          column: 'fnca__id'
            dispositivo                 column: 'fncadspt'
            parroquia                   column: 'parr__id'
            comunidad                   column: 'fncacmnd'
            institucion                 column: 'inst__id'
            fecha                       column: 'fncafcha'
            nombre                      column: 'fncanmbr'
            direccion                   column: 'fncadire'
            propietario                 column: 'fncaprop'
            delegado                    column: 'fncadlgd'
            altura                      column: 'fncaaltt'
            promotor                    column: 'fncaprmt'
            entrevista                  column: 'fncanbpe'
            longitud                    column: 'fncalong'
            latitud                     column: 'fncalatt'
            zona                        column: 'fncazona'
            foto                        column: 'fncaftrp'
            actvAgricola                column: 'fncaacag'
            actvPecuaria                column: 'fncaacpe'
            jornalerosPermanentes       column: 'fncajrpe'
            jornalerosTemporales        column: 'fncajrtm'
            organizacion                column: 'fncaorga'
            plan                        column: 'fncaplan'
            terrenoPlano                column: 'fncatrpl'
            terrenoInclinado            column: 'fncatrin'
            asociacionCultivos          column: 'fncaascl'
            rotacionCultivos            column: 'fncartcl'
            seleccionSemillas           column: 'fncasesm'
            semillaPropia               column: 'fncasmpr'
            semillaComprada             column: 'fncasmcm'
            semillaIntercambio          column: 'fncasmin'
            calendarizacion             column: 'fncacald'
            invernadero                 column: 'fncainvr'
            preparacionSuelo            column: 'fncaprsl'
            fertilizantes               column: 'fncafrtl'
            fertilizacionComplementaria column: 'fncafrcm'
            manejoRastrojos             column: 'fncamjrs'
            aguaRiego                   column: 'fncaagrg'
            juntaAgua                   column: 'fncajnag'
            aguaFuente                  column: 'fncaagfn'
            aguaInfraestructura         column: 'fncaagif'
            forestal                    column: 'fncafrst'
            monte                       column: 'fncamnte'
            pasto                       column: 'fncapsto'
            pastoAbono                  column: 'fncapsab'
            manejoPasto                 column: 'fncamjps'
            instalaciones               column: 'fncainfr'
            sanitario                   column: 'fncasant'
            ancestrales                 column: 'fncaancs'
            basura                      column: 'fncabsra'
            autoconsumo                 column: 'fncaauto'
            venta                       column: 'fncavnta'
            lugarVenta                  column: 'fncalgvn'
            fecuencia                   column: 'fncafrec'
            estaoOrganizacion           column: 'fncaoged'
            calificacion                column: 'fncacalf'
            idDispositivo               column: 'fncaidds'
        }
    }
    static constraints = {
        dispositivo            (blank:false, nullable: false)
        parroquia              (blank:false, nullable: false)
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
        foto                   (blank:true, nullable: true)
        actvAgricola           (blank:false, nullable: false)
        actvPecuaria           (blank:false, nullable: false)
        jornalerosPermanentes  (blank:false, nullable: false)
        jornalerosTemporales   (blank:false, nullable: false)
        organizacion           (blank:false, nullable: false)
        plan                   (blank:false, nullable: false)
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
        idDispositivo            (blank:false, nullable: false)
    }

    String toString() {
        "${this.id}: ${this.nombre} ${this.comunidad}"
    }

}
