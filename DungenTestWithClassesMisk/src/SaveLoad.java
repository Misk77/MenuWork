import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveLoad<GameMenuMain> {
	JFrame frame = new JFrame();
	String filepath = "DungenSaves.txt";

	// Hero hero = new Hero(null, null);
	public void saveToDisk(String text) {// need to add the proper arguments, like name and treasure
		// main metoden d�r man skriver in till texten och som h�mtar metoden i
		// writefile classen
		Scanner sc = new Scanner(System.in);// This will be changed so pnly one object of scanner are implementet,maybye
											// should be from GameMenuMain
//String filepath = "DungenSaves.txt";

		WriteFile wf = new WriteFile(filepath, true);
		// Just now its saves player name direct, maybe or also this save then the hero
		// ends a game, same method or another??

		try {

			wf.writeToFile(text);
			JOptionPane.showMessageDialog(frame, "Din data har sparats.");

		}

		catch (IOException e) {

			JOptionPane.showMessageDialog(frame, "Din data har INTE sparats.");

		}

	}// saveTODisk

	public void LoadFromDisk() {

	}// LoadFromDisk

	@SuppressWarnings("unchecked")
	public void SerializeDungeonData() throws IOException, ClassNotFoundException {

		@SuppressWarnings("unchecked")
		JLabel label = new JLabel();
		ArrayList<String> arraySerialized = new ArrayList<String>();
		JOptionPane.showMessageDialog(frame, arraySerialized.add("name "));
		JOptionPane.showMessageDialog(frame, arraySerialized.add("character "));
		JOptionPane.showMessageDialog(frame, arraySerialized.add("Tresure pts "));
		// JLabel label = new JLabel();
		frame.getContentPane().add(BorderLayout.CENTER, label);
		label.setFont(label.getFont().deriveFont(Font.ITALIC | Font.BOLD));
		label.setHorizontalAlignment(JLabel.CENTER);
		JOptionPane.showMessageDialog(frame, "Din data har sparats.");
		JOptionPane.showMessageDialog(frame, "ArrayList to be serialized : " + arraySerialized);
		JOptionPane.showMessageDialog(frame, "serializing the array");
		ObjectOutputStream oos = null;
		JTextArea txtArea = new JTextArea();
		txtArea.setEditable(false);
		frame.add(txtArea);
		try {
			FileOutputStream fout = new FileOutputStream("SaveDungeonRunDATA.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(arraySerialized);
		} finally {
			if (oos != null)
				oos.close();
		}

		// deserialize the ArrayList
		ArrayList<String> arrayUnserialized = new ArrayList<String>();
		JOptionPane.showMessageDialog(frame, "unserializing the array");
		ObjectInputStream ois = null;
		try {
			FileInputStream fin = new FileInputStream("SaveDungeonRunDATA.txt");
			ois = new ObjectInputStream(fin);
			arrayUnserialized = (ArrayList<String>) ois.readObject();
			ois.close();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		JOptionPane.showMessageDialog(frame, "ArrayList unserialized : " + arrayUnserialized);
	}

	public void readFromDisk() {
		JOptionPane.showMessageDialog(frame, "Denna metod ska läsa från en fil ??");
	}

	public void readFromtxt() {
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(filepath);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				JOptionPane.showInputDialog(frame, line, "Load THis character??");

			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			JOptionPane.showInternalConfirmDialog(frame, "Unable to open file '" + filepath + "'");
		} catch (IOException ex) {
			JOptionPane.showInternalConfirmDialog(frame, "Error reading file '" + filepath + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

}// SaveLoad class END
