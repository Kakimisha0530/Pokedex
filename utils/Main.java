/**
 * 
 */
package utils;

import java.net.URL;

/**
 * @author aicha
 *
 */
public class Main {
	public static void main(String[] args) {
		URL chemin = (new Main()).getClass().getResource("");
		String uri = chemin.getPath();
		System.out.println(uri.split("bin")[0]);
	}
}
