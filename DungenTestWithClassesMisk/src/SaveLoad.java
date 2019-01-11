import java.io.IOException;
import java.util.Scanner;

public class SaveLoad {
	
	public void saveToDisk() {//need to add the proper arguments, like name and treasure
		// main metoden d�r man skriver in till texten och som h�mtar metoden i writefile classen
				Scanner sc = new Scanner(System.in);
				
				String filepath = "C:\\\\Users\\\\miche\\\\Desktop\\\\DungenSaves.txt";
				
						
				WriteFile wf = new WriteFile(filepath,true);
				
				
				try {
					System.out.println("Skriv in ditt namn: ");
					String usertext=sc.nextLine();
					wf.writeToFile(usertext);
					System.out.printf("Du har sparats.\nSpelar namn\n%s:\n%s",usertext,filepath);
				}
				
				catch(IOException e) {
				
					System.out.println("Du har inte skrivit till filen.\nN�got gick fel");
				}
		
	
	}
	public void LoadFromDisk() {
		
	}
}
