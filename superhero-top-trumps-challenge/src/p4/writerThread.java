package p4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class writerThread implements Runnable {
	
	List <TopTrumpCard> mainDeck;
	
	public writerThread(List <TopTrumpCard> mainDeck) {
		this.mainDeck = mainDeck;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			File file = new File("mainDeck.csv");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (TopTrumpCard topTrumpCard : mainDeck) {
				String line = String.format("%s,%s", topTrumpCard.getName(), topTrumpCard.getRealName());
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
