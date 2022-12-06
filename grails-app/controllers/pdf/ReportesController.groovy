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
import rikcharina.Finca;


class ReportesController {

    def semaforoExcel(){



        //excel
        WorkbookSettings workbookSettings = new WorkbookSettings()
        workbookSettings.locale = Locale.default

        def file = File.createTempFile('myExcelDocument', '.xls')
        file.deleteOnExit()

        WritableWorkbook workbook = jxl.Workbook.createWorkbook(file, workbookSettings)
        WritableFont font = new WritableFont(WritableFont.ARIAL, 12)
        WritableCellFormat formatXls = new WritableCellFormat(font)

        def row = 0
        WritableSheet sheet = workbook.createSheet('MySheet', 0)


        // fija el ancho de la columna
        sheet.setColumnView(0,5)
        sheet.setColumnView(1,20)
        sheet.setColumnView(2,30)
        sheet.setColumnView(3,15)
        sheet.setColumnView(4,15)
//        sheet.setColumnView(5,15)

        WritableFont times16font = new WritableFont(WritableFont.TIMES, 11, WritableFont.BOLD, false);
        times16font.setColour(Colour.WHITE);
        WritableFont times16fontNormal = new WritableFont(WritableFont.TIMES, 11, WritableFont.NO_BOLD, false);
//        WritableCellFormat times16format = new WritableCellFormat(times16font);
        WritableCellFormat times16formatN = new WritableCellFormat(times16fontNormal);

        WritableCellFormat times16format = new WritableCellFormat(times16font);
        times16format.setBackground(Colour.BLUE_GREY);
        times16format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.GRAY_50);


        WritableCellFormat rojo = new WritableCellFormat(times16fontNormal);
        rojo.setBackground(Colour.DARK_RED);
        WritableCellFormat amarillo = new WritableCellFormat(times16fontNormal);
        amarillo.setBackground(Colour.VERY_LIGHT_YELLOW);
        WritableCellFormat verde = new WritableCellFormat(times16fontNormal);
        verde.setBackground(Colour.DARK_GREEN);

        def label
        def fila = 5;

        label = new Label(2, 2, "REPORTE SEMÁFOROS", times16formatN); sheet.addCell(label);
        label = new Label(1, 3, "", times16formatN); sheet.addCell(label);
        label = new Label(0, 4, "", times16formatN); sheet.addCell(label);
        label = new Label(1, 4, "PROVINCIA", times16format); sheet.addCell(label);
        label = new Label(2, 4, "CANTON", times16format); sheet.addCell(label);
        label = new Label(3, 4, "SEMÁFORO", times16format); sheet.addCell(label);

        def periodos = Periodo.list().sort{it.fechaDesde}

        periodos.eachWithIndex{periodo,i->
            label = new Label(4, 4, periodos.last().fechaDesde?.format("dd-MM-yyyy")?.toString(), times16format); sheet.addCell(label);
            sheet.setColumnView(5+i,12)
            label = new Label(5 + i, 4, periodo?.fechaDesde?.format("dd-MM-yyyy")?.toString(), times16format); sheet.addCell(label);
        }

        def cantones = Canton.list().sort{it.provincia.nombre}

        cantones.eachWithIndex { Canton canton, int i ->
            label = new Label(1, fila,  canton.provincia.nombre.toString(), times16formatN); sheet.addCell(label);
            label = new Label(2, fila,  canton.nombre.toString(), times16formatN); sheet.addCell(label);
            def semaforos = Semaforo.findAllByCanton(canton).sort{it.periodo.fechaDesde}
            semaforos.eachWithIndex {semaforo, j->
                label = new Label(3, fila,  semaforos.last().color?.toString() == '3' ? 'ROJO' : semaforos.last().color?.toString() == '2' ? 'AMARILLO' :'VERDE', times16formatN); sheet.addCell(label);
                label = new Label(4, fila,  semaforos.last()?.color?.toString(), times16formatN); sheet.addCell(label);
                if(semaforo.color?.toString() == '3'){
                    label = new Label(5+j, fila,  semaforo.color?.toString(), rojo); sheet.addCell(label);
                }else{
                    if(semaforo.color?.toString() == '2'){
                        label = new Label(5+j, fila,  semaforo.color?.toString(), amarillo); sheet.addCell(label);
                    }else{
                        label = new Label(5+j, fila,  semaforo.color?.toString(), verde); sheet.addCell(label);
                    }
                }

            }
            fila++
        }
        workbook.write();
        workbook.close();
//        workbook1.write();
//        workbook1.close();
        def output = response.getOutputStream()
        def header = "attachment; filename=" + "reporteSemaforos_" + new Date().format("dd-MM-yyyy") + ".xls";
        response.setContentType("application/octet-stream")
        response.setHeader("Content-Disposition", header);
        output.write(file.getBytes());
    }

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
        label = new Label(35, 3, "PERTENECE A UNA JUNTA RIEGO", times16format); sheet.addCell(label);
        label = new Label(36, 3, "FUENTE DE AGUA", times16format); sheet.addCell(label);
        label = new Label(37, 3, "INFRAESTRUCTURA DE RIEGO", times16format); sheet.addCell(label);
        label = new Label(38, 2, "MANEJO FORESTAL", times16format); sheet.addCell(label);
        label = new Label(38, 3, "TIENE ESPECIES FORESTALES", times16format); sheet.addCell(label);
        label = new Label(39, 3, "TIENE PÁRAMO O MONTE", times16format); sheet.addCell(label);
        label = new Label(40, 2, "MANEJO DE ANIMALES", times16format); sheet.addCell(label);
        label = new Label(40, 3, "TIENE LA FINCA PASTO", times16format); sheet.addCell(label);
        label = new Label(41, 3, "ABONA LOS PASTOS Y POTEROS CON", times16format); sheet.addCell(label);
        label = new Label(42, 3, "MANEJO DE PASTOS", times16format); sheet.addCell(label);
        label = new Label(43, 3, "LA FINCA DISPONE DE ADECUACIONES", times16format); sheet.addCell(label);
        label = new Label(44, 3, "REALIZA DESPARACITACIÓN DE SUS ANIMALES CON PRODUCTOS NATURALES", times16format); sheet.addCell(label);
        label = new Label(45, 3, "USO PRÁCTICAS ANCESTRALES PARA CURAR, PREVENIR, ENFERMEDADES DE ANIMALES", times16format); sheet.addCell(label);
        label = new Label(46, 2, "MANEJO DE AMBIENTE Y PRODUCCIÓN", times16format); sheet.addCell(label);
        label = new Label(46, 3, "QUE HACE CON LOS PLASTICOS, VIDRIOS, CAUCHOS Y LATAS", times16format); sheet.addCell(label);
        label = new Label(47, 3, "DESTINO DE LA PRODUCCIÓN (AUTOCONSUMO %)", times16format); sheet.addCell(label);
        label = new Label(48, 3, "DESTINO DE LA PRODUCCIÓN (VENTA %)", times16format); sheet.addCell(label);
        label = new Label(49, 3, "DONDE VENDE", times16format); sheet.addCell(label);
        label = new Label(50, 3, "CADA QUE TIEMPO VENDE", times16format); sheet.addCell(label);
        label = new Label(51, 2, "PARTICIPACIÓN", times16format); sheet.addCell(label);
        label = new Label(51, 3, "ES MIEMBRO ACTIVO DE UNA ORGANIZACIÓN", times16format); sheet.addCell(label);
        label = new Label(52, 2, "CRITERIO DEL PROMOTOR", times16format); sheet.addCell(label);
        label = new Label(52, 3, "LA FINCA SE CONSIDERA", times16format); sheet.addCell(label);


        fincas.each { f->

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
            number = new jxl.write.Number(11, fila,f?.altura ? f?.altura : 0); sheet.addCell(number);
            number = new jxl.write.Number(12, fila,f?.longitud ? f?.longitud : 0); sheet.addCell(number);
            number = new jxl.write.Number(13, fila,f?.latitud ? f?.latitud : 0); sheet.addCell(number);
            label = new Label(14, fila, (f?.zona ? f?.zona : ''), times16Normal); sheet.addCell(label);
            label = new Label(15, fila, (f?.plan ? f?.plan : ''), times16Normal); sheet.addCell(label);
            number = new jxl.write.Number(16, fila,f?.actvAgricola ? f?.actvAgricola : 0); sheet.addCell(number);
            number = new jxl.write.Number(17, fila,f?.actvPecuaria ? f?.actvPecuaria : 0); sheet.addCell(number);
            number = new jxl.write.Number(18, fila,f?.jornalerosPermanentes ? f?.jornalerosPermanentes : 0); sheet.addCell(number);
            number = new jxl.write.Number(19, fila,f?.jornalerosTemporales ? f?.jornalerosTemporales : 0); sheet.addCell(number);
            label = new Label(20, fila, (f?.entrevista ? f?.entrevista : ''), times16Normal); sheet.addCell(label);
            label = new Label(21, fila, (f?.preparacionSuelo ? f?.preparacionSuelo : ''), times16Normal); sheet.addCell(label);
            label = new Label(22, fila, (f?.fertilizantes ? f?.fertilizantes : ''), times16Normal); sheet.addCell(label);
            label = new Label(23, fila, (f?.fertilizacionComplementaria ? f?.fertilizacionComplementaria : ''), times16Normal); sheet.addCell(label);
            label = new Label(24, fila, (f?.manejoRastrojos ? f?.manejoRastrojos : ''), times16Normal); sheet.addCell(label);
            label = new Label(25, fila, (f?.asociacionCultivos ? f?.asociacionCultivos : ''), times16Normal); sheet.addCell(label);
            label = new Label(25, fila, (f?.rotacionCultivos ? f?.rotacionCultivos : ''), times16Normal); sheet.addCell(label);
            fila++

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
