package com.example.file.csv;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "id", "codigo", "nombre", "nit_prov","precio_compra","ivacompra","precio_venta"};

  public static boolean hasCSVFormat(MultipartFile file) {//Se revisa si el formato es CSV
    if (TYPE.equals(file.getContentType())
    		|| file.getContentType().equals("application/vnd.ms-excel")) {
      return true;
    }

    return false;
  }

  //Original
  
  public static List<Productos> csvProductos(InputStream is) { //Metodo para leer el CSV
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {//Cada linea en forma de registro

	      List<Productos> productosList = new ArrayList<>();
	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();//Se optiene el valor de cada registro
	      int tam = 0;
	      if (csvRecords instanceof Collection<?>) {
	    	  tam = ((Collection<?>)csvRecords).size();
	    	}
	      System.out.println("Tamaño: "+tam);
	      List<String> list = new ArrayList<>();
	      for (int aux=0; aux<tam; aux++) {
	    	  list = getListFromIterator(((List<CSVRecord>) csvRecords).get(aux).iterator());    	  
	    	  for (int a1=0; a1<list.size(); a1++) {
	    		  System.out.println("Esto hace el for 2: "+list.get(a1));
	    		  String[] split = null;
	    	      split = list.get(a1).split(";");    	      
	    	      int id = Integer.parseInt(split[0]);
	    	      int codigo = Integer.parseInt(split[1]);
	    	      String nombre = split[2];
	    	      int nitp = Integer.parseInt(split[3]);
	    	      double pc = Double.parseDouble(split[4]);
	    	      double iva = Double.parseDouble(split[5]);
	    	      double pv = Double.parseDouble(split[6]);
	    	      Productos producto = new Productos(id,codigo,nombre,nitp,pc,iva,pv);   	     
	    		  productosList.add(producto);
	    	  }
	      }

	      return productosList;
	      
	    } catch (IOException e) {
	      throw new RuntimeException("Fallo el analisis del archivo CSV: " + e.getMessage());
	    }
	  }
 
  
  private static List<String> getListFromIterator(Iterator<String> iterator) {
	  
	  List<String> list = new ArrayList<>();
	  
      // Add each element of iterator to the List
      iterator.forEachRemaining(list::add);

      // Return the List
      return list;
}

public static ByteArrayInputStream toCSV(List<Productos> productosList) {// Para poner datos de la BD al CSV
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (Productos prod : productosList) {
        List<String> data = Arrays.asList(
        		String.valueOf(prod.getId()),
        		String.valueOf(prod.getCodigo()),
        		prod.getNombre(),
        		String.valueOf(prod.getNitp()),
        		String.valueOf(prod.getPrecioc()),
        		String.valueOf(prod.getIva()),
        		String.valueOf(prod.getPreciov())
        		
            );

        csvPrinter.printRecord(data);
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("Fallo la importación del archivo CSV: " + e.getMessage());
    }
  }


}
