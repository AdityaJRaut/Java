package abstractionrealtime;

public class CricketTurf implements Turf {

	@Override
	public String getTurfType() {
		return "Cricket Turf";
		
	}

	@Override
	public int getHourlyRate() 
	{
		return 700;
		
	}

}
