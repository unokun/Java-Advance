package sec3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

	private static final int INDEX_MATH = 0;
	private static final int INDEX_JAPANESE = 1;
	
	public static void main(String[] args) {
		// 人：佐藤さん
		// 　算数：80
		//　 国語：60
		// 人：鈴木さん
		// 　算数：90
		//　 国語：70
		Map<String, Integer> scoreMap = new HashMap<>();
		scoreMap.put("算数", 80);
		scoreMap.put("国語", 60);
		System.out.println(scoreMap.get("算数"));
		
		for (String key : scoreMap.keySet()) {
			
		}
		for (Integer value : scoreMap.values()) {
			
		}
		
		Map<String, Map<String, Integer>> scoreMapMap = new HashMap<>();
		
		List<Integer> scoreList = new ArrayList<>();
		scoreList.add(80);
		scoreList.add(60);
		
		for (Integer score : scoreList) {
			System.out.println(score);
		}
		
		// 車：値段
		// Car(名前、メーカー)
		// priceMap = Map<Car, Integer> 
		// Car crx = new Car("crx", "Honda")
		// priceMap.put(crx, 2000000);
		// Car legacy = new Car("legacy", "Subaru")
		// priceMap.put(legacy, 3000000);
		//
		// Car crx = new Car("crx", "Honda")
		// priceMap.put(crx, 2000000);
		// 
	}

}
