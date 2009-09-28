package lt.ktu.dstrukov.scheduler.model.misc;

import java.util.Random;

public class RandomGenerator {

	private static Random  rnd = new Random();
	
	public static double getRandomDouble(){
		return rnd.nextDouble();
	}
	
	public static int getRandomNumber(int from, int to){
		if(from==to) return to;
		return rnd.nextInt(to+1)+from;
	}
	
	
}
