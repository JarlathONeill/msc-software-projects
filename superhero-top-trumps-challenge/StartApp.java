package p3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import p3.TopTrumpCard;

/**
 * 
 * @author jarlathoneill
 * Jarlath O'Neill / 40387045
 *
 */
public class StartApp {
	
	/**
	 * Entry point of program - no need to modify this method
	 * @param args
	 */
	public static void main(String[] args) {
		showMenu();	
	}
	
	//TODO modify readData method to populate List appropriately - method partially completed already
	//TODO add static methods to this class as required to achieve tasks outlined in menu
	//TODO modify showMenu method to add calls to new methods you write to accomplish the tasks outlined in the menu

	/**
	 * Launches menu system which in turn calls appropriate methods based on user choices
	 * Partially implemented already
	 * requires updating to add calls to other methods written to achieve the tasks described in tasks 3-10
	 */
	public static void showMenu() {
		List<TopTrumpCard> mainDeck = readData();

		System.out.println();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Hero Card Processing");
		do {
			System.out.println("1. (Re)read Data From File (use to restore removed card for example)");
			System.out.println("2. Play Demo Game with Current Deck");
			System.out.println("3. Display the number of Cards in the Current Deck");
			System.out.println("4. Display full details for all cards in the current Deck");
			System.out.println("5. Display summary details of the top 5 strongest Heroes in the Deck");
			System.out.println(
					"6. Display summary details of Villains in the Deck with an agility rating of 75 or more, sorted alphatically by name");
			System.out.println("7. Display the card name and bio of the card/cards with the longest bio in the Deck");
			System.out.println(
					"8. Find Swapsies: Identify and display summary details of any duplicate cards in the Deck");
			System.out.println("9. Remove any duplicate cards from the Deck.");
			System.out.println(
					"10. Sort the deck from highest to lowest determined by average of the 4 main stats. \n\tDisplay summary details of all cards and include the average as part of the summary.");
			System.out.println("11. Quit");
			System.out.println("Write main deck to file");
			System.out.println("Enter option ...");
			option = scanner.nextInt();
			System.out.println();
			switch (option) {

			case 1:
				mainDeck = readData();
				break;
			case 2:
				//System.out.println("Option currently disabled...");
				CardGame.playDemo(mainDeck);
				break;
			case 3:
				//System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				System.out.println("Number of cards in current Deck: " + mainDeck.size() + "\n");
				break;
			case 4:
				//System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				displayFull(mainDeck);
				break;
			case 5:
				//System.out.println("Not yet implemented...");
				findXStrongest(mainDeck, Category.HERO, 5);
				// TODO add required method call(s)
				break;
			case 6:
				//System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				findVillainsWithAg75(mainDeck, Category.VILLAIN, 75);
				break;
			case 7:
				//System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				findLongestBio(mainDeck);
				break;
			case 8:
				//System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				findDupes(mainDeck);
				break;
			case 9:
				//System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				mainDeck = removeDupes(mainDeck);
				break;
			case 10:
				//System.out.println("Not yet implemented...");
				average(mainDeck);
				// TODO add required method call(s)
				break;
			case 11:
				System.out.println("Quitting");
				break;
			case 12:
				writeDeckToFile(mainDeck);
				break;
			default:
				System.out.println("Try options again...");
			}
		} while (option != 11);
		scanner.close();
	}
	
	/**
	 * Writes the current cards in the mainDeck list to a file in a separate thread
	 * @param mainDeck
	 */
	private static void writeDeckToFile(List<TopTrumpCard> mainDeck) {
		// TODO Auto-generated method stub
		writerThread myThread = new writerThread(mainDeck);
		Thread t = new Thread(myThread);
		t.start();
		
	}

//	private static void showMap(List<TopTrumpCard> mainDeck) {
//		// TODO Auto-generated method stub
//		Map <String, TopTrumpCard> trumpMap = new HashMap<String, TopTrumpCard>();
//		int amount = 0;
//		
//		for (TopTrumpCard card : mainDeck) {
//			if (trumpMap.containsKey(card.getImageFileName())) {
//				amount++;
//				
//			} else {
//				trumpMap.put(card.getImageFileName(), new TopTrumpCard(card.getName(), card.getRealName(), card.getImageFileName(), card.getCategory(), card.getSpeed(), card.getStrength(), card.getAgility(), card.getIntelligence(), card.getBio()));
//			}
//		}
//		
//		for (String imageName : trumpMap.keySet()) {
//			System.out.println(imageName + " " +amount);
//		}
//		
//	}
	
	/**
	 * 
	 * @param mainDeck
	 */
	private static void average(List<TopTrumpCard> mainDeck) {
		// TODO Auto-generated method stub
		
		Collections.sort(mainDeck, new CompareAvg());
		
		
		for (TopTrumpCard card : mainDeck) {
			int avg = (card.getSpeed() + card.getStrength() + card.getAgility() + card.getIntelligence()) / 4;
			System.out.println(card.getName() + "\t/\t" + card.getRealName());
			System.out.printf("sp: %d | st: %d | ag: %d | in: %d\n", card.getSpeed(), card.getStrength(), card.getAgility(), card.getIntelligence() );
			System.out.println("Average Stat: " + avg);
			System.out.println();
		}
		
	}
	
	/**
	 * Removes the duplicate cards in the main deck
	 * @param mainDeck
	 * @return
	 */
	private static List<TopTrumpCard> removeDupes(List<TopTrumpCard> mainDeck) {
		// TODO Auto-generated method stub
		Set <TopTrumpCard> localSet = new HashSet<TopTrumpCard>(mainDeck);
		mainDeck.clear();
		
		for (TopTrumpCard card : localSet) {
			mainDeck.add(card);
		}
		return mainDeck;
		
		
	}
	
	/**
	 * Prints to console the duplicate cards in the main deck
	 * @param mainDeck
	 */
	private static void findDupes(List<TopTrumpCard> mainDeck) {
		// TODO Auto-generated method stub
		List <TopTrumpCard> dupes = new ArrayList<TopTrumpCard>();
		Set <TopTrumpCard> setMainDeck = new HashSet<TopTrumpCard>();
		
		for (TopTrumpCard card : mainDeck) {
			if (setMainDeck.contains(card)) {
				dupes.add(card);
			} else {
				setMainDeck.add(card);
			}
			
		}
		
		displaySummary(dupes);
		
	}
	
	/**
	 * Prints to console the card with the longets bio
	 * @param mainDeck
	 */
	private static void findLongestBio(List<TopTrumpCard> mainDeck) {
		// TODO Auto-generated method stub
		Collections.sort(mainDeck, new CompareBioLength());
		
		TopTrumpCard card = Collections.max(mainDeck, new CompareBioLength());
		System.out.println(card.getName());
		System.out.println(card.getBio());
		System.out.println();
		
	}

	/**
	 * Sorted passed in deck alphabetically, then adds cards that are villains and have agility over 75
	 * @param mainDeck
	 * @param villain
	 */
	private static void findVillainsWithAg75(List<TopTrumpCard> mainDeck, Category villain, int agility) {
		// TODO Auto-generated method stub
		List<TopTrumpCard> sortedList = new ArrayList<TopTrumpCard>();
		Collections.sort(mainDeck, new CompareNameAlphabetically());
		
		for (TopTrumpCard card : mainDeck) {
			if (card.getCategory().equals(villain) && card.getAgility() > agility) {
				sortedList.add(card);
			}
		}
		
		displaySummary(sortedList);
	}
	

	/**
	 * Finds the number of strongest cards in the main deck based on category and
	 * number desired passed in
	 * 
	 * @param mainDeck
	 * @param hero
	 * @param i
	 */
	private static void findXStrongest(List<TopTrumpCard> mainDeck, Category hero, int amount) {
		// TODO Auto-generated method stub
		Collections.sort(mainDeck, new CompareStrength());
		List<TopTrumpCard> sortedList = new ArrayList<TopTrumpCard>();

		for (TopTrumpCard card : mainDeck) {
			if (card.getCategory().equals(hero) && sortedList.size() < amount) {
				sortedList.add(card);
			}
		}

		displaySummary(sortedList);
	}

	/**
	 * Prints to console the summary details of each card in the deck passed in
	 * @param inputDeck
	 */
	private static void displaySummary(List<TopTrumpCard> inputDeck) {
		// TODO Auto-generated method stub
		for (TopTrumpCard card : inputDeck) {
			System.out.println(card.getName() + "\t/\t" + card.getRealName());
			System.out.printf("sp: %d | st: %d | ag: %d | in: %d\n\n", card.getSpeed(), card.getStrength(), card.getAgility(), card.getIntelligence() );
			
		}
	}
	
	/**
	 * Prints to console the full details of each card in the deck passed in
	 * @param inputDeck
	 */
	private static void displayFull(List<TopTrumpCard> inputDeck) {
		// TODO Auto-generated method stub
		for (TopTrumpCard card : inputDeck) {
			System.out.println("Name:\t" + card.getName());
			System.out.println("Real Name:\t" + card.getRealName());
			System.out.println("Filename:\t" + card.getImageFileName());
			System.out.println("Category:\t" + card.getCategory());
			System.out.println("Speed:\t" + card.getSpeed());
			System.out.println("Strength:\t" + card.getStrength());
			System.out.println("Agility:\t" + card.getAgility());
			System.out.println("Intelligence:\t" + card.getIntelligence());
			System.out.println("Bio:\t" + card.getBio());
			System.out.println();
		}
		
	}

	/**
	 * Reads in the data from the provided csv and returns a list of TopTrumpCard
	 * objects for further processing - requires updating for full functionality
	 */
	private static List<TopTrumpCard> readData() {

		List<TopTrumpCard> listFromFile = new ArrayList<TopTrumpCard>();

		File file = new File("toptrumpscards.csv"); // hard coded to specific file

		// try with resources - auto closes reader resources when finished/exception
		// occurs
		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr);) {

			String line = reader.readLine(); // discard header
			line = reader.readLine(); // read first line

			while (line != null) {

				// TODO Code to process current line
				String [] parts = line.split(",");
				String name = parts[0];
				String realName = parts[1];
				String imageName = parts[2];
				Category cat = Category.valueOf(parts[3].toUpperCase());
				int speed = Integer.parseInt(parts[4]);
				int strength = Integer.parseInt(parts[5]);
				int agility = Integer.parseInt(parts[6]);
				int intelligence = Integer.parseInt(parts[7]);
				String bio = parts[8];
				
				// TODO instantiate TopTrumpCard object
				TopTrumpCard newCard = new TopTrumpCard(name, realName, imageName, cat, speed, strength, agility, intelligence, bio);
				
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
		return listFromFile;
	}

}
