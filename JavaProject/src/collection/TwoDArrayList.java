package collection;

import java.util.ArrayList;
import java.util.List;

public class TwoDArrayList {

	public static void main(String[] args) {

		List<String> mh = new ArrayList<String>();
		List<String> rj = new ArrayList<String>();
		List<List<String>> india = new ArrayList<List<String>>();
		india.add(mh);
		india.add(rj);
		mh.add("Pune");
		mh.add("Kolhapur");
		mh.add("Nagpur");
		mh.add("Nashik");
		rj.add("Jaipur");
		rj.add("Udaipur");
		rj.add("Fatehpur");
		// System.out.println(india);
		india.forEach(state -> System.out.println(state));
	}

}
