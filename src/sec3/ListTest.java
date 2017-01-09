package sec3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	static void printList(List<Integer> list) {
		for (Integer i : list) {
			System.out.println(i);
		}
		
	}
	public static void test() {
		List<Integer> list = new ArrayList<>();
//		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		printList(list);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListTest.test();
	}

}
