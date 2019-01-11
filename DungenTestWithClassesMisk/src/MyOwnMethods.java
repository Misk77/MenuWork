
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MyOwnMethods {

	Scanner sc = new Scanner(System.in);
	int inp;
	public void WriteToFile() {
		/*
		 * Must  check this then time, if user input filepath/filename it will bugg,cuz probably scanner aint closed properly
		 * im using more than one scanner in dirreferbt location, not good
		 * String filepath;
		System.out.println("Skriv in filnamnet du vill spara: ");
		 filepath = sc.next();
		 
		 String filepath2 = "C:\\\\Users\\\\miche\\\\Desktop\\\\"+filepath+".txt";
		WriteFile wf = new WriteFile(filepath2, true);
		
		String filepath;
		System.out.println("Skriv in filnamnet du vill spara: ");
		 filepath = sc.next();
		 */
		 String filepath = "C:\\\\Users\\\\miche\\\\Desktop\\\\writemytextfile.txt";
		WriteFile wf = new WriteFile(filepath, true);

		try {
			System.out.println("Skriv till filen\n");
			String usertext = sc.nextLine();
			wf.writeToFile(usertext);
			System.out.printf("Du har skrivit till filen:\n%s", filepath);
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Du har inte skrivit till filen.\nNågot gick fel");
		}

		
	}

	///////////////// END

}
