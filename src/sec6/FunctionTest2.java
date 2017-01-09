package sec6;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;

public class FunctionTest2 {

	public static void main(String[] args) {
//		System.out.println(FunctionTest::sub);
//		FunctionTest test = FunctionTest::sub;
		MyFunction func = FunctionTest::sub;
		
		Class clazz = func.getClass();
		System.out.println(clazz.getName());
		// メソッド一覧
		for (Method m : clazz.getMethods()) {
			System.out.println(m.getName());
		}		
		try {
			// callメソッドのパラメータ情報
			Method method = clazz.getMethod("call", new Class[]{int.class, int.class, int.class});
			for (Parameter param : method.getParameters()) {
				System.out.println(param.getName());
				System.out.println(param.getType().getName());
			}		
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
//		int a = func.call(5, 3, 2);
//		System.out.println("5-3 = " + a);
	}

}
