package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDataValidation {

   public static boolean emailIdValidator(String arg) {
      // String to be scanned to find the pattern.
      
      String pattern = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(arg);
      if (m.find( )) {
         return true;
      }else {
         return false;
      }
   }
   
   public static boolean postalCodeValidator(String arg) {
	      // String to be scanned to find the pattern.
	      
	      String pattern = "^([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([AZa-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9]?[A-Za-z])))) [0-9][A-Za-z]{2})$";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(arg);
	      if (m.find( )) {
	         return true;
	      }else {
	         return false;
	      }
	   }
   
  
}