package p4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Plain old java object class to create Top Trump Card objects
 * @author jarlathoneill
 * Jarlath O'Neill / 40387045
 *
 */
public class TopTrumpCard {
	
	/**
	 * Final int that is used to set lower length of String variables
	 */
	final int STRINGLENGTHONE = 1;
	
	/**
	 * Final int that is used to set upper length of String variables
	 */
	final int STRINGLENGTHTHIRTY = 30;
	
	/**
	 * Final int that is used to set lower length of String variable image file name
	 */
	final int STRINGLENGTHFIVE = 5;
	
	/**
	 * Final int that is used to set lower boundary of attribute variables (e.g. speed)
	 */
	final int ATTRIBUTELOWER = 0;
	
	/**
	 * Final int that is used to set upper boundary of attribute variables (e.g. speed)
	 */
	final int ATTRIBUTERUPPER = 100;
	
	
	


	/**
	 * String variable to hold the name of the Top Trump Card
	 */
	private String name;
	
	/**
	 * String variable to hold the real name of the Top Trump Card
	 */
	private String realName;
	
	/**
	 * String variable to hold the image file name of the Top Trump Card
	 */
	private String imageFileName;
	
	/**
	 * Uses Category enum to hold the category of the Top Trump Card
	 */
	private Category category;
	
	/*
	 * Int variable to hold the speed of the Top Trump Card
	 */
	private int speed;
	
	/*
	 * int variable to hold the strength of the Top Trump Card
	 */
	private int strength;
	
	/*
	 * int variable to hold the agility of the Top Trump Card
	 */
	private int agility;
	
	/*
	 * int variable to hold the intelligence of the Top Trump Card
	 */
	private int intelligence;
	
	/*
	 * String variable to hold the bio of the Top Trump Card
	 */
	private String bio;
	
	
	
	/**
	 * @param name
	 * @param realName
	 * @param imageFileName
	 * @param category
	 * @param speed
	 * @param strength
	 * @param agility
	 * @param intelligence
	 * @param bio
	 * @throws IllegalAccessException 
	 */
	public TopTrumpCard(String name, String realName, String imageFileName, Category category, int speed, int strength,
			int agility, int intelligence, String bio) throws IllegalArgumentException {
		setName(name);
		setRealName(realName);
		setImageFileName(imageFileName);
		setCategory(category);
		setSpeed(speed);
		setStrength(strength);
		setAgility(agility);
		setIntelligence(intelligence);
		setBio(bio);
	}
	
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns true if the passed in string matches the length requirements passed in else false
	 * @param input
	 * @param lower
	 * @param upper
	 * @return
	 * @throws IllegalAccessException
	 */
	private boolean checkString(String input, int lower, int upper){
		if (input.length() < lower || input.length() > upper) {
			return false;
		} else {
			return true;
		}
		
		
	}
	
	/**
	 * @param name the name to set
	 * @throws IllegalAccessException 
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}
		
		if (checkString(name, STRINGLENGTHONE, STRINGLENGTHTHIRTY)) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Name does not match length requirements");
		}
	}

	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName the realName to set
	 * @throws IllegalAccessException 
	 */
	public void setRealName(String realName) throws IllegalArgumentException {
		if (realName == null) {
			throw new IllegalArgumentException("Real name cannot be null");
		}
		
		if (checkString(realName, STRINGLENGTHONE, STRINGLENGTHTHIRTY)) {
			this.realName = realName;
		} else {
			throw new IllegalArgumentException("Real name does not match length requirements");
		}
	}

	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		if (imageFileName == null) {
			throw new IllegalArgumentException("Image file name name cannot be null");
		}
		
		if (checkFileName(imageFileName, STRINGLENGTHFIVE, STRINGLENGTHTHIRTY)) {
			this.imageFileName = imageFileName;
		} else {
			throw new IllegalArgumentException("Image file name does not match requirements");
		}
	}
	
	/**
	 * che
	 * @param imageFileName2
	 * @param sTRINGLENGTHFIVE2
	 * @param sTRINGLENGTHTHIRTY2
	 * @return
	 */
	private boolean checkFileName(String input, int lower, int upper) {
		// TODO Auto-generated method stub
		if (input.length() < STRINGLENGTHFIVE || input.length() > STRINGLENGTHTHIRTY) {
			return false;
		}
		
		String lowerInput = input.toLowerCase();
		if (!input.endsWith(".jpg")) {
			return false;
		}
		
		String validChars = ".abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i<lowerInput.length(); i++) {
			if (validChars.indexOf(lowerInput.charAt(i)) == -1) {
				return false;
			}
		}
		return true;
	}



	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		if (speed >= 0 && speed <= 100) {
			this.speed = speed;
		} else {
			throw new IllegalArgumentException("Speed stat outside 1-100 size requirement");
		}
	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		if (strength >= 0 && strength <= 100) {
			this.strength = strength;
		} else {
			throw new IllegalArgumentException("strength stat outside 1-100 size requirement");
		}
	}

	/**
	 * @return the agility
	 */
	public int getAgility() {
		return agility;
	}

	/**
	 * @param agility the agility to set
	 */
	public void setAgility(int agility) {
		if (agility >= 0 && agility <= 100) {
			this.agility = agility;
		} else {
			throw new IllegalArgumentException("agility stat outside 1-100 size requirement");
		}
	}

	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}

	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(int intelligence) {
		if (intelligence >= 0 && intelligence <= 100) {
			this.intelligence = intelligence;
		} else {
			throw new IllegalArgumentException("intelligence stat outside 1-100 size requirement");
		}
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	/**
	 * Returns a 0, 1, 2, or 3 depending on whether speed, strength, agility 
	 * or intelligence is higher
	 * @return
	 */
	public int getMaxStatID() {
//		int stats[] = {getSpeed(), getStrength(), getAgility(), getIntelligence()};
//		
//		Arrays.sort(stats);
//		
//		if (getSpeed() == stats[3]) {
//			return 0;
//		}else if (getStrength() == stats[3]) {
//			return 1;
//		} else if (getAgility() == stats[3]) {
//			return 2;
//		}else if (getIntelligence() == stats[3]) {
//			return 3;
//		}
//		
//		return -1;
		
		List<Integer> maxStatList = new ArrayList<Integer>(Arrays.asList(getSpeed(), getStrength(), getAgility(), getIntelligence()));
		int newMax = Collections.max(maxStatList);
		
		
		int max = 0;
		int statId = 0;
		for (int i=0; i<maxStatList.size(); i++) {
			int statVal = maxStatList.get(i);
			if (statVal > max) {
				statId = i;
			}
		}
		return statId;
		//return maxStatList.indexOf(newMax);
	}
	
	/**
	 * Expects to receive an input of 0, 1 2 or 3 and return the actual value of the
	 * corresponding attribute Speed, Strength, Agility or Intelligence
	 * @param statChoice
	 * @return
	 */
	public int getStatScore(int statChoice) {
		switch(statChoice) {
		case 0:
			return getSpeed();
		case 1:
			return getStrength();
		case 2:
			return getAgility();
		case 3:
			return getIntelligence();
		}
		return 4;
	
	}



	@Override
	public int hashCode() {
		return Objects.hash(ATTRIBUTELOWER, ATTRIBUTERUPPER, STRINGLENGTHFIVE, STRINGLENGTHONE, STRINGLENGTHTHIRTY,
				agility, bio, category, imageFileName, intelligence, name, realName, speed, strength);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopTrumpCard other = (TopTrumpCard) obj;
		return ATTRIBUTELOWER == other.ATTRIBUTELOWER && ATTRIBUTERUPPER == other.ATTRIBUTERUPPER
				&& STRINGLENGTHFIVE == other.STRINGLENGTHFIVE && STRINGLENGTHONE == other.STRINGLENGTHONE
				&& STRINGLENGTHTHIRTY == other.STRINGLENGTHTHIRTY && agility == other.agility
				&& Objects.equals(bio, other.bio) && category == other.category
				&& Objects.equals(imageFileName, other.imageFileName) && intelligence == other.intelligence
				&& Objects.equals(name, other.name) && Objects.equals(realName, other.realName) && speed == other.speed
				&& strength == other.strength;
	}
	
	public void displayAllDetails() {
		System.out.println("Name: " + getName());
		System.out.println("Real name: " + getRealName());
		System.out.println("Filename: " + getImageFileName());
		System.out.println("Category: " + getCategory());
		System.out.println("Speed: " + getSpeed());
		System.out.println("Strength: " + getStrength());
		System.out.println("Agility: " + getAgility());
		System.out.println("Intelligence: " + getIntelligence());
		System.out.println("Bio: " + getBio());
		System.out.println();
	}
	
	public void displaySummaryDetails() {
		System.out.printf("%s / %s\n", getName(), getRealName());
		System.out.printf("sp: %d | st: %d | ag: %d | in: %d\n\n", getSpeed(), getStrength(), getAgility(), getIntelligence());
	}
	
	

}
