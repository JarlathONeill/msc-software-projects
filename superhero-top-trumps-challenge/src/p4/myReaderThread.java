package p4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class myReaderThread implements Runnable{
	
	public List <TopTrumpCard> listFromFile = new ArrayList<TopTrumpCard>();
	
	public myReaderThread() {
		
	}
	
	

	/**
	 * @return the listFromFile
	 */
	public List<TopTrumpCard> getListFromFile() {
		return listFromFile;
	}



	/**
	 * @param listFromFile the listFromFile to set
	 */
	public void setListFromFile(List<TopTrumpCard> listFromFile) {
		this.listFromFile = listFromFile;
	}



	@Override
	public void run() {
		
		File file = new File("toptrumpscards.csv"); // hard coded to specific file

		// try with resources - auto closes reader resources when finished/exception
		// occurs
		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr);) {

			String line = reader.readLine(); // discard header
			line = reader.readLine(); // read first line

			while (line != null) {
				String[] parts = null;

				// TODO Code to process current line
				String name = parts[0].trim();
				String realName = parts[1].trim();
				String fileName = parts[2].trim();
				Category cat = Category.valueOf(parts[3].toUpperCase());
				int speed = Integer.parseInt(parts[4]);
				int strength = Integer.parseInt(parts[5]);
				int agility = Integer.parseInt(parts[6]);
				int intelligence = Integer.parseInt(parts[7]);
				String bio = parts[8];
				// TODO instantiate TopTrumpCard object
				
				TopTrumpCard newCard = new TopTrumpCard(name, realName, fileName, cat, speed, strength, agility, intelligence, bio);
				
				// TODO and add to list
				listFromFile.add(newCard);

				line = reader.readLine();// attempt to read next line and loop again
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found error");
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("Exception occured");
			System.out.println(listFromFile.size() + " lines read successfully");
			System.out.println(e.getMessage());
		}
		System.out.println(listFromFile.size() + " lines read successfully");
		//return listFromFile;
	}
		
	}


