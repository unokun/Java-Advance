package sec2;

import java.util.Calendar;
import java.util.Scanner;

public class Task1 {
	static int getYear(Scanner scanner) {
		System.out.print("カレンダーの年を入れてください > ");
		String input = scanner.nextLine();

		if (!input.matches("[0-9]+")) {
			System.out.println("数字を正しく入力してください");
			return 0;
		}
		int year = Integer.parseInt(input);
		if (year < 1900 || year > 2100 ) {
			System.out.println("1900から2100の間で入力してください");
			return 0;
		}
		return year;
	}
	static int getMonth(Scanner scanner) {
		System.out.print("カレンダーの月を入れてください > ");
		String input = scanner.nextLine();

		if (!input.matches("[0-9]+")) {
			return 0;
		}
		int month = Integer.parseInt(input);
		if (month < 1 || month > 12 ) {
			System.out.println("1から12の間で入力してください");
			return 0;
		}
		return month;
	}
	static String getWeek(int week) {
		
		switch (week) {
		case Calendar.SUNDAY:
			return "日";
		case Calendar.MONDAY:
			return "月";
		case Calendar.TUESDAY:
			return "火";
		case Calendar.WEDNESDAY:
			return "水";
		case Calendar.THURSDAY:
			return "木";
		case Calendar.FRIDAY:
			return "金";
		case Calendar.SATURDAY:
			return "土";
		}
		return String.valueOf(week);
	}
	static void printCalendar(int year, int month) {
		System.out.println(year + "年" + month + "月のカレンダー");
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
//		System.out.println(calendar.getTime());
		int weekOfMonth = -1;
		for (int i = 1; i <= 31; i++) {
			calendar.set(Calendar.DAY_OF_MONTH, i);
			int w = calendar.get(Calendar.WEEK_OF_MONTH);
			if (weekOfMonth != w) {
				if (weekOfMonth != -1) {
					System.out.println("");
				}
				weekOfMonth = w;
			}
//			System.out.println(calendar.getTime());
//			System.out.println("month: " + calendar.get(Calendar.MONTH));
			if ((calendar.get(Calendar.MONTH) + 1) != month) { break; }
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			
			System.out.print(i + "日(" + Task1.getWeek(dayOfWeek) + ")  ");
			
		}
		System.out.println("--------");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 0;
		int month = 0;
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				if (year == 0) {
					year = Task1.getYear(scanner);
					continue;
				}
				if (month == 0) {
					month = Task1.getMonth(scanner);
					continue;
				}
				if (year != 0 && month != 0) {
					break;
				}
			}
			
		}
		Task1.printCalendar(year,  month);
	}

}
