package cmdMaven;

public class javaClassReadCMDTest {

	public static void main(String[] args) {
		
		System.out.println(args.length);
		//display content o argument in cmd
		
		for(String var: args) {
			System.out.println(var);
		}

	}

}
