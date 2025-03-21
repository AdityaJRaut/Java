package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<String, Double> hmap = new HashMap<String, Double>();
		hmap.put("Aditya", 55000.25);
		hmap.put("Bhushan", 57000.35);
		hmap.put("Bhavesh", 52000.63);
		hmap.put("Sanket", 57000.52);
		hmap.put("Shubham", 45000.25);
		hmap.put("Dinesh", 59000.25);
		hmap.put("Aditya", hmap.getOrDefault(hmap, hmap.get("Aditya")) + 52000);
		System.out.println(hmap);
		for (Entry<String, Double> entry : hmap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

}
