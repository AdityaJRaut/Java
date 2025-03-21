package collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCollection {

	public static void main(String[] args) {
		List<String> mh;
		mh = new ArrayList<String>();
		mh.add("Pune");
		mh.add("Kolhapur");
		mh.add("Nagpur");

		List<String> rj;
		List<String> india = new ArrayList<String>();
		india.addAll(mh);
		// l1.clear();
		// System.out.println(l1);
		rj = new ArrayList<String>();
		rj.add("Jaipur");
		rj.add("Bikaner");
		rj.add("Fatehpur");
		rj.remove(2);
		india.addAll(rj);
		rj.add("udaipur");
		System.out.println(india);

	}

}
