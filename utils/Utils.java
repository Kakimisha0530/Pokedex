/**
 * 
 */
package utils;

/**
 * @author aicha
 * 
 */
public class Utils {
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static boolean chaine_non_vide(String s) {
		return s.replace(" ", "").isEmpty();
	}
	
	public static void main(String[] args) {
		
	}
}
