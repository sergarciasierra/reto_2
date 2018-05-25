package com.bancolombia.reto_2.utilidades;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHtas {
	static String ruta = "C:\\Users\\sergarci\\Documents\\Listado_Vuelos.xlsx";

	public static void abrirExcel() throws IOException {
		Desktop dt = Desktop.getDesktop();
		dt.open(new File(ruta));
	}

	public static void escribirExcel(String[] vector) throws IOException {
		// Using XSSF for xlsx format, for xls use HSSF
		Workbook miLibro = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet miHoja = miLibro.createSheet("ValorTiquetes");

		CellStyle cellStyle1 = miLibro.createCellStyle();
		cellStyle1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		int cellIndex = 0;

		for (int i = 0; i < 11; i++) {
			Row fila = miHoja.createRow(i);
			Cell celda = fila.createCell(cellIndex);
			if (i == 0) {
//				cellStyle1 = miLibro.createCellStyle();

//				celda.setCellValue(new XSSFRichTextString(vector[i]));
				celda.setCellStyle(cellStyle1);
				celda.setCellValue(vector[i]);

			} else {
				celda.setCellValue(vector[i]);
			}
		}

		try {
			FileOutputStream fos = new FileOutputStream(ruta);
			miLibro.write(fos);
			fos.close();
			miLibro.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
