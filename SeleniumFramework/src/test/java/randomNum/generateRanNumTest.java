package randomNum;

import java.util.Random;

public class generateRanNumTest {

	public static void main(String[] args) {
		
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		
		System.out.println(randomInt);

	}

}