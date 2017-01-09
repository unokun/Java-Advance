package sec7;

import java.util.Iterator;
import java.util.Properties;

public class SystemProperty {

	public static void main(String[] args) {
		System.out.println("path.separator: " + System.getProperty("path.separator"));
		System.out.println("line.separator: " + System.getProperty("line.separator"));
		System.out.println("java.version: " + System.getProperty("java.version"));
		Properties properties = System.getProperties();
		Iterator<String> iterator = properties.stringPropertyNames().iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name + " ---> " + System.getProperty(name));
			
		}
	}

}
