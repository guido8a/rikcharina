package pdf

import geografia.Canton
import geografia.Provincia
import jxl.WorkbookSettings
import jxl.format.Border
import jxl.format.BorderLineStyle
import jxl.format.Colour
import jxl.write.Label
import jxl.write.WritableCellFormat
import jxl.write.WritableFont
import jxl.write.WritableSheet
import jxl.write.WritableWorkbook
import org.apache.poi.hssf.usermodel.HSSFClientAnchor
import org.apache.poi.hssf.usermodel.HSSFPatriarch
import org.apache.poi.hssf.usermodel.HSSFSimpleShape
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.ConditionalFormattingRule
import org.apache.poi.ss.usermodel.CreationHelper
import org.apache.poi.ss.usermodel.Drawing
import org.apache.poi.ss.usermodel.SheetConditionalFormatting
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFClientAnchor
import org.apache.poi.xssf.usermodel.XSSFDrawing
import org.apache.poi.xssf.usermodel.XSSFSimpleShape

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*
import rikcharina.AreaProduccion
import rikcharina.Cargo
import rikcharina.Cultivos
import rikcharina.Finca
import rikcharina.FincaCapacitacion
import rikcharina.FincaCargo
import rikcharina.Forestal
import rikcharina.ManejoAnimal
import rikcharina.ManejoEnfermedades
import rikcharina.ManejoEquipo
import rikcharina.ManejoPlagas
import rikcharina.ObrasFinca
import rikcharina.TrabajoFamiliar;


class ReportesController {

    def reportes(){

    }


    def circulo () {

//        Workbook wb = new HSSFWorkbook()
//        OutputStream os = new FileOutputStream("Javatpoint.xls")
//        Sheet sheet = wb.createSheet("Sheet");
//        Row row = sheet.createRow(4); // Creating a row
//        Cell cell = row.createCell(1); // Creating a cell
//        HSSFPatriarch patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();
//        HSSFClientAnchor  a = new HSSFClientAnchor( 0, 0, 1023, 255, (short) 1, 0, (short) 1, 0 );
//        HSSFSimpleShape shape = patriarch.createSimpleShape(a);
//        shape.setShapeType(HSSFSimpleShape.OBJECT_TYPE_OVAL);
//                wb.write(os);



        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data Validation");
        HSSFPatriarch patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();
        HSSFClientAnchor a = new HSSFClientAnchor( 0, 0, 1023, 255, (short) 1, 0, (short) 2, 1 );
        HSSFSimpleShape shape1 = patriarch.createSimpleShape(a);
        shape1.setShapeType(HSSFSimpleShape.OBJECT_TYPE_OVAL);
        shape1.setLineStyleColor(10,10,10);
        shape1.setFillColor(90,10,200);
//            shape1.setLineWidth(HSSFShape.LINEWIDTH_ONE_PT * 3);
//            shape1.setLineStyle(HSSFShape.LINESTYLE_DOTSYS);
        FileOutputStream fileOut = new FileOutputStream("XLDrawingShape.xls");
        try {
            workbook.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    def reporteFincaExcel(){

        def fincas = Finca.list().sort{it.nombre}

        //excel
        WorkbookSettings workbookSettings = new WorkbookSettings()
        workbookSettings.locale = Locale.default

        def file = File.createTempFile('myExcelDocument', '.xls')
        file.deleteOnExit()

        WritableWorkbook workbook = jxl.Workbook.createWorkbook(file, workbookSettings)
        WritableFont font = new WritableFont(WritableFont.ARIAL, 12)
        WritableCellFormat formatXls = new WritableCellFormat(font)

        def row = 0
        WritableSheet sheet = workbook.createSheet('finca', 0)
        WritableSheet sheet2 = workbook.createSheet('areasProduccion', 1)
        WritableSheet sheet3 = workbook.createSheet('trabajoFamiliar', 2)
        WritableSheet sheet4 = workbook.createSheet('manejoCultivos', 3)
        WritableSheet sheet5 = workbook.createSheet('manejoEnfermedades', 4)
        WritableSheet sheet6 = workbook.createSheet('controlPlagas', 5)
        WritableSheet sheet7 = workbook.createSheet('manejoForestal', 6)
        WritableSheet sheet8 = workbook.createSheet('manejoAnimales', 7)
        WritableSheet sheet9 = workbook.createSheet('cargos', 8)
        WritableSheet sheet10 = workbook.createSheet('obras', 9)
        WritableSheet sheet11 = workbook.createSheet('infraestructura', 10)
        WritableSheet sheet12 = workbook.createSheet('capacitacion', 11)
//        sheet.setRowView(4,34)


        //DATOS FINCA

        // fija el ancho de la columna
        sheet.setColumnView(0,30)
        sheet.setColumnView(1,30)
        sheet.setColumnView(2,30)
        sheet.setColumnView(3,30)
        sheet.setColumnView(4,30)
        sheet.setColumnView(5,30)
        sheet.setColumnView(6,30)
        sheet.setColumnView(7,30)
        sheet.setColumnView(8,30)
        sheet.setColumnView(9,30)
        sheet.setColumnView(10,30)
        sheet.setColumnView(11,30)
        sheet.setColumnView(12,30)
        sheet.setColumnView(13,30)
        sheet.setColumnView(14,30)
        sheet.setColumnView(15,30)
        sheet.setColumnView(16,30)
        sheet.setColumnView(17,30)
        sheet.setColumnView(18,30)
        sheet.setColumnView(19,30)
        sheet.setColumnView(20,30)
        sheet.setColumnView(21,30)
        sheet.setColumnView(22,30)
        sheet.setColumnView(23,30)
        sheet.setColumnView(24,30)
        sheet.setColumnView(25,30)
        sheet.setColumnView(26,30)
        sheet.setColumnView(27,30)
        sheet.setColumnView(28,30)
        sheet.setColumnView(29,30)
        sheet.setColumnView(30,30)
        sheet.setColumnView(31,30)
        sheet.setColumnView(32,30)
        sheet.setColumnView(33,30)
        sheet.setColumnView(34,30)
        sheet.setColumnView(35,30)
        sheet.setColumnView(36,30)
        sheet.setColumnView(37,30)
        sheet.setColumnView(38,30)
        sheet.setColumnView(39,30)
        sheet.setColumnView(40,30)
        sheet.setColumnView(41,30)
        sheet.setColumnView(42,30)
        sheet.setColumnView(43,30)
        sheet.setColumnView(44,30)
        sheet.setColumnView(45,30)
        sheet.setColumnView(46,30)
        sheet.setColumnView(47,30)
        sheet.setColumnView(48,30)
        sheet.setColumnView(49,30)
        sheet.setColumnView(50,30)
        sheet.setColumnView(51,30)
        sheet.setColumnView(52,30)

        WritableFont times16font = new WritableFont(WritableFont.TIMES, 11, WritableFont.BOLD, false);
        WritableFont times16fontNormal = new WritableFont(WritableFont.TIMES, 11, WritableFont.NO_BOLD, false);
        WritableCellFormat times16format = new WritableCellFormat(times16font);
        WritableCellFormat times16Normal = new WritableCellFormat(times16fontNormal);

//        autoSizeColumns(sheet, 10)

        def label
        def number
        def fila = 4;

        label = new Label(0, 1, "DATOS DE LA FINCA", times16format); sheet.addCell(label);
        label = new Label(0, 2, "", times16format); sheet.addCell(label);
        label = new Label(0, 3, "NOMBRE", times16format); sheet.addCell(label);
        label = new Label(1, 3, "CANTÓN", times16format); sheet.addCell(label);
        label = new Label(2, 3, "PARROQUIA", times16format); sheet.addCell(label);
        label = new Label(3, 3, "COMUNIDAD", times16format); sheet.addCell(label);
        label = new Label(4, 3, "ORGANIZACIÓN", times16format); sheet.addCell(label);
        label = new Label(5, 3, "INSTITUCIÓN DE APOYO", times16format); sheet.addCell(label);
        label = new Label(6, 3, "FECHA", times16format); sheet.addCell(label);
        label = new Label(7, 3, "PROPIETARIO", times16format); sheet.addCell(label);
        label = new Label(8, 3, "DELEGADO", times16format); sheet.addCell(label);
        label = new Label(9, 3, "PROMOTOR", times16format); sheet.addCell(label);
        label = new Label(10, 3, "DIRECCIÓN", times16format); sheet.addCell(label);
        label = new Label(11, 3, "ALTITUD", times16format); sheet.addCell(label);
        label = new Label(12, 3, "LONGITUD", times16format); sheet.addCell(label);
        label = new Label(13, 3, "LATITUD", times16format); sheet.addCell(label);
        label = new Label(14, 3, "ZONA", times16format); sheet.addCell(label);
        label = new Label(15, 3, "PLAN DE MANEJO", times16format); sheet.addCell(label);
        label = new Label(16, 3, "ACTIVIDAD AGRICOLA (%)", times16format); sheet.addCell(label);
        label = new Label(17, 3, "ACTIVIDAD PECUARIA (%)", times16format); sheet.addCell(label);
        label = new Label(18, 3, "JORNALEROS PERMANENTES", times16format); sheet.addCell(label);
        label = new Label(19, 3, "JORNALEROS TEMPORALES", times16format); sheet.addCell(label);
        label = new Label(20, 3, "ENTREVISTADOR", times16format); sheet.addCell(label);
        label = new Label(21, 2, "MANEJO DE SUELOS", times16format); sheet.addCell(label);
        label = new Label(21, 3, "PREPARACIÓN DEL SUELO", times16format); sheet.addCell(label);
        label = new Label(22, 3, "FERTILIZACIÓN DEL SUELO", times16format); sheet.addCell(label);
        label = new Label(23, 3, "FERTILIZACIÓN COMPLEMENTARIA", times16format); sheet.addCell(label);
        label = new Label(24, 3, "MANEJO DE RASTROJOS", times16format); sheet.addCell(label);
        label = new Label(25, 2, "MANEJO DE CULTIVOS", times16format); sheet.addCell(label);
        label = new Label(25, 3, "HACE ASOCIACIÓN DE CULTIVOS", times16format); sheet.addCell(label);
        label = new Label(26, 3, "HACE ROTACIÓN DE CULTIVOS", times16format); sheet.addCell(label);
        label = new Label(27, 3, "HACE SELECCIÓN DE SEMILLAS", times16format); sheet.addCell(label);
        label = new Label(28, 3, "USA SEMILLAS PROPIAS", times16format); sheet.addCell(label);
        label = new Label(29, 3, "USA SEMILLAS COMPRADAS", times16format); sheet.addCell(label);
        label = new Label(30, 3, "USA SEMILLAS DE INTERCAMBIO", times16format); sheet.addCell(label);
        label = new Label(31, 3, "REALIZA CALENDARIZACIÓN DE CULTIVOS", times16format); sheet.addCell(label);
        label = new Label(32, 3, "ÁREA DE INVERNADERO (M2)", times16format); sheet.addCell(label);
        label = new Label(33, 2, "MANEJO DEL AGUA", times16format); sheet.addCell(label);
        label = new Label(34, 3, "TIENE AGUA DE  RIEGO", times16format); sheet.addCell(label);
        label = new Label(35, 3, "PERTENECE A JUNTA RIEGO", times16format); sheet.addCell(label);
        label = new Label(36, 3, "FUENTE DE AGUA", times16format); sheet.addCell(label);
        label = new Label(37, 3, "INFR. DE RIEGO", times16format); sheet.addCell(label);
        label = new Label(38, 2, "MANEJO FORESTAL", times16format); sheet.addCell(label);
        label = new Label(38, 3, "ESPECIES FORESTALES", times16format); sheet.addCell(label);
        label = new Label(39, 3, "PÁRAMO O MONTE", times16format); sheet.addCell(label);
        label = new Label(40, 2, "MANEJO DE ANIMALES", times16format); sheet.addCell(label);
        label = new Label(40, 3, "FINCA PASTO", times16format); sheet.addCell(label);
        label = new Label(41, 3, "ABONA PASTOS CON", times16format); sheet.addCell(label);
        label = new Label(42, 3, "MANEJO DE PASTOS", times16format); sheet.addCell(label);
        label = new Label(43, 3, "INSALACIONES", times16format); sheet.addCell(label);
        label = new Label(44, 3, "SANITARIO", times16format); sheet.addCell(label);
        label = new Label(45, 3, "USA PRÁCTICAS ANCESTRALES", times16format); sheet.addCell(label);
        label = new Label(46, 2, "MANEJO DE BASURA", times16format); sheet.addCell(label);
//        label = new Label(46, 3, "QUE HACE CON LOS PLASTICOS, VIDRIOS, CAUCHOS Y LATAS", times16format); sheet.addCell(label);
        label = new Label(47, 3, "AUTOCONSUMO %", times16format); sheet.addCell(label);
        label = new Label(48, 3, "VENTA %", times16format); sheet.addCell(label);
        label = new Label(49, 3, "DONDE VENDE", times16format); sheet.addCell(label);
        label = new Label(50, 3, "CADA QUE TIEMPO VENDE", times16format); sheet.addCell(label);
        label = new Label(51, 2, "PARTICIPACIÓN", times16format); sheet.addCell(label);
        label = new Label(52, 3, "MIEMBRO ACTIVO DE ORGANIZACIÓN", times16format); sheet.addCell(label);
        label = new Label(53, 2, "CRITERIO DEL PROMOTOR", times16format); sheet.addCell(label);
        label = new Label(54, 3, "LA FINCA SE CONSIDERA", times16format); sheet.addCell(label);


        fincas.each { f ->

            label = new Label(0, fila, (f?.nombre ? f?.nombre : ''), times16Normal); sheet.addCell(label);
            label = new Label(1, fila, (f?.parroquia?.canton?.nombre ? f?.parroquia?.canton?.nombre : ''), times16Normal); sheet.addCell(label);
            label = new Label(2, fila, (f?.parroquia?.nombre ? f?.parroquia?.nombre : ''), times16Normal); sheet.addCell(label);
            label = new Label(3, fila, (f?.comunidad ? f?.comunidad : ''), times16Normal); sheet.addCell(label);
            label = new Label(4, fila, (f?.organizacion ? f?.organizacion : ''), times16Normal); sheet.addCell(label);
            label = new Label(5, fila, (f?.institucion?.nombre ? f?.institucion?.nombre : ''), times16Normal); sheet.addCell(label);
            label = new Label(6, fila, (f?.fecha ? f?.fecha?.format("dd-MM-yyyy") : ''), times16Normal); sheet.addCell(label);
            label = new Label(7, fila, (f?.propietario ? f?.propietario : ''), times16Normal); sheet.addCell(label);
            label = new Label(8, fila, (f?.delegado ? f?.delegado : ''), times16Normal); sheet.addCell(label);
            label = new Label(9, fila, (f?.promotor ? f?.promotor : ''), times16Normal); sheet.addCell(label);
            label = new Label(10, fila, (f?.direccion ? f?.direccion : ''), times16Normal); sheet.addCell(label);
            number = new jxl.write.Number(11, fila, f?.altura ? f?.altura : 0); sheet.addCell(number);
            number = new jxl.write.Number(12, fila, f?.longitud ? f?.longitud : 0); sheet.addCell(number);
            number = new jxl.write.Number(13, fila, f?.latitud ? f?.latitud : 0); sheet.addCell(number);
            label = new Label(14, fila, (f?.zona ? f?.zona : ''), times16Normal); sheet.addCell(label);
            label = new Label(15, fila, (f?.plan ? f?.plan : ''), times16Normal); sheet.addCell(label);
            number = new jxl.write.Number(16, fila, f?.actvAgricola ? f?.actvAgricola : 0); sheet.addCell(number);
            number = new jxl.write.Number(17, fila, f?.actvPecuaria ? f?.actvPecuaria : 0); sheet.addCell(number);
            number = new jxl.write.Number(18, fila, f?.jornalerosPermanentes ? f?.jornalerosPermanentes : 0); sheet.addCell(number);
            number = new jxl.write.Number(19, fila, f?.jornalerosTemporales ? f?.jornalerosTemporales : 0); sheet.addCell(number);
            label = new Label(20, fila, (f?.entrevista ? f?.entrevista : ''), times16Normal); sheet.addCell(label);
            label = new Label(21, fila, (f?.preparacionSuelo ? f?.preparacionSuelo : ''), times16Normal); sheet.addCell(label);
            label = new Label(22, fila, (f?.fertilizantes ? f?.fertilizantes : ''), times16Normal); sheet.addCell(label);
            label = new Label(23, fila, (f?.fertilizacionComplementaria ? f?.fertilizacionComplementaria : ''), times16Normal); sheet.addCell(label);
            label = new Label(24, fila, (f?.manejoRastrojos ? f?.manejoRastrojos : ''), times16Normal); sheet.addCell(label);
            label = new Label(25, fila, (f?.asociacionCultivos ? f?.asociacionCultivos : ''), times16Normal); sheet.addCell(label);
            label = new Label(26, fila, (f?.rotacionCultivos ? f?.rotacionCultivos : ''), times16Normal); sheet.addCell(label);
            label = new Label(27, fila, (f?.seleccionSemillas ? f?.seleccionSemillas : ''), times16Normal); sheet.addCell(label);
            label = new Label(28, fila, (f?.semillaPropia ? f?.semillaPropia : ''), times16Normal); sheet.addCell(label);
            label = new Label(29, fila, (f?.semillaComprada ? f?.semillaComprada : ''), times16Normal); sheet.addCell(label);
            label = new Label(30, fila, (f?.semillaIntercambio ? f?.semillaIntercambio : ''), times16Normal); sheet.addCell(label);
            label = new Label(31, fila, (f?.calendarizacion ? f?.calendarizacion : ''), times16Normal); sheet.addCell(label);
//            label = new Label(32, fila, (f?.invernadero ? f?.invernadero : ''), times16Normal); sheet.addCell(label);
            number = new jxl.write.Number(32, fila, f?.invernadero ? f?.invernadero : 0); sheet.addCell(number);
            label = new Label(33, fila, (f?.preparacionSuelo ? f?.preparacionSuelo : ''), times16Normal); sheet.addCell(label);
            label = new Label(34, fila, (f?.fertilizantes ? f?.fertilizantes : ''), times16Normal); sheet.addCell(label);
            label = new Label(35, fila, (f?.fertilizacionComplementaria ? f?.fertilizacionComplementaria : ''), times16Normal); sheet.addCell(label);
            label = new Label(36, fila, (f?.manejoRastrojos ? f?.manejoRastrojos : ''), times16Normal); sheet.addCell(label);
            label = new Label(37, fila, (f?.aguaRiego ? f?.aguaRiego : ''), times16Normal); sheet.addCell(label);
            label = new Label(38, fila, (f?.juntaAgua ? f?.juntaAgua : ''), times16Normal); sheet.addCell(label);
            label = new Label(39, fila, (f?.aguaFuente ? f?.aguaFuente : ''), times16Normal); sheet.addCell(label);
            label = new Label(40, fila, (f?.aguaInfraestructura ? f?.aguaInfraestructura : ''), times16Normal); sheet.addCell(label);
            label = new Label(41, fila, (f?.forestal ? f?.forestal : ''), times16Normal); sheet.addCell(label);
            label = new Label(42, fila, (f?.monte ? f?.monte : ''), times16Normal); sheet.addCell(label);
            label = new Label(43, fila, (f?.pasto ? f?.pasto : ''), times16Normal); sheet.addCell(label);
            label = new Label(44, fila, (f?.pastoAbono ? f?.pastoAbono : ''), times16Normal); sheet.addCell(label);
            label = new Label(45, fila, (f?.manejoPasto ? f?.manejoPasto : ''), times16Normal); sheet.addCell(label);
            label = new Label(45, fila, (f?.instalaciones ? f?.instalaciones : ''), times16Normal); sheet.addCell(label);
            label = new Label(46, fila, (f?.sanitario ? f?.sanitario : ''), times16Normal); sheet.addCell(label);
            label = new Label(47, fila, (f?.ancestrales ? f?.ancestrales : ''), times16Normal); sheet.addCell(label);
            label = new Label(48, fila, (f?.basura ? f?.basura : ''), times16Normal); sheet.addCell(label);
            number = new jxl.write.Number(49, fila, f?.autoconsumo ? f?.autoconsumo : 0); sheet.addCell(number);
            number = new jxl.write.Number(50, fila, f?.venta ? f?.venta : 0); sheet.addCell(number);
            label = new Label(51, fila, (f?.lugarVenta ? f?.lugarVenta : ''), times16Normal); sheet.addCell(label);
            label = new Label(52, fila, (f?.fecuencia ? f?.fecuencia : ''), times16Normal); sheet.addCell(label);
            label = new Label(53, fila, (f?.estaoOrganizacion ? f?.estaoOrganizacion : ''), times16Normal); sheet.addCell(label);
            label = new Label(54, fila, (f?.calificacion ? f?.calificacion : ''), times16Normal); sheet.addCell(label);
            fila++
        }

        //areas de produccion

        sheet2.setColumnView(0,30)
        sheet2.setColumnView(1,30)
        sheet2.setColumnView(2,30)
        sheet2.setColumnView(3,30)
        sheet2.setColumnView(4,30)
        sheet2.setColumnView(5,30)
        sheet2.setColumnView(6,30)

        def labelArea
        def numberArea
        def filaArea = 4

        labelArea = new Label(0, 1, "ÁREAS DE PRODUCCIÓN", times16format); sheet2.addCell(labelArea);
        labelArea = new Label(0, 2, "", times16format); sheet2.addCell(labelArea);
        labelArea = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet2.addCell(labelArea);
        labelArea = new Label(1, 3, "TIPO DE LOTE", times16format); sheet2.addCell(labelArea);
        labelArea = new Label(2, 3, "REFERENCIA", times16format); sheet2.addCell(labelArea);
        labelArea = new Label(3, 3, "ÁREA (%)", times16format); sheet2.addCell(labelArea);
        labelArea = new Label(4, 3, "USO AGRÍCOLA (%)", times16format); sheet2.addCell(labelArea);
        labelArea = new Label(5, 3, "USO PECUARIO (%)", times16format); sheet2.addCell(labelArea);
        labelArea = new Label(6, 3, "PENDIENTE (%)", times16format); sheet2.addCell(labelArea);

        fincas.each { f2->
            def areas = AreaProduccion.findAllByFinca(f2)

            areas.each {a->
                labelArea = new Label(0, filaArea, (a?.finca?.nombre ? a?.finca?.nombre : ''), times16Normal); sheet2.addCell(labelArea);
                labelArea = new Label(1, filaArea, (a?.tipoLote?.descripcion ? a?.tipoLote?.descripcion : ''), times16Normal); sheet2.addCell(labelArea);
                labelArea = new Label(2, filaArea, (a?.referencia ? a?.referencia : ''), times16Normal); sheet2.addCell(labelArea);
                numberArea = new jxl.write.Number(3, filaArea, a?.area ? a?.area : 0); sheet2.addCell(numberArea);
                numberArea = new jxl.write.Number(4, filaArea, a?.usoAgricola ? a?.usoAgricola : 0); sheet2.addCell(numberArea);
                numberArea = new jxl.write.Number(5, filaArea, a?.usoPecuario ? a?.usoPecuario : 0); sheet2.addCell(numberArea);
                numberArea = new jxl.write.Number(6, filaArea, a?.pendiente ? a?.pendiente : 0); sheet2.addCell(numberArea);
                filaArea++
            }
        }

        //trabajo familiar

        sheet3.setColumnView(0,30)
        sheet3.setColumnView(1,30)
        sheet3.setColumnView(2,30)
        sheet3.setColumnView(3,30)
        sheet3.setColumnView(4,30)
        sheet3.setColumnView(5,30)
        sheet3.setColumnView(6,30)

        def label3
        def number3
        def fila3 = 4

        label3 = new Label(0, 1, "TRABAJO FAMILIAR", times16format); sheet3.addCell(label3);
        label3 = new Label(0, 2, "", times16format); sheet3.addCell(label3);
        label3 = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet3.addCell(label3);
        label3 = new Label(1, 3, "FAMILIAR", times16format); sheet3.addCell(label3);
        label3 = new Label(2, 3, "NÚMERO", times16format); sheet3.addCell(label3);
        label3 = new Label(3, 3, "ACTIVIDAD", times16format); sheet3.addCell(label3);
        label3 = new Label(4, 3, "TIPO", times16format); sheet3.addCell(label3);

        fincas.each { f3->
            def trabajos = TrabajoFamiliar.findAllByFinca(f3)

            trabajos.each {t->
                label3 = new Label(0, fila3, (t?.finca?.nombre ? t?.finca?.nombre : ''), times16Normal); sheet3.addCell(label3);
                label3 = new Label(1, fila3, (t?.familia?.descripcion ? t?.familia?.descripcion : ''), times16Normal); sheet3.addCell(label3);
                number3 = new jxl.write.Number(2, fila3, t?.numero ? t?.numero : 0); sheet3.addCell(number3);
                label3 = new Label(3, fila3, (t?.actividad ? t?.actividad : ''), times16Normal); sheet3.addCell(label3);
                label3 = new Label(4, fila3, (t?.tipo ? t?.tipo : ''), times16Normal); sheet3.addCell(label3);
                fila3++
            }
        }

        //manejo de cultivos

        sheet4.setColumnView(0,30)
        sheet4.setColumnView(1,30)
        sheet4.setColumnView(2,30)


        def label4
        def number4
        def fila4 = 4

        label4 = new Label(0, 1, "MANEJO DE CULTIVOS", times16format); sheet4.addCell(label4);
        label4 = new Label(0, 2, "", times16format); sheet4.addCell(label4);
        label4 = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet4.addCell(label4);
        label4 = new Label(1, 3, "CULTIVO", times16format); sheet4.addCell(label4);
        label4 = new Label(2, 3, "ÁREA (M2)", times16format); sheet4.addCell(label4);

        fincas.each { f3->
            def cultivos = Cultivos.findAllByFinca(f3)

            cultivos.each {c->
                label4 = new Label(0, fila4, (c?.finca?.nombre ? c?.finca?.nombre : ''), times16Normal); sheet4.addCell(label4);
                label4 = new Label(1, fila4, (c?.planta?.descripcion ? c?.planta?.descripcion  : ''), times16Normal); sheet4.addCell(label4);
                number4 = new jxl.write.Number(2, fila4, c?.area ? c?.area : 0); sheet4.addCell(number4);
                fila4++
            }
        }

        //MANEJO DE ENFERMEDADES

        sheet5.setColumnView(0,30)
        sheet5.setColumnView(1,30)

        def label5
        def fila5 = 4

        label5 = new Label(0, 1, "MANEJO DE CULTIVOS", times16format); sheet5.addCell(label5);
        label5 = new Label(0, 2, "", times16format); sheet5.addCell(label5);
        label5 = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet5.addCell(label5);
        label5 = new Label(1, 3, "ENFERMEDAD", times16format); sheet5.addCell(label5);

        fincas.each { f5->
            def enfermedades = ManejoEnfermedades.findAllByFinca(f5)

            enfermedades.each {e->
                label5 = new Label(0, fila5, (e?.finca?.nombre ? e?.finca?.nombre : ''), times16Normal); sheet5.addCell(label5);
                label5 = new Label(1, fila5, (e?.enfermedad?.descripcion ? e?.enfermedad?.descripcion  : ''), times16Normal); sheet5.addCell(label5);
                fila5++
            }
        }

        //CONTROL DE PLAGAS

        sheet6.setColumnView(0,30)
        sheet6.setColumnView(1,30)

        def label6
        def fila6 = 4

        label6 = new Label(0, 1, "MANEJO DE PLAGAS", times16format); sheet6.addCell(label6);
        label6 = new Label(0, 2, "", times16format); sheet6.addCell(label6);
        label6 = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet6.addCell(label6);
        label6 = new Label(1, 3, "PLAGA", times16format); sheet6.addCell(label6);

        fincas.each { f6->
            def plagas = ManejoPlagas.findAllByFinca(f6)

            plagas.each {e->
                label6 = new Label(0, fila6, (e?.finca?.nombre ? e?.finca?.nombre : ''), times16Normal); sheet6.addCell(label6);
                label6 = new Label(1, fila6, (e?.plaga?.descripcion ? e?.plaga?.descripcion  : ''), times16Normal); sheet6.addCell(label6);
                fila6++
            }
        }

        //MANEJO FORESTAL

        sheet7.setColumnView(0,30)
        sheet7.setColumnView(1,30)

        def label7
        def fila7 = 4

        label7 = new Label(0, 1, "MANEJO FORESTAL", times16format); sheet7.addCell(label7);
        label7 = new Label(0, 2, "", times16format); sheet7.addCell(label7);
        label7 = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet7.addCell(label7);
        label7 = new Label(1, 3, "SIEMBRA", times16format); sheet7.addCell(label7);

        fincas.each { f7->
            def siembras = Forestal.findAllByFinca(f7)

            siembras.each {s->
                label7 = new Label(0, fila7, (s?.finca?.nombre ? s?.finca?.nombre : ''), times16Normal); sheet7.addCell(label7);
                label7 = new Label(1, fila7, (s?.siembra?.descripcion ? s?.siembra?.descripcion : ''), times16Normal); sheet7.addCell(label7);
                fila7++
            }
        }

        //MANEJO DE ANIMALES

        sheet8.setColumnView(0,30)
        sheet8.setColumnView(1,30)
        sheet8.setColumnView(2,30)

        def label8
        def number8
        def fila8 = 4

        label8 = new Label(0, 1, "MANEJO DE ANIMALES", times16format); sheet8.addCell(label8);
        label8 = new Label(0, 2, "", times16format); sheet8.addCell(label8);
        label8 = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet8.addCell(label8);
        label8 = new Label(1, 3, "ANIMAL", times16format); sheet8.addCell(label8);
        label8 = new Label(2, 3, "CANTIDAD", times16format); sheet8.addCell(label8);

        fincas.each { f8->
            def animales = ManejoAnimal.findAllByFinca(f8)

            animales.each {c->
                label8 = new Label(0, fila8, (c?.finca?.nombre ? c?.finca?.nombre : ''), times16Normal); sheet8.addCell(label8);
                label8 = new Label(1, fila8, (c?.animal?.descripcion ? c?.animal?.descripcion  : ''), times16Normal); sheet8.addCell(label8);
                number8 = new jxl.write.Number(2, fila8, c?.numero ? c?.numero : 0); sheet8.addCell(number8);
                fila8++
            }
        }

        //CARGOS

        sheet9.setColumnView(0,30)
        sheet9.setColumnView(1,30)

        def label9
        def fila9 = 4

        label9 = new Label(0, 1, "CARGOS", times16format); sheet9.addCell(label9);
        label9 = new Label(0, 2, "", times16format); sheet9.addCell(label9);
        label9 = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet9.addCell(label9);
        label9 = new Label(1, 3, "CARGO", times16format); sheet9.addCell(label9);

        fincas.each { f7->
            def cargos = FincaCargo.findAllByFinca(f7)

            cargos.each {s->
                label9 = new Label(0, fila9, (s?.finca?.nombre ? s?.finca?.nombre : ''), times16Normal); sheet9.addCell(label9);
                label9 = new Label(1, fila9, (s?.cargo?.descripcion ? s?.cargo?.descripcion : ''), times16Normal); sheet9.addCell(label9);
                fila9++
            }
        }

        //OBRAS DE LA FINCA

        sheet10.setColumnView(0,30)
        sheet10.setColumnView(1,30)
        sheet10.setColumnView(2,30)

        def label10
        def fila10 = 4

        label10 = new Label(0, 1, "OBRAS DE LA FINCA", times16format); sheet10.addCell(label10);
        label10 = new Label(0, 2, "", times16format); sheet10.addCell(label10);
        label10 = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet10.addCell(label10);
        label10 = new Label(1, 3, "OBRA", times16format); sheet10.addCell(label10);
        label10 = new Label(2, 3, "ESTADO", times16format); sheet10.addCell(label10);

        fincas.each { f7->
            def obras = ObrasFinca.findAllByFinca(f7)

            obras.each {s->
                label10 = new Label(0, fila10, (s?.finca?.nombre ? s?.finca?.nombre : ''), times16Normal); sheet10.addCell(label10);
                label10 = new Label(1, fila10, (s?.tipoObra?.descripcion ? s?.tipoObra?.descripcion : ''), times16Normal); sheet10.addCell(label10);
                label10 = new Label(2, fila10, (s?.estado ? (s?.estado == 'I' ? 'Iniciado' : (s?.estado == 'A' ? 'Avanzado' : 'Terminado')) : ''), times16Normal); sheet10.addCell(label10);
                fila10++
            }
        }

        //INFRAESTRUCTURA

        sheet11.setColumnView(0,30)
        sheet11.setColumnView(1,30)

        def label11
        def fila11 = 4

        label11 = new Label(0, 1, "INFRAESTRUCTURA", times16format); sheet11.addCell(label11);
        label11 = new Label(0, 2, "", times16format); sheet11.addCell(label11);
        label11 = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet11.addCell(label11);
        label11 = new Label(1, 3, "INFRAESTRUCTURA", times16format); sheet11.addCell(label11);

        fincas.each { f7->
            def equipos = ManejoEquipo.findAllByFinca(f7)

            equipos.each {s->
                label11 = new Label(0, fila11, (s?.finca?.nombre ? s?.finca?.nombre : ''), times16Normal); sheet11.addCell(label11);
                label11 = new Label(1, fila11, (s?.equipo?.descripcion ? s?.equipo?.descripcion : ''), times16Normal); sheet11.addCell(label11);
                fila11++
            }
        }

        //CAPACITACION

        sheet12.setColumnView(0,30)
        sheet12.setColumnView(1,30)

        def label12
        def fila12 = 4

        label12 = new Label(0, 1, "CAPACITACIÓN", times16format); sheet12.addCell(label12);
        label12 = new Label(0, 2, "", times16format); sheet12.addCell(label12);
        label12 = new Label(0, 3, "NOMBRE DE LA FINCA", times16format); sheet12.addCell(label12);
        label12 = new Label(1, 3, "CURSOS DE CAPACITACIÓN", times16format); sheet12.addCell(label12);

        fincas.each { f7->
            def capacitaciones = FincaCapacitacion.findAllByFinca(f7)

            capacitaciones.each {s->
                label12 = new Label(0, fila12, (s?.finca?.nombre ? s?.finca?.nombre : ''), times16Normal); sheet12.addCell(label12);
                label12 = new Label(1, fila12, (s?.capacitacion?.descripcion ? s?.capacitacion?.descripcion : ''), times16Normal); sheet12.addCell(label12);
                fila12++
            }
        }

        workbook.write();
        workbook.close();
        def output = response.getOutputStream()
        def header = "attachment; filename=" + "reporteFincaExcel_" + new Date().format("dd-MM-yyyy") + ".xls";
        response.setContentType("application/octet-stream")
        response.setHeader("Content-Disposition", header);
        output.write(file.getBytes());
    }
}
