package sec7;

public class SystemMemory {

	public static void dumpMemory() {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("freeMemory: " + runtime.freeMemory());
		System.out.println("maxMemory: " + runtime.maxMemory());
		System.out.println("totalMemory: " + runtime.totalMemory());
		System.out.println("used: " + (runtime.totalMemory() - runtime.freeMemory()));
		System.out.println("---------------------------");
		
	}
	public static void main(String[] args) {
		
		// 計測
		dumpMemory();

		// メモリを使う
		int size = 1000000; // 1M
		byte[] bytes = new byte[size];
		for (int i = 0; i < size; i++) {
			bytes[i] = 0xf;
		}
		
		// 計測
		dumpMemory();
		
		
		// GC
		bytes = null;
		Runtime.getRuntime().gc();
	}

}
