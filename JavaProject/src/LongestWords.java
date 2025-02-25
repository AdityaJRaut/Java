
public class LongestWords {

	public static void main(String[] args) {
		String name = "Aditya Janardan Raut Kolhapur";
		String words[]=name.split(" ");
		
		int maxLenght=words[0].length();
		String maxString="";
		for(int i=0;i<words.length;i++)
		{
			if(words[i].length()>maxLenght)
			{
				maxString=words[i];
				maxLenght=words[i].length();
				
			}
		}
		
		System.out.println(maxString);
		
//		Map<String,Integer> sepstring=new HashMap<String, Integer>();
//		for(String ch:name.split(" "))
//		{
//			sepstring.put(ch, ch.length());
//		}
//		int max=0;
//		String longString="";
//		for(Map.Entry<String, Integer> entry:sepstring.entrySet())
//		{
//			if(max<entry.getValue())
//			{
//				max=entry.getValue();
//				longString=entry.getKey();
//			}
//		}
//		System.out.println("Longest String : "+longString);
	}
}
