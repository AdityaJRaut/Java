package collection;

public class VectorExample {

	public static void main(String[] args) {
		java.util.Vector<Integer> v = new java.util.Vector<Integer>();
		v.addElement(1);
		v.add(2);
		v.add(0, 3);
		System.out.println(v);
		v.addLast(25);
		v.sort(null);
		System.out.println(v);
		System.out.println(v.capacity());
		v.setSize(2);
		System.out.println(v);
		System.out.println(v.elements());

	}

}
