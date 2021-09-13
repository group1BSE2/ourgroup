package core;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;

public class CsvWriter {
  public static void main(String[] args) {

    try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {

      StringBuilder sb = new StringBuilder();
      sb.append("id,");
      sb.append(',');
      sb.append("Name");
      sb.append('\n');

      sb.append("1");
      sb.append(',');
      sb.append("Prashant Ghimire");
      sb.append('\n');

      writer.write(sb.toString());

      System.out.println("done!");

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }

  }
  
  public static void csvWriter(ArrayList<Object[]> allobj, String csvFilePath) {
	  
	  try (PrintWriter writer = new PrintWriter(new File(csvFilePath))) {

	      StringBuilder sb = new StringBuilder();
	      for (int x = 0; x < allobj.size(); x++) {//Looping thru the array list to pick the objects...
              Object[] objectArr = allobj.get(x);
              String str = "";
              for (Object obj : objectArr) {//Looping inside the object...
                  if (obj instanceof String) {
                      String val = (String) obj;
                      str += val+",";
                  } else if (obj instanceof Integer) {
                	  str += Integer.toString((int) obj)+ ",";
                  } else if (obj instanceof Double) {
                	  str += Double.toString((double) obj)+ ",";
                  }
              } 
              str = str.substring(0, str.length()-1);
              sb.append(str+"\n");
          }//End of for loop for arraylist of object....

	      writer.write(sb.toString());

	      System.out.println("Finished Writing : " + csvFilePath);

	    } catch (FileNotFoundException e) {
	      System.out.println(e.getMessage());
	    }
  }
}