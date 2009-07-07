package lt.ktu.dstrukov.schoolscheduler.utils;

public class StringParser {

	
	public static boolean tryParseInt(String s){
		try{
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException ex){
			return false;
		}
	}
}
