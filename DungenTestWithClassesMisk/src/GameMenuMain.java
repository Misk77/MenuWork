
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class GameMenuMain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Scanner scanner = new Scanner(System.in);
	JFrame frame = new JFrame("Dungen Run");

	String name;
	String choice;
	String heroType = "";
	int mapType = 0;

	private BufferedImage image;
	public Object panel;
	// System objects

	// Scanner scanner = new Scanner(System.in);
	// GameMenuMain gMenuMain = new GameMenuMain();
	SaveLoad<?> save = new SaveLoad<Object>();// Maybe shouldnt be here
	FileData fd = new FileData();
	SaveLoad<?> sl = new SaveLoad<Object>();

	static GameMenuMain gMenuMain = new GameMenuMain();
	Map map = new Map();
	// Scanner scanner = new Scanner(System.in);
	// map.generateMap(4, 4);
	Game game = new Game();
	Hero hero = new Hero(heroType, name);

	public void ReadChar() {

		// display the jpanel in a joptionpane dialog, using showMessageDialog
		// JFrame frame = new JFrame("Read");
		String readAbout[] = { "\n--------------------------- Heros -----------------------\n", "Knight\n",
				"initiative = 5.herotype = herotype\\nhealth = 9\\nbaseattack = 6\\navoidance = 4\\n\"\r\n",
				"Specialförmåga: Sköldblock. Riddaren blockerar alltid första attackenper strid med sin sköld \\noch behöver därför varken undvika eller ta någon skada\n",
				"Wizard\n", "initiative = 6\nherotype = herotype\nhealth = 4\nbaseattack = 9\navoidance = 5\n",
				"Specialförmåga: Ljussken. Trollkarlen kan göra monster blinda och hardärför alltid 80% chans att fly från strider\n",
				"Rogue\n",
				"initiative = 7\\nherotype = herotype\\nhealth = 5\\nbaseattack = 5\\navoidance = 7\\n\"\r\n",
				"Specialförmåga: Kritisk träff. Tjuven har 25% chans att göra dubbel skada varje gång tjuven attackerar\\n",
				"\n-------------------------- Monster ----------------------\n",
				"Giant Spider\ninitiative = 7\nMonstertype = Monster\\nhealth = 1\nbaseattack = 2\navoidance = 3\n",
				"Skeleton\ninitiative = 4\nMonstertype = Monster\nhealth = 2\nbaseattack = 3\navoidance = 3\n",
				"Orc\ninitiative = 6\nMonstertype = Monster\nhealth = 3\nbaseattack = 4\navoidance = 4\n",
				"Troll\ninitiative = 6\nMonstertype = Monster\nhealth = 3\nbaseattack = 4\navoidance = 4\n",
				"-------------------------- Treasure ----------------------",
				"Loose coins\ntreasuretype: treasuretype\nValue: 2\n",
				"\nSmall bag of coins\ntreasuretype: treasuretype\nValue: 6\n",
				"\nGold jewellry\ntreasuretype: treasuretype\nValue: 10\n",
				"\nPrecious stone\ntreasuretype: treasuretype\nValue: 14\n",
				"\nSmall treasure chest\ntreasuretype: treasuretype\nValue: 20\n",
				"=================================================================",
				"Press ok then you ready to go on" };

		JList<?> list = new JList<Object>(readAbout);
		JScrollPane scrollpane = new JScrollPane(list);
		scrollpane.setPreferredSize(new Dimension(500, 500));// <-----any size you want, FIRST:Width, then lenght
		JOptionPane.showMessageDialog(frame, scrollpane, "Read About ...", JOptionPane.PLAIN_MESSAGE);

		/*
		 * System.out.println(
		 * "\n---------------------------Heros-----------------------");
		 * 
		 * System.out.println("Knight\n" +
		 * "initiative = 5\nherotype = herotype\nhealth = 9\nbaseattack = 6\navoidance = 4\n"
		 * +
		 * "Specialförmåga: Sköldblock. Riddaren blockerar alltid första attackenper strid med sin sköld \noch behöver därför varken undvika eller ta någon skada\n"
		 * );
		 * 
		 * System.out.println("Wizard\n" +
		 * "initiative = 6\nherotype = herotype\nhealth = 4\nbaseattack = 9\navoidance = 5\n"
		 * +
		 * "Specialförmåga: Ljussken. Trollkarlen kan göra monster blinda och hardärför alltid 80% chans att fly från strider\n"
		 * );
		 * 
		 * System.out.println("Rogue\n" +
		 * "initiative = 7\nherotype = herotype\nhealth = 5\nbaseattack = 5\navoidance = 7\n"
		 * +
		 * "Specialförmåga: Kritisk träff. Tjuven har 25% chans att göra dubbel skada varje gång tjuven attackerar\n"
		 * );
		 * System.out.println("--------------------------Monster----------------------")
		 * ; System.out.println(
		 * "Giant Spider\ninitiative = 7\nMonstertype = Monster\nhealth = 1\nbaseattack = 2\navoidance = 3\n"
		 * ); System.out.println(
		 * "Skeleton\ninitiative = 4\nMonstertype = Monster\nhealth = 2\nbaseattack = 3\navoidance = 3\n"
		 * ); System.out.
		 * println("Orc\ninitiative = 6\nMonstertype = Monster\nhealth = 3\nbaseattack = 4\navoidance = 4\n"
		 * ); System.out.
		 * println("Troll\ninitiative = 6\nMonstertype = Monster\nhealth = 3\nbaseattack = 4\navoidance = 4\n"
		 * );
		 * System.out.println("--------------------------Treasure----------------------"
		 * ); System.out.println("Loose coins\ntreasuretype: treasuretype\nValue: 2\n" +
		 * "\nSmall bag of coins\ntreasuretype: treasuretype\nValue: 6\n" +
		 * "\nGold jewellry\ntreasuretype: treasuretype\nValue: 10\n" +
		 * "\nPrecious stone\ntreasuretype: treasuretype\nValue: 14\n" +
		 * "\nSmall treasure chest\ntreasuretype: treasuretype\nValue: 20\n");
		 */
	}

	public void iGame() {
		/* Instruction about the game. */

		// ((Object) frame).panel(Color.BLUE);
		// panel.setMinimumSize(new Dimension(500, 500));// <-----any size you want,
		// FIRST:Width, then lenght
		String readAbout[] = { "\n", "1. You will need to pick yourself a character of your choice.\r\n",
				"2. Choose your size of the game, small, medium or large. It’s the map.\r\n",
				"3. You will battle monsters.\r\n" + "4. Pick up Treasures!\r\n",
				"5. The adventure is Game Over when the player leaves the map or gets defeated.\r\n",
				"6. The commands to the games movement is “In need to be written” North, South, East, West. \r\n",
				"=================================================================",
				"Press ok then you ready to go on" };

		JList<?> list = new JList<Object>(readAbout);
		JScrollPane scrollpane = new JScrollPane(list);
		scrollpane.setPreferredSize(new Dimension(400, 400));// <-----any size you want, FIRST:Width, then lenght
		JOptionPane.showMessageDialog(frame, scrollpane, "Read About ...", JOptionPane.PLAIN_MESSAGE);

	}

	@SuppressWarnings("unused")
	public void GameMenuMainstart() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex) {
		}

		try {
			setImage(new URL(
					"https://cf.geekdo-images.com/imagepage/img/MCcqfLLvBMQPLxt3xzTSAcM4dfo=/fit-in/900x600/filters:no_upscale()/pic954633.jpg"));
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Dimension size = frame.getPreferredSize();
		frame.setBounds(300, 100, size.width, size.height);

		frame.setSize(500, 500);
		frame.setContentPane(this);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		try {
			JOptionPane.showMessageDialog(frame,
					"Demo No:1\nWelcome to the Dungeon Run!" + "\nKlick [OK] to start the console program.", choice, 0,
					null);
			hero.name = JOptionPane.showInputDialog(

					frame, "Enter you nick ", "Welcome player", JOptionPane.PLAIN_MESSAGE);
			frame.setVisible(true);
			// if the user presses Cancel, this will be null and not properly saved..hmmm

			JOptionPane.showMessageDialog(frame, "Your nick is set to: \n" + hero.name);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		save.saveToDisk(hero.name);

		/*
		 * System.out.println("To bad your leaving....");
		 * System.out.println("Come back then you dare to enter the dungeons.....");
		 * System.exit(0);
		 */

		// Game start

		boolean running = true;
		GAME: // This can be uses as at startpoint, then ever we wanna get back here,
		// have GAME; like a break but put us here instead

		while (running) {

			// if the user presses Cancel, this will be null and not properly saved..hmmm

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			// System.out.println("[Help]-Read about the game..."); // Readfile eller metod
			// där allt står om spelet,
			// spelrunda
			// System.out.println("[Choose]-Choose your charachter.."); // tar in hero
			// metoden
			// System.out.println("[Maps]-Choose your maps.."); // läser från load metoden
			// och tar in befiltlig spelare
			// System.out.println("[Load]-Load your charachter.."); // läser från load
			// metoden och tar in befiltlig spelare

			// System.out.println("[See]-See highscore(treasure points) charachter.."); //
			// System.out.println("[Read]-Read about the charachter..");// om spelkaraktärer
			// System.out.println("[EXIT]-Read about the charachter..");// om spelkaraktärer
			// System.out.println("[CANCEL]-Read about the charachter..");// om
			// spelkaraktärer

			JOptionPane.showMessageDialog(frame,
					"\"============================== Lets the Game begin! ===================================\nType your choice in the Meny: ",
					choice, 0, null);
			choice = JOptionPane.showInputDialog(

					frame, "Help\nChoose\nMaps\nLoad\nSee\nRead\nreadTxt\nEXIT", "Type here ..",
					JOptionPane.PLAIN_MESSAGE);
			// if the user presses Cancel, this will be null and not properly saved..hmmm

			// Valen i menu

			switch (choice.toUpperCase()) {

			case "HELP":
				// allt från här till

				/* Aiham */
				// Alternativ...1. read from file method in saveLoad 2. göra metod med allt
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {

					e.printStackTrace();// Fånga denna senare innan demo är klart GÄLLER ALLA DESSA TRY/CATCH
					// exempel: System.out.printf("BADNESS...",e);
				}
				iGame();
				break;
			case "CHOOSE":

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				// System.out.println("Choose your type charachter..");// ....Disk med
				// Daniel/Johannes senare
				// System.out.println("type your charachter..");// vet inte ifall det funkar som
				// jag tänkt-Michel
				// System.out.println("Knight..");
				// System.out.println("Wizard..");
				// System.out.println("Rogue..");
				heroType = JOptionPane.showInputDialog(

						frame, "Knight\nWizard\nRogue", "Type here ..", JOptionPane.PLAIN_MESSAGE);
				// if the user presses Cancel, this will be null and not properly saved..hmmm
				Hero hero = new Hero(heroType, name);
				// hero.herotype = scanner.next();

				JOptionPane.showConfirmDialog(frame, hero.herotype, " You have chosen: ", 0);
				/*
				 * System.out.println("Choose your type of map..");// När Hero metoden är
				 * klar....Disk med Daniel senare System.out.println("Small..");
				 * System.out.println("Medium.."); System.out.println("Large..");
				 * JOptionPane.showMessageDialog(null, "Type of map of your choice is: ", input,
				 * 0, null); input = JOptionPane.showInputDialog(
				 *
				 * null, "Knight\nWizard\nRogue", JOptionPane.PLAIN_MESSAGE); // if the user
				 * presses Cancel, this will be null and not properly saved..hmmm
				 */
				// System.out.println("Kanske Gå in i Battle metoden direkt här??");
				// System.out.println("Kanske Gå in i choose maps metoden direkt här??");
				break;
			case "MAPS":
				// System.out.println("Choose your map..");// ....Disk med Daniel/Johannes
				// senare
				// System.out.printf("Small-4x4 %d %d", 4, 4);// funkar inte som jag
				// tänkt-Michel
				// System.out.printf("Medium-5x5 %d %d", 5, 5);// funkar inte som jag
				// tänkt-Michel
				// System.out.printf("Large-8x8 %d %d", 8, 8);// funkar inte som jag
				// tänkt-Michel
				// int x,y;

				mapType = JOptionPane.showConfirmDialog(frame, " choose map: ");
				choice = JOptionPane.showInputDialog(

						frame, "Small\nMedium\nLarge", JOptionPane.PLAIN_MESSAGE);// funkar inte i nuläget
				for (Room room : map.room) {
					System.out.println(room.x + " " + room.y);
				}

				map.generateMap(mapType, mapType);
				// if the user presses Cancel, this will be null and not properly saved..hmmm
				JOptionPane.showMessageDialog(frame, "Your map is set to: \n" + choice);// shoud be mapType
				// mapType=JOptionPane.showConfirmDialog(null, "Type of map of your choice is:
				// "+ mapType);
				// System.out.println("Kanske Gå in i Battle metoden direkt här??");
				break;
			case "LOAD":
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				// Alternativ...1. read from file method in saveLoad
				// 2. göra metod med allt

				try {
					save.SerializeDungeonData();
				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame, "DENNA METOD GÖRS SENARE - Load your charachter..");// shoud be
																											// mapType
				// System.out.println("DENNA METOD GÖRS SENARE - Load your charachter..");
				break;
			case "SEE":
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame,
						"DENNA METOD GÖRS SENARE - See highscore(treasure points) charachter..");
				// System.out.println("[S]-DENNA METOD GÖRS SENARE - See highscore(treasure
				// points) charachter..");
				// game.collectTreasures(null, hero.name);
				// Alternativ...1. read from file method in saveLoad 2. göra metod med allt
				break;
			case "READ":

				// Alternativ...1. read from file method in saveLoad 2. göra metod med allt
				ReadChar();
				break;

			case "EXIT":
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame,
						"To bad your leaving\n....\"Come back then you dare to enter the dungeons.....\"");

				System.exit(0);
			case "CANCEL":
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame,
						"To bad your leaving\n....\"Come back then you dare to enter the dungeons.....\"");

				System.exit(0);

			case "READTXT":
				save.readFromtxt();
			default:
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame, "No such option in menu\"\n....\t try again............");
				// System.out.println("No such option in menu");
				// System.out.println("\t try again........");
				break;

			}
		}
		frame.setVisible(true);
	}

	@Override
	public Dimension getPreferredSize() {
		return (new Dimension(image.getWidth(), image.getHeight()));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

///////////////  MAIN
	public static void main(String... args) {

		new GameMenuMain().GameMenuMainstart();

	}
	// END GameMenuMain

	private void setImage(URL path) {
		try {
			System.out.println(path);
			image = ImageIO.read(path);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}

/*
 * ///////////////////////////////// Discussion:
 * \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 1.Should we have Thread.sleep(300); then
 * we print out, see not all text comes at the same time..easier and coolare to
 * read. 2. Check if all character and Monster has right values 3.check so all
 * println is gone, if we gonna use the dialogframe graphics
 * 4.See ifall playerExist?
 * 5.find/load players who exist
 */
