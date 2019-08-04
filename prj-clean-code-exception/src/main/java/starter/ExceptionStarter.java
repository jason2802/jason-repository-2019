package starter;

import com.objectmentor.utilities.args.Args;
import com.objectmentor.utilities.args.ArgsException;

public class ExceptionStarter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Args arg = new Args("l,p#,d*", args);
			@SuppressWarnings("unused")
			boolean logging = arg.getBoolean('l');
			
			@SuppressWarnings("unused")
			int port = arg.getInt('p');
			
			@SuppressWarnings("unused")
			String directory = arg.getString('d');
			
			// executeApplication(logging, port, directory);
		} catch (ArgsException e) {
			System.out.printf("Argument error: %s\n", e.errorMessage());
		}
			
		
	}
	
}
