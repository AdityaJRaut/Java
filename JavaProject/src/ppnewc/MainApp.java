package ppnewc;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CricketTurf c1=new CricketTurf();
		c1.TurfType();
		c1.PerHourRate();
		System.out.println(c1.inauguratedBy);
		
		FootballTurf f1=new FootballTurf();
		f1.TurfType();
		f1.PerHourRate();
		System.out.println(f1.inauguratedBy);
		
		Turf t1=new CricketTurf();
		t1.TurfType();
		t1.PerHourRate();
		System.out.println(t1.InauguratedBy);
		
		Student s1=new Student();
		System.out.println(s1);
		
		
	}

}
