package sec9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
	public static final int MAX_COLUMN = 10;
	public static final int ID_COLUMN_ID = 0;
	public static final int ID_COLUMN_NAME = 1;
	public static final int ID_COLUMN_OCCUPY = 2;
	public static final int ID_COLUMN_LEVEL = 3;
	public static final int ID_COLUMN_MONEY = 4;
	public static final int ID_COLUMN_WEAPON = 5;
	public static final int ID_COLUMN_PROTECT = 6;
	public static final int ID_COLUMN_ITEM1 = 7;
	public static final int ID_COLUMN_ITEM2 = 8;
	public static final int ID_COLUMN_ITEM3 = 9;
	public static final int ID_COLUMN_ITEM4 = 10;

	List<String> makePlayer() {
		List<String> player = new ArrayList<>(MAX_COLUMN + 1);
		for (int i = 0; i <= MAX_COLUMN; i++) {
			player.add("");
		}
		return player;
	}
	List<String> readPlayer(String line) {
		List<String> player = makePlayer();
		int i = 0;
		for (String token : line.split(",")) {
			player.set(i,  token.trim());
			i += 1;
//			player.add(token.trim());
		}
		return player;
	}

	void processPlayer(List<String> player) {
		boolean added = false;
		for (int i = 0; i <= MAX_COLUMN; i++) {
			if (player.get(i).isEmpty()) {
				player.set(i, "応援旗");
				added = true;
				break;
			}
		}
		if (!added) {
			player.set(ID_COLUMN_MONEY, player.get(ID_COLUMN_MONEY) + 100);

		}
		String level = player.get(ID_COLUMN_LEVEL);
		if (!level.isEmpty()) {
			player.set(ID_COLUMN_LEVEL, String.valueOf(Integer.parseInt(level) + 1));
		}

		for (int i = 0; i <= MAX_COLUMN; i++) {
			if (i != ID_COLUMN_ITEM1) {
				continue;
			}
			if (i != ID_COLUMN_ITEM2) {
				continue;
			}
			if (i != ID_COLUMN_ITEM3) {
				continue;
			}
			if (i != ID_COLUMN_ITEM4) {
				continue;
			}

			if (player.get(i).equals("鋼玉")) {
				player.set(i, "スペシャルソード");
			}

		}

	}

	String dumpPlayer(List<String> player) {
		StringBuilder builder = new StringBuilder();
		for (String token : player) {
			builder.append(token).append(",");
		}
		String retv = builder.toString();
		return retv.substring(0, retv.length() - 1);
	}

	void doTask() {
		File inCsv = new File("game_player.csv");
		File outCsv = new File("output.csv");
		if (!inCsv.exists()) {
			System.out.println("CSVファイルが見つかりません。");
			return;
		}
		if (outCsv.exists()) {
			while (true) {
				try (Scanner scanner = new Scanner(System.in)) {
					System.out.println("output.csvが存在します。ファイルを上書きしますか？[Y/N]");
					String input = scanner.next();
					if (input.equalsIgnoreCase("n")) {
						System.out.println("作業を中断します。");
						return;
					}
					if (input.equalsIgnoreCase("y")) {
						scanner.close();
						break;
					}
				}
			}
		}
		try (BufferedReader reader = new BufferedReader(new FileReader("game_player.csv"));
				BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"))) {
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				if (line.equals("")) {
					continue;
				}
				List<String> player = readPlayer(line);
				processPlayer(player);
				writer.write(dumpPlayer(player));
				writer.newLine();
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりません。");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Task1 task = new Task1();
		task.doTask();
	}

}
