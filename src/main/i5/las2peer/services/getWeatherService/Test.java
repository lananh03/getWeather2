package i5.las2peer.services.getWeatherService;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;  
public class Test {    
     public static void main(String args[]){   
    	 Scanner scanner;
	     try {
			scanner = new Scanner(new File("./frontEnd/index.html"));
			String html = "";
		    html = scanner.useDelimiter("\\A").next();
	         //Print String  
	        System.out.println(html);  
	           
	        scanner.close();
	        html = fillPlaceHolder(html, "NAME_CITY", "Aachen");
	        System.out.println(html);
	        int newTem = (int)(14);
	        html = fillPlaceHolder(html, "TEMP", String.valueOf(newTem));
	        System.out.println(html);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
   }    
     
     private static String fillPlaceHolder(String data, String placeholder, String value) {
 		Pattern p = Pattern.compile("\\$\\{" + placeholder + "\\}");
 		Matcher m = p.matcher(data);
 		
 		String adaptedform = new String(data);
 		
 		while(m.find()) {
 			String tag = m.group().substring(2, m.group().length() -1 );
 			adaptedform = adaptedform.replaceAll("\\$\\{" + tag +"\\}", value);
 		}

 		return adaptedform;
 	}
}  