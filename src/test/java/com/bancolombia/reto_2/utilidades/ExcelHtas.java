package com.bancolombia.reto_2.utilidades;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;

public class ExcelHtas {
    private static XSSFSheet ExcelHoja;
    private static XSSFWorkbook ExcelLibro;
    private static XSSFCell Celda;
    private static XSSFRow Fila;
    // Establece la ruta del archivo de Excel y lo abre
    // Pasar la ruta del archivo y el nombre de la hoja como argumentos de este método     
    public static void AbrirExcel(String ruta,String NombreHoja) throws Exception {
                  try {
                  // Abrimos el archivo excel
                  FileInputStream ExcelArchivo = new FileInputStream(ruta);
                  // Accedemos a la hoja de datos requerida
                  ExcelLibro = new XSSFWorkbook(ExcelArchivo);
                  ExcelHoja = ExcelLibro.getSheet(NombreHoja);
                  } catch (Exception e){
                        throw (e);
	                  }
	      }
	      
      // Este método lee los datos de una celda de Excel
      // Pasar como parámetros FilaNum y ColNum   
      public static String TraerValorCelda(int FilaNum, int ColNum) throws Exception{
                  try{
                  Celda = ExcelHoja.getRow(FilaNum).getCell(ColNum);
                  String CellData = Celda.getStringCellValue();
                  return CellData;
	              }catch (Exception e){
	                    try{
	                        String CellData = "" + Celda.getNumericCellValue();
	                        return CellData;
	                        }catch (Exception e2){                   
	                        return"";
	                        }
	                  }
	    }    
	      
      // Este método escribe en una celda de Excel
      // Pasar como parámetros FilaNum y ColNum
      
    //  public static final Row.MissingCellPolicy RETURN_BLANK_AS_NULL = null;
      
public static void PonerValorCelda(String Resultado,  int FilaNum, int ColNum) throws Exception   {
       try{
           Fila  = ExcelHoja.getRow(FilaNum);
           Celda = Fila.getCell(ColNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
           if (Celda == null) { 
        	   Celda = Fila.createCell(ColNum);
        	   Celda.setCellValue(Resultado);
	       } else { 
	    	   Celda.setCellValue(Resultado);
	       }
	       // Constant variables Test Data path and Test Data file name
	       FileOutputStream fileOut = new FileOutputStream("ruta salida" + "ArchivoSalida");
	      
      ExcelLibro.write(fileOut);
                  fileOut.flush();
                  fileOut.close();
            }catch(Exception e){
                  throw (e);
            }
      } 

}
