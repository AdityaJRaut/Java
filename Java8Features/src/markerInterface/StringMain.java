package markerInterface;

public class StringMain {

    public static void main(String[] args) {
        String s="This iS mY CoUNtrY";

        StringBuffer sb=new StringBuffer();

//        for(int i=0;i<s.length();i++)
//        {
//            if(i==0)
//            {
//                sb.append(Character.toUpperCase(s.charAt(i)));
//            } else if (Character.isWhitespace(s.charAt(i))) {
//                i++;
//                sb.append(" ");
//                sb.append(Character.toUpperCase(s.charAt(i)));
//
//            }
//            else {
//                sb.append(Character.toLowerCase(s.charAt(i)));
//            }
//        }
//        System.out.println(sb);

        String[] words=s.split(" ");
        for(String word:words) {
            sb.append(Character.toUpperCase(word.charAt(0)));
            sb.append(word.substring(1).toLowerCase());
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
