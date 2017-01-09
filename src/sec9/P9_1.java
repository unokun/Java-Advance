package sec9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class P9_1 {

	public static void main(String[] args) {
		File inFile = new File(args[0]);
		File outFile = new File(args[1]);

		try (InputStream is = new FileInputStream(inFile); OutputStream os = new FileOutputStream(outFile)) {
			// データをコピーします
			// バイト列を読み込む
//			int size = is.available();
			byte[] bytes = new byte[1024];
			while (true) {
				int read = is.read(bytes);
				if (read == -1) {
					break;
				}
				// バイト列を書き込む
				os.write(bytes, 0, read);
			}
			
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
