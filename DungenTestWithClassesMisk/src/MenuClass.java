import java.util.Scanner;

public class MenuClass {
	// Make an object of menuclass
	//MenuClass mc = new MenuClass();
	//objekt of profilemethod
	
	
	
	WriteFile wf=new WriteFile(null, false);
	
        
	// classens variabler

	// MyOwnMethods classen
	MyOwnMethods mm = new MyOwnMethods();
	Scanner sc = new Scanner(System.in);
	int inp;

	public void menumethod() {
while (true) {
		System.out.println("\n|===========================================|"
				+ "\n|------------------ MENU--------------------|" + "\n|===========================================|"
				+ " \nAnge vad du vill g�ra: " + "\n[1]-checkPasswordForLetters "
				+ "\n[2]-evenOdd" + "\n[3]-myProfileMethodd " + "\n[4]-palidrom "
				+ "\n[5]-searchANumber " + "\n[6]-medelTal "
				+ "\n[7]-Ta reda p� vad ett ord blir bakl�nges "
				+ "\n[8]-Vill du skriva in 10 tal  i en lista och se st�rsta resp minsta talet "
				+ "\n[9]-genereraMultiplikation " + "\n[10]-Kasta t�rning " + "\n[11]-Skapa en txtfile "
				+ "\n[12]-L�sa en txtfil fr�n datorn " + "  \n[13]-WriteToFile "
				+ "\n[14]-Skapa en profil " + "  \n[15]-S�ka i profil databasen " + "\n[16]-R�kna ut +,-,*,/,%  "
				+ "  \n[17]-{!!-Under Construction-!!} " + "\n[18]-gissaTalet "
				+ "  \n[19]-{!!-Under Construction-!!} " + "\n[20]-Spela quiz{!!-Under Construction-!!} "
				+ " \n[21]-Rita{!!-Under Construction-!!} " + "\n[0]-{Avsluta} "
				+ "\n|===========================================| "
				+ "+ |------------- More is coming! -------------| "
				+ "+ |===========================================|\n " + " >>>\t ");

		// Valen i menu
		inp = sc.nextInt();

		switch (inp) {

		case  13:
			mm.WriteToFile();
	
			
			
			
			
			
		case 0: 
			System.out.println("Bye....");
			System.out.println("\tBye....");
			System.out.println("\t\tBye....");
			System.exit(0);
			

		default:
			System.out.println("no match");
			System.out.println("\t try again........");
		}

	
}
		/// END

	}

}
