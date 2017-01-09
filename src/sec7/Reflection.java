package sec7;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Reflection {
	public static int test(String arg0, int arg1) {
		return 1;
	}
	public static void main(String[] args) {
		try {
			Class clazz = Reflection.class;
			Reflection reflection = (Reflection)clazz.newInstance();
			System.out.println(reflection.test("0", 0));
			
			for (Method m : clazz.getMethods()) {
				System.out.println(m.getName());
			}
			System.out.println(Class.forName("sec7.Reflection").getName());
			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
