package sec9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

public class P9_2 {

	public static void main(String[] args) {
		if (args.length < 2) {
			return;
		}
		File inFile = new File(args[0]);
		File outFile = new File(args[1]);
		
		if (!inFile.exists()) {
			System.out.println("ファイルが見つかりません。 " + inFile.getName());
			return;
		}
		
		
		try (InputStream is = new FileInputStream(inFile); GZIPOutputStream zos = new GZIPOutputStream(new FileOutputStream(outFile))) {
			while (true) {
				int i = is.read();
				if (i == -1) {
					break;
				}
				zos.write(i);
			}
			zos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
